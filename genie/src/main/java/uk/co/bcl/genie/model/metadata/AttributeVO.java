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
    private LovVO lov;
    private String value;
    //private String lov;

    @Override
    public String toString() {
        return this.name;
    }

    public void setValue(String value) {
        //logger.entry();
        this.value = value;
        //logger.exit();
    }
    
    public String getValue() {
        //logger.entry();
        //logger.exit();
        return value;
    }    
    
    public void setName(String name) {
        //logger.entry();
        this.name = name;
        //logger.exit();
    }

    public String getName() {
        //logger.entry();
        //logger.exit();
        return name;
    }

    public void setType(String type) {
        //logger.entry();
        this.type = type;
        //logger.exit();
    }

    public String getType() {
        //logger.entry();
        //logger.exit();
        return type;
    }

    public void setTitle(String title) {
        //logger.entry();
        this.title = title;
        //logger.exit();
    }

    public String getTitle() {
        //logger.entry();
        //logger.exit();
        return title;
    }

    public void setMaxLength(Integer maxLength) {
        //logger.entry();
        this.maxLength = maxLength;
        //logger.exit();
    }

    public Integer getMaxLength() {
        //logger.entry();
        //logger.exit();
        return maxLength;
    }

    public void setLov(LovVO lov) {
        //logger.entry();
        this.lov = lov;
        //logger.exit();
    }

    public LovVO getLov() {
        //logger.entry();
        //logger.exit();
        return lov;
    }

    public AttributeVO() {
        //logger.entry();
        //logger.exit();
    }
    
    public AttributeVO(AttributeVO original) {
        //logger.entry();
        this.name = original.getName();
        this.type = original.getType();
        this.title = original.getTitle();
        this.maxLength = original.getMaxLength();
        this.lov = new LovVO(original.getLov());
        this.value = original.getValue();
        //logger.exit();
    }
}
