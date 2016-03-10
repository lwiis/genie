package uk.co.bcl.genie.model.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LovVO implements Serializable {
    @SuppressWarnings("compatibility:4443127755754609746")
    private static final long serialVersionUID = 1L;


    static Logger logger = LogManager.getRootLogger();

    private String childRef;
    private List<String> displayAttributes = new ArrayList<String>();

    @Override
    public String toString() {
        return this.childRef;
    }

    public void setChildRef(String name) {
        //logger.entry();
        this.childRef = name;
        //logger.exit();
    }

    public String getChildRef() {
        //logger.entry();
        //logger.exit();
        return childRef;
    }

    public void setDisplayAttributes(List<String> displayAttributes) {
        //logger.entry();
        this.displayAttributes = displayAttributes;
        //logger.exit();
    }

    public List<String> getDisplayAttributes() {
        //logger.entry();
        //logger.exit();
        return displayAttributes;
    }

    public LovVO() {
        //logger.entry();
        //logger.exit();
    }
    
    public LovVO(LovVO original) {
        //logger.entry();
        if(original != null) {
            //logger.debug("Copying from " + original.toString());
            this.childRef = original.getChildRef();
            this.displayAttributes = new ArrayList<String>(original.getDisplayAttributes());
        }
        //logger.exit();
    }
}

