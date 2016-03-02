package uk.co.bcl.genie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SalesCloudOpportunityVO extends RecordVO implements Serializable {

    @SuppressWarnings("compatibility:6195159464576370139")
    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getRootLogger();

    // field names start with caps because of the way Sales Cloud names the fields
    // and it was a hassle to keep "translating" between initial caps and camel case.
    private String PrimaryOrganizationId, SalesMethod, SalesStage, OptyId, OptyNumber, StatusCode, PrimaryCompetitorId, OwnerResourcePartyId, TargetPartyId;

    // TODO: how to take timezones into consideration?
    private Date EffectiveDate;
        
    private Date LastUpdateDate;
    
    private Double Revenue, WinProb;

    private Boolean BudgetedFlag;
    
    private Double daysSinceLastUpdate;
    
    public Double getDaysSinceLastUpdate() {
        logger.entry();
        logger.exit();
        return daysSinceLastUpdate;
    }

    public SalesCloudOpportunityVO() {
        logger.entry();
        logger.exit();
    }

    public SalesCloudOpportunityVO(String primaryOrganizationId, String salesMethod, String salesStage,
                                   String optyId, String optyNumber, String statusCode, String ownerResourcePartyId,
                                   String targetPartyId) {
        logger.entry();

        this.PrimaryOrganizationId = primaryOrganizationId;
        this.SalesMethod = salesMethod;
        this.SalesStage = salesStage;
        this.OptyId = optyId;
        this.OptyNumber = optyNumber;
        this.StatusCode = statusCode;
        this.OwnerResourcePartyId = ownerResourcePartyId;
        this.TargetPartyId = targetPartyId;
        this.Revenue = 0.0;
        this.WinProb = 0.0;
        this.BudgetedFlag = false;

        logger.exit();
    }

    public SalesCloudOpportunityVO(String primaryOrganizationId, String salesMethodId, String salesStageId,
                                   String optyId, String optyNumber, String statusCode, String primaryCompetitorId,
                                   String ownerResourcePartyId, String targetPartyId, Date effectiveDate,
                                   Date lastUpdateDate, Double revenue, Double winProb, Boolean budgetedFlag) {
        logger.entry();

        this.PrimaryOrganizationId = primaryOrganizationId;
        this.SalesMethod = salesMethodId;
        this.SalesStage = salesStageId;
        this.OptyId = optyId;
        this.OptyNumber = optyNumber;
        this.StatusCode = statusCode;
        this.PrimaryCompetitorId = primaryCompetitorId;
        this.OwnerResourcePartyId = ownerResourcePartyId;
        this.TargetPartyId = targetPartyId;
        this.EffectiveDate = effectiveDate;
        this.LastUpdateDate = lastUpdateDate;
        this.Revenue = revenue;
        this.WinProb = winProb;
        this.BudgetedFlag = budgetedFlag;

        logger.exit();
    }

    @JsonProperty("PrimaryOrganizationId")
    public void setPrimaryOrganizationId(String primaryOrganizationId) {
        logger.entry();
        this.PrimaryOrganizationId = primaryOrganizationId;
        logger.exit();
    }

    public String getPrimaryOrganizationId() {
        logger.entry();
        logger.exit();
        return PrimaryOrganizationId;
    }

    @JsonProperty("SalesMethod")
    public void setSalesMethod(String salesMethod) {
        logger.entry();
        this.SalesMethod = salesMethod;
        logger.exit();
    }

    public String getSalesMethod() {
        logger.entry();
        logger.exit();
        return SalesMethod;
    }

    @JsonProperty("SalesStage")
    public void setSalesStage(String salesStage) {
        logger.entry();
        this.SalesStage = salesStage;
        logger.exit();
    }

    public String getSalesStage() {
        logger.entry();
        logger.exit();
        return SalesStage;
    }

    @JsonProperty("OptyId")
    public void setOptyId(String optyId) {
        logger.entry();
        this.OptyId = optyId;
        logger.exit();
    }

    public String getOptyId() {
        logger.entry();
        logger.exit();
        return OptyId;
    }

    @JsonProperty("OptyNumber")
    public void setOptyNumber(String optyNumber) {
        logger.entry();
        this.OptyNumber = optyNumber;
        logger.exit();
    }

    public String getOptyNumber() {
        logger.entry();
        logger.exit();
        return OptyNumber;
    }

    @JsonProperty("StatusCode")
    public void setStatusCode(String statusCode) {
        logger.entry();
        this.StatusCode = statusCode;
        logger.exit();
    }

    public String getStatusCode() {
        logger.entry();
        logger.exit();
        return StatusCode;
    }

    @JsonProperty("PrimaryCompetitorId")
    public void setPrimaryCompetitorId(String primaryCompetitorId) {
        logger.entry();
        this.PrimaryCompetitorId = primaryCompetitorId;
        logger.exit();
    }

    public String getPrimaryCompetitorId() {
        logger.entry();
        logger.exit();
        return PrimaryCompetitorId;
    }

    @JsonProperty("OwnerResourcePartyId")
    public void setOwnerResourcePartyId(String ownerResourcePartyId) {
        logger.entry();
        this.OwnerResourcePartyId = ownerResourcePartyId;
        logger.exit();
    }

    public String getOwnerResourcePartyId() {
        logger.entry();
        logger.exit();
        return OwnerResourcePartyId;
    }

    @JsonProperty("TargetPartyId")
    public void setTargetPartyId(String targetPartyId) {
        logger.entry();
        this.TargetPartyId = targetPartyId;
        logger.exit();
    }

    public String getTargetPartyId() {
        logger.entry();
        logger.exit();
        return TargetPartyId;
    }

    @JsonProperty("EffectiveDate")
    public void setEffectiveDate(Date effectiveDate) {
        logger.entry();
        this.EffectiveDate = effectiveDate;
        logger.exit();
    }

    public Date getEffectiveDate() {
        logger.entry();
        logger.exit();
        return EffectiveDate;
    }

    @JsonProperty("LastUpdateDate")
    public void setLastUpdateDate(Date lastUpdateDate) {
        logger.entry();
        this.LastUpdateDate = lastUpdateDate;
        
        //DateTime dt = ISODateTimeFormat.dateTime().parseDateTime(lastUpdateDate);
        Date now = Calendar.getInstance().getTime();
        this.daysSinceLastUpdate = new Long(now.getTime() - lastUpdateDate.getTime()).doubleValue()/1000/60/60/24;
        
        logger.exit();
    }

    public Date getLastUpdateDate() {
        logger.entry();
        logger.exit();
        return LastUpdateDate;
    }

    @JsonProperty("Revenue")
    public void setRevenue(Double revenue) {
        logger.entry();
        this.Revenue = revenue;
        logger.exit();
    }

    public Double getRevenue() {
        logger.entry();
        logger.exit();
        return Revenue;
    }

    @JsonProperty("WinProb")
    public void setWinProb(Double winProb) {
        logger.entry();
        this.WinProb = winProb;
        logger.exit();
    }

    public Double getWinProb() {
        logger.entry();
        logger.exit();
        return WinProb;
    }

    @JsonProperty("BudgetedFlag")
    public void setBudgetedFlag(Boolean budgetedFlag) {
        logger.entry();
        this.BudgetedFlag = budgetedFlag;
        logger.exit();
    }

    public Boolean getBudgetedFlag() {
        logger.entry();
        logger.exit();
        return BudgetedFlag;
    }

    public String toJsonString() {

        logger.entry();

        StringBuilder output = new StringBuilder();
        String value = "null";

        for (Map.Entry<String, Object> entry : this.toHashMap().entrySet()) {
            logger.debug("Field: " + entry.getKey() + " (" + entry.getValue().getClass() + ")");
            logger.debug("Value: " + entry.getValue());

            if (output.length() != 0) {
                output.append(", ");
            }

            if (entry.getValue().getClass() == boolean.class)
                value = Boolean.TRUE.equals(entry.getValue()) ? "true" : "false";
            else if (entry.getValue().getClass() == String.class)
                value = "\"" + entry.getValue() + "\"";
            else if (entry.getValue().getClass() == Date.class) {
                Date temp = (Date) entry.getValue();
                value = new Long(temp.getTime()).toString();
            }
            else
                value = entry.getValue().toString();

            output.append("\"" + entry.getKey() + "\" : " + value);

        }

        logger.exit();

        return "{" + output + "}";
    }

    @Override
    public String toString() {
        return toJsonString();
    }

    public String getFieldsAsString() {
        logger.entry();

        String output = String.join(",", this.toHashMap().keySet());
        logger.debug(output);

        logger.exit();

        return output;
    }
    
    public ArrayList<String> getFieldsAsList() {
        ArrayList<String> temp = new ArrayList<String>();
        temp.addAll(this.toHashMap().keySet());
        return temp;
    }

    public String getDataAsString() {
        logger.entry();

        String output =
            this.toHashMap().values().parallelStream()
            .map(item -> {
                 if(item == "null") return "?";
                 else if(item.getClass() == String.class)
                     return "\"" + item + "\"";
                 else if (item.getClass() == Date.class)
                     return new Long(((Date) item).toInstant().toEpochMilli()).toString();
                else 
                     return item.toString();})
            .reduce(( acc, item) -> acc + "," + item).get();

        logger.debug(output);

        logger.exit();

        return output;
    }

    private HashMap<String, Object> toHashMap() {
        logger.entry();

        Field[] fields = this.getClass().getDeclaredFields();

        HashMap<String, Object> output = new HashMap<String, Object>();

        for (Field f : fields) {
            logger.debug("Field: " + f.toString());

            Class t = f.getType();
            if (!(t == Logger.class) && !(f.getName() == "serialVersionUID")) {

                Object v;
                try {
                    v = f.get(this);
                    logger.debug("field had value for this object");
                } catch (IllegalAccessException e) {
                    logger.debug("field did not have value for this object");
                    v = "null";
                }

                if (v == null)
                    v = "null";

                output.put(f.getName(), v);                    
            }
        }

        logger.exit();

        return output;
    }
}

