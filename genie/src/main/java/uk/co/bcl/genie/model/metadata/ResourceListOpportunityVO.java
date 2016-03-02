package uk.co.bcl.genie.model.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceListOpportunityVO implements Serializable {
    @SuppressWarnings("compatibility:4859733394612991361")
    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getRootLogger();

    //private List<OpportunityMetaDataVO> Resources = new ArrayList<OpportunityMetaDataVO>();
    private OpportunityMetaDataVO Resources = new OpportunityMetaDataVO();

    //public void setResources(List<OpportunityMetaDataVO> resources) {
    public void setResources(OpportunityMetaDataVO resources) {
        logger.entry();
        this.Resources = resources;
        logger.exit();
    }

    //public List<OpportunityMetaDataVO> getResources() {
    public OpportunityMetaDataVO getResources() {
        logger.entry();
        logger.exit();
        return Resources;
    }
    
    //public ResourceListOpportunityVO(List<OpportunityMetaDataVO> Resources) {
    public ResourceListOpportunityVO(OpportunityMetaDataVO Resources) {
        logger.entry();
        this.Resources = Resources;
        logger.exit();
    }
    
    public ResourceListOpportunityVO() {
        logger.entry();
        logger.exit();
    }
    
    
    @Override
    public String toString() {

        logger.entry();

        Field[] fields = this.getClass().getDeclaredFields();

        StringBuilder outputItems = new StringBuilder();
        StringBuilder output = new StringBuilder();

/*
        logger.debug("printing " + this.Resources.size() + " children");
        
        for (OpportunityMetaDataVO item : this.Resources) {
            if (outputItems.length() != 0) {
                outputItems.append(", ");
            }

            outputItems.append(item.toString());
        }*/

        logger.debug("printing fields");
        output.append("\"Resources\" : [" + outputItems + "]");

        for (Field f : fields) {
            logger.debug("Field: " + f.toString());

            Class t = f.getType();
            if (!(t == Logger.class)) {

                if (output.length() != 0) {
                    output.append(", ");
                }
                
                Object v;
                try {
                    v = f.get(this);
                } catch (IllegalAccessException e) {
                    v = "null";
                }

                output.append("\"" + f.getName() + "\" : ");

                if (t == boolean.class)
                    output.append(Boolean.TRUE.equals(v));
                else if (t == String.class)
                    output.append("\"" + v + "\"");
                else
                    output.append("ERROR");//v.toString());
            }
        }

        logger.exit();
        
        return "{" + output + "}";
    }
    
    


}


/*
 * {
  "Resources" : {
    "opportunities" : {
      "discrColumnType" : false,
      "title" : "Opportunity",
      "titlePlural" : "Opportunities",
      "attributes" : [ {
        "name" : "BudgetAvailableDate",
        "type" : "string",
        "updatable" : true,
        "mandatory" : false,
        "queryable" : true,
        "allowChanges" : "always",
        "title" : "Date Budget Available",
        "properties" : {
          "ExtnEventActionProperty" : "UpdateInFieldUpdate",
          "fnd:OSN_ENABLED_ATTR" : "true",
          "fnd:OSN_ENABLED_ATTR_CUST" : "true",
          "fnd:OSN_GADGET_TYPE" : "date",
          "fnd:FND_AUDIT_ATTR_ENABLED" : "true"
        }
      }
*/