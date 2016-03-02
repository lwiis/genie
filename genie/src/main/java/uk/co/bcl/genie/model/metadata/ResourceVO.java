package uk.co.bcl.genie.model.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceVO implements Serializable {
    @SuppressWarnings("compatibility:-5235278925760615687")
    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getRootLogger();

    private String title;
    private String titlePlural;
    private List<AttributeVO> attributes;

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

    public void setTitlePlural(String titlePlural) {
        logger.entry();
        this.titlePlural = titlePlural;
        logger.exit();
    }

    public String getTitlePlural() {
        logger.entry();
        logger.exit();
        return titlePlural;
    }

    public void setAttributes(List<AttributeVO> attributes) {
        logger.entry();
        this.attributes = attributes;
        logger.exit();
    }

    public List<AttributeVO> getAttributes() {
        logger.entry();
        logger.exit();
        return attributes;
    }
    


    /*
     * {
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
          }, {
            "name" : "BudgetedFlag",
            "type" : "boolean",
            "updatable" : true,
            "mandatory" : false,
            "queryable" : true,
            "allowChanges" : "always",
            "precision" : 1,
            "defaultValue" : "N",
            "title" : "Budgeted",
            "controlType" : "choice",
            "maxLength" : "1",
            "properties" : {
              "ExtnEventActionProperty" : "UpdateInFieldUpdate",
              "fnd:OSN_ENABLED_ATTR" : "true",
              "fnd:OSN_ENABLED_ATTR_CUST" : "true",
              "JboValueMapProperty" : "oracle.jbo.valuemaps.BooleanYNPropertySet",
              "fnd:FND_AUDIT_ATTR_ENABLED" : "true"
            },
            "lov" : {
              "childRef" : "YesNoLOV",
              "attributeMap" : [ {
                "source" : "LookupCode",
                "target" : "BudgetedFlag"
              } ],
              "displayAttributes" : [ "Meaning" ]
            }
          }
     */
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