/*
 * 
 {
  "BudgetAvailableDate" : null,
  "BudgetedFlag" : false,
  "PrimaryOrganizationId" : 300000000748008,
  "ChampionFlag" : false,
  "CreatedBy" : "DNYEKO",
  "CreationDate" : "2015-09-10T10:55:06+00:00",
  "CurrencyCode" : "GBP",
  "SalesMethodId" : 300000000118806,
  "SalesStageId" : 300000000118813,
  "CustomerAccountId" : null,
  "DealHorizonCode" : null,
  "DecisionLevelCode" : null,
  "Description" : null,
  "LastUpdateDate" : "2015-11-11T18:32:49+00:00",
  "LastUpdatedBy" : "ASENSIER",
  "LastUpdateLogin" : "-1",
  "Name" : "Everpin Full Service Package",
  "OptyId" : 100000000219377,
  "OptyNumber" : "OPP_SAMPLE_CSV_0004",
  "OwnerResourcePartyId" : 300000010397637,
  "PrimaryCompetitorId" : null,
  "KeyContactId" : 100000000217446,
  "ReasonWonLostCode" : null,
  "RiskLevelCode" : null,
  "StatusCode" : "OPEN",
  "StrategicLevelCode" : null,
  "PrimaryRevenueId" : 100000000220119,
  "TargetPartyId" : 100000000218234,
  "TargetPartyName" : "Everpin",
  "SalesMethod" : "Standard Sales Process",
  "SalesStage" : "03 - Building Vision",
  "DescriptionText" : "Building Case for ROI with our Sponsor.",
  "AverageDaysAtStage" : 30,
  "MaximumDaysInStage" : 800,
  "PhaseCd" : "WORKING-DEAL",
  "QuotaFactor" : 2,
  "RcmndWinProb" : 40,
  "StageStatusCd" : "OPEN",
  "StgOrder" : 3,
  "EffectiveDate" : "2015-10-15",
  "Revenue" : 10000,
  "WinProb" : 60,
  "PrimaryContactPartyName" : "Frankie Fredericks",
  "PrimaryContactFormattedPhoneNumber" : null,
  "PrimaryContactEmailAddress" : null,
  "Comments" : null,
  "PartyName1" : "Nick Hollins",
  "PrSrcNumber" : null,
  "DownsideAmount" : 0,
  "UpsideAmount" : 10000,
  "EmailAddress" : "salesclouddemo@boxfusionconsulting.com",
  "ExpectAmount" : 6000,
  "ForecastOverrideCode" : "CRITERIA",
  "SalesChannelCd" : "ZPM_DIRECT_CHANNEL_TYPES",
  "LineOfBusinessCode" : null,
  "PartyUniqueName1" : null,
  "SalesAccountUniqueName" : " ",
  "PrimaryPartnerOrgPartyName" : null,
  "PrimaryPartnerId" : null,
  "RegistrationStatus" : null,
  "RegistrationType" : null,
  "Registered" : null,
  "UpdateFlag" : false,
  "DeleteFlag" : false,
  "PRINT" : null,
  "links" : [ {
    "rel" : "self",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004",
    "name" : "opportunities",
    "kind" : "item",
    "properties" : {
      "changeIndicator" : "ACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000002770400000010737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787200106A6176612E6C616E672E4F626A656374000000000000000000000078700000001F7371007E00020000001D78"
    }
  }, {
    "rel" : "canonical",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004",
    "name" : "opportunities",
    "kind" : "item"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/SalesStageLOV",
    "name" : "SalesStageLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/CustomerAccountPickerVO",
    "name" : "CustomerAccountPickerVO",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/LobForSearchLookupPVO",
    "name" : "LobForSearchLookupPVO",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/OptyStrategicValueLOV",
    "name" : "OptyStrategicValueLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/RevenueSalesChannelLookupVO",
    "name" : "RevenueSalesChannelLookupVO",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/RegisteredLookupPVO",
    "name" : "RegisteredLookupPVO",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/RegistrationStatusLookupPVO",
    "name" : "RegistrationStatusLookupPVO",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/OptyDecisionLevelLOV",
    "name" : "OptyDecisionLevelLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/RatedCurrenciesVO",
    "name" : "RatedCurrenciesVO",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/OptyRiskLevelLOV",
    "name" : "OptyRiskLevelLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/FrcstOverrideCodeLOV",
    "name" : "FrcstOverrideCodeLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/YesNoLOV",
    "name" : "YesNoLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/BusinessUnitPVO",
    "name" : "BusinessUnitPVO",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/RegistrationTypeLookupPVO",
    "name" : "RegistrationTypeLookupPVO",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/OptyStatusZbsValuesLOV",
    "name" : "OptyStatusZbsValuesLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/SalesMethodLOV",
    "name" : "SalesMethodLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/PartnerPickerVA",
    "name" : "PartnerPickerVA",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/ReasonWonLostLOV",
    "name" : "ReasonWonLostLOV",
    "kind" : "collection"
  }, {
    "rel" : "lov",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/lov/OptyDealHorizonLOV",
    "name" : "OptyDealHorizonLOV",
    "kind" : "collection"
  }, {
    "rel" : "child",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/child/RevenuePartnerPrimary",
    "name" : "RevenuePartnerPrimary",
    "kind" : "collection"
  }, {
    "rel" : "child",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/child/OpportunityResource",
    "name" : "OpportunityResource",
    "kind" : "collection"
  }, {
    "rel" : "child",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/child/OpportunitySource1",
    "name" : "OpportunitySource1",
    "kind" : "collection"
  }, {
    "rel" : "child",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/child/OpportunityCompetitor2",
    "name" : "OpportunityCompetitor2",
    "kind" : "collection"
  }, {
    "rel" : "child",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/child/Note",
    "name" : "Note",
    "kind" : "collection"
  }, {
    "rel" : "child",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/child/OpportunityLead",
    "name" : "OpportunityLead",
    "kind" : "collection"
  }, {
    "rel" : "child",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/child/OpportunityContact",
    "name" : "OpportunityContact",
    "kind" : "collection"
  }, {
    "rel" : "child",
    "href" : "https://cbgl-test.crm.us2.oraclecloud.com:443/salesApi/resources/11.1.10/opportunities/OPP_SAMPLE_CSV_0004/child/ChildRevenue",
    "name" : "ChildRevenue",
    "kind" : "collection"
  } ]
}
 * 
 */