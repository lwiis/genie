package uk.co.bcl.genie.model.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeVO implements Serializable {
    @SuppressWarnings("compatibility:-4652948943457922614")
    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getRootLogger();

    private String name;
    private String type;
    private String title;
    private Integer maxLength;
    private String lov;

    @Override
    public String toString() {
        return this.name;
    }

    public void setName(String name) {
        logger.entry();
        this.name = name;
        logger.exit();
    }

    public String getName() {
        logger.entry();
        logger.exit();
        return name;
    }

    public void setType(String type) {
        logger.entry();
        this.type = type;
        logger.exit();
    }

    public String getType() {
        logger.entry();
        logger.exit();
        return type;
    }

    public void setTitle(String title) {
        logger.entry();
        this.title = title;
        logger.exit();
    }

    public String getTitle() {
        logger.entry();
        logger.exit();
        return title;
    }

    public void setMaxLength(Integer maxLength) {
        logger.entry();
        this.maxLength = maxLength;
        logger.exit();
    }

    public Integer getMaxLength() {
        logger.entry();
        logger.exit();
        return maxLength;
    }

    public void setLov(String lov) {
        logger.entry();
        this.lov = lov;
        logger.exit();
    }

    public String getLov() {
        logger.entry();
        logger.exit();
        return lov;
    }


    public AttributeVO(String name, String type, String title, Integer maxLength, String lov) {
        logger.entry();
        this.name = name;
        this.type = type;
        this.title = title;
        this.maxLength = maxLength;
        this.lov = lov;
        logger.exit();
    }
    
    public AttributeVO() {
        logger.entry();
        logger.exit();
    }
}
