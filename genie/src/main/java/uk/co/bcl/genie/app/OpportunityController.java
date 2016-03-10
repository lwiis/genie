package uk.co.bcl.genie.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.co.bcl.genie.model.SalesCloudOpportunityVO;
import uk.co.bcl.genie.model.metadata.AttributeVO;
import uk.co.bcl.genie.utils.SalesCloudRestTemplate;

public class OpportunityController {

    static Logger logger = LogManager.getRootLogger();

    static String resourceBaseUri =
        "https://cbgl-test.crm.us2.oraclecloud.com/salesApi/resources/11.1.10/opportunities";

    static SalesCloudRestTemplate restTemplate = new SalesCloudRestTemplate("SMILLS", "X9NYSQqX");


    public static void main(String args[]) {
        logger.entry();
        
        //List<AttributeVO> salesCloudOpportunityAttributes = new ArrayList<AttributeVO>();
        //salesCloudOpportunityAttributes = getSalesCloudOpportunityFields();
        List<SalesCloudOpportunityVO> result = getAllSalesCloudOpportunities();
        //getSalesCloudOpportunity("Ase_0020");
        //getFieldsMap(SalesCloudOpportunityVO.class);
        //getSalesCloudOpportunityDesc();
        
        logger.debug(String.join(",",result.get(0).getFieldsAsList()));
        logger.exit();
    }

    public static SalesCloudOpportunityVO getSalesCloudOpportunity(String optyNumber) {
        logger.entry();

        //String params = "?onlyData=true&fields=" + (new SalesCloudOpportunityVO()).getFieldsAsString();
        String params = "?onlyData=true";
            
        String resourceUri = resourceBaseUri + "/" + optyNumber + params;
        logger.info("Getting " + resourceUri);

        JsonNode response = restTemplate.getForObject(resourceUri, JsonNode.class);
        
        List<AttributeVO> templateAttributes = new ArrayList<AttributeVO>(getSalesCloudOpportunityFields());
        SalesCloudOpportunityVO salesCloudOpportunity = new SalesCloudOpportunityVO(response, templateAttributes);

        logger.exit();

        return salesCloudOpportunity;
    }

    public static List<SalesCloudOpportunityVO> getAllSalesCloudOpportunities() {
        logger.entry();
        logger.exit();
        List<AttributeVO> templateAttributes = new ArrayList<AttributeVO>(getSalesCloudOpportunityFields());
        return getAllSalesCloudOpportunities(new ArrayList<SalesCloudOpportunityVO>(), templateAttributes, 25, 0);
    }

    public static List<SalesCloudOpportunityVO> getAllSalesCloudOpportunities(List<SalesCloudOpportunityVO> items, List<AttributeVO> templateAttributes, Integer limit, Integer offset) {
        logger.entry();

        //TODO is there some URI class that takes care of all the "/"?
        //Added Creation data to enforce query sequence. Documentation says order is not guaranteed unless orderBy is used
        //https://docs.oracle.com/cloud/latest/salescs_gs/FAURS.pdf

        List<SalesCloudOpportunityVO> itemsOutput = new ArrayList<SalesCloudOpportunityVO>(items);

        //String params = "?q=StatusCode!=OPEN&orderBy=CreationDate&limit=" + limit + "&offset=" + offset + "&onlyData=true&fields=" + (new SalesCloudOpportunityVO()).getFieldsAsString();
        String params = "?q=StatusCode!=OPEN&orderBy=CreationDate&limit=" + limit + "&offset=" + offset + "&onlyData=true";
                    
        String resourceUri = resourceBaseUri + params;
                
        logger.info("Getting " + resourceUri);

        JsonNode response = restTemplate.getForObject(resourceUri, JsonNode.class);
        JsonNode tempItems = response.path("items");

        logger.debug(response.toString());
        logger.debug("count: " + response.get("count"));
        logger.debug("limit: " + response.get("limit"));
        logger.debug("offset: " + response.get("offset"));
        logger.debug("totalResults: " + response.get("totalResults"));
        logger.debug("hasMore: " + response.get("hasMore"));
        
        if(tempItems.isArray()) {
            for (final JsonNode item : tempItems) {
                SalesCloudOpportunityVO tempOpty = new SalesCloudOpportunityVO(item, templateAttributes);
                itemsOutput.add(tempOpty);
            }
        }
        
        logger.debug("Total records: " + itemsOutput.size());

        if (response.get("hasMore").asBoolean()) {
            logger.debug("More records found...");
            itemsOutput = getAllSalesCloudOpportunities(itemsOutput, templateAttributes, limit, offset + limit);
        }

                
        logger.exit();

        return itemsOutput;
    }
    
    private static String getSalesCloudOpportunityDesc() {
        logger.entry();
        
        String result = "empty";

        Boolean saveResult = true;
        
        String nominalPath = "/home/luisfilipe/jdeveloper/mywork/Genie/SalesCloudOpportunityDesc.json";
        File newTextFile = new File(nominalPath);
                
        if(newTextFile.exists()){
            logger.debug("File " + nominalPath + " already exists. Reading from file...");
            
            try(FileInputStream inputStream = new FileInputStream(nominalPath); 
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8.name()))) {
                    
                StringBuilder sb = new StringBuilder(8192);
                String str = br.readLine();
                while (str != null) {
                    sb.append(str);
                    str = br.readLine();
                }
                        
                result = sb.toString();
            } catch (IOException e) {
                logger.error(e.toString());
            }
            
        }
        else {  
            logger.debug("File " + nominalPath + " does not exist. Calling web service...");
            String params = "/describe";    
            String resourceUri = resourceBaseUri + params;
            
            logger.info("Getting " + resourceUri);
    
            String response = restTemplate.getForObject(resourceUri, String.class);
            
            if(saveResult) {
                logger.debug("Writing result to file " + nominalPath);
                FileWriter fileWriter;
                try {
                    fileWriter = new FileWriter(newTextFile);
                    fileWriter.write(response);
                    fileWriter.close();
                } catch (IOException e) {
                    logger.error(e.toString());
                }
            }
            
            result = response;
        }
        
        logger.exit();
    
        return result;
    }
    
    private static List<AttributeVO> getSalesCloudOpportunityFields() {
        logger.entry();
        List<AttributeVO> fieldAttributes = new ArrayList<AttributeVO>();
        
        ObjectMapper objectMapper = new ObjectMapper();
    
        try {
            String descString = getSalesCloudOpportunityDesc();
            JsonNode node = objectMapper.readValue(descString, JsonNode.class); 
            
            JsonNode attributes = node.path("Resources").path("opportunities").path("attributes");
            if(attributes.isArray()) {
                for (final JsonNode attribute : attributes) {
                    AttributeVO fieldAttribute;
                    fieldAttribute = objectMapper.treeToValue(attribute, AttributeVO.class);
                    fieldAttributes.add(fieldAttribute);
                }
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        logger.exit();
        
        return fieldAttributes;
    }
}
