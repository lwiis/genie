package uk.co.bcl.genie.utils;

import java.io.IOException;

import java.net.URI;

import java.nio.charset.Charset;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.util.Base64Utils;
import org.springframework.util.ClassUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Convenient subclass of {@link RestTemplate} that is suitable for integration tests.
 * They are fault tolerant, and optionally can carry Basic authentication headers. If
 * Apache Http Client 4.3.2 or better is available (recommended) it will be used as the
 * client, and by default configured to ignore cookies and redirects.
 *
 * @author Dave Syer
 * @author Phillip Webb
 */
public class SalesCloudRestTemplate extends RestTemplate {

    Logger logger = LogManager.getRootLogger();

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    /**
     * Create a new {@link TestRestTemplate} instance.
     * @param httpClientOptions client options to use if the Apache HTTP Client is used
     */
    public SalesCloudRestTemplate(HttpClientOption... httpClientOptions) {
        this(null, null, httpClientOptions);
        logger.exit();
    }

    /**
     * Create a new {@link TestRestTemplate} instance with the specified credentials.
     * @param username the username to use (or {@code null})
     * @param password the password (or {@code null})
     * @param httpClientOptions client options to use if the Apache HTTP Client is used
     */
    public SalesCloudRestTemplate(String username, String password, HttpClientOption... httpClientOptions) {
        logger.entry();
        if (ClassUtils.isPresent("org.apache.http.client.config.RequestConfig", null)) {
            logger.info("Client options included: " + httpClientOptions.toString());
            setRequestFactory(new CustomHttpComponentsClientHttpRequestFactory(httpClientOptions));
        } else {
            logger.info("No client options included.");
        }
        addAuthentication(username, password);
        setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
            }
        });
        logger.exit();
    }

    private void addAuthentication(String username, String password) {
        logger.entry();
        logger.debug("Adding authentication: " + username + "/********");
        if (username == null) {
            return;
        }
        List<ClientHttpRequestInterceptor> interceptors =
            Collections.<ClientHttpRequestInterceptor>singletonList(new BasicAuthorizationInterceptor(username,
                                                                                                      password));
        setRequestFactory(new InterceptingClientHttpRequestFactory(getRequestFactory(), interceptors));
        logger.exit();
    }

    /**
     * Options used to customize the Apache Http Client if it is used.
     */
    public enum HttpClientOption {

        /**
         * Enable cookies.
         */
        ENABLE_COOKIES,

        /**
         * Enable redirects.
         */
        ENABLE_REDIRECTS

    }

    private static class BasicAuthorizationInterceptor implements ClientHttpRequestInterceptor {
        Logger logger = LogManager.getRootLogger();

        private final String username;

        private final String password;

        BasicAuthorizationInterceptor(String username, String password) {
            this.username = username;
            this.password = (password == null ? "" : password);
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                            ClientHttpRequestExecution execution) throws IOException {
            logger.entry();
            String token = Base64Utils.encodeToString((this.username + ":" + this.password).getBytes(UTF_8));
            logger.debug("AuthorizationToken = " + token);
            request.getHeaders().add("Authorization", "Basic " + token);
            logger.debug("Headers = " + request.getHeaders().toString());
            logger.exit();
            return execution.execute(request, body);
        }

    }

    /**
     * {@link HttpComponentsClientHttpRequestFactory} to apply customizations.
     */
    protected static class CustomHttpComponentsClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {
        Logger logger = LogManager.getRootLogger();

        private final String cookieSpec;

        private final boolean enableRedirects;

        public CustomHttpComponentsClientHttpRequestFactory(HttpClientOption[] httpClientOptions) {
            logger.entry();
            Set<HttpClientOption> options =
                new HashSet<SalesCloudRestTemplate.HttpClientOption>(Arrays.asList(httpClientOptions));
            this.cookieSpec =
                (options.contains(HttpClientOption.ENABLE_COOKIES) ? CookieSpecs.STANDARD : CookieSpecs.IGNORE_COOKIES);
            this.enableRedirects = options.contains(HttpClientOption.ENABLE_REDIRECTS);
            logger.exit();
        }

        @Override
        protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
            logger.entry();
            HttpClientContext context = HttpClientContext.create();
            context.setRequestConfig(getRequestConfig());
            logger.exit();
            return context;
        }

        protected RequestConfig getRequestConfig() {
            logger.entry();
            Builder builder =
                RequestConfig.custom().setCookieSpec(this.cookieSpec).setAuthenticationEnabled(false).setRedirectsEnabled(this.enableRedirects);
            logger.exit();
            return builder.build();
        }

    }

}

