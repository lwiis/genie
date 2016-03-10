package uk.co.bcl.genie.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.co.bcl.genie.model.metadata.AttributeVO;


public class SalesCloudOpportunityVO extends RecordVO implements Serializable {

    @SuppressWarnings("compatibility:-385627319963455204")
    private static final long serialVersionUID = 1L;

    static Logger logger = LogManager.getRootLogger();

    private List<AttributeVO> attributes; 
    
    public SalesCloudOpportunityVO(JsonNode jsonOpportunity, List<AttributeVO> templateAttributes) {
        
        logger.entry();
        
        this.attributes = new ArrayList<AttributeVO>(templateAttributes.size()); 
        
        for(AttributeVO templateAttribute : templateAttributes) {
            AttributeVO attribute = new AttributeVO(templateAttribute);
            attribute.setValue(jsonOpportunity.get(templateAttribute.getName()).asText());
            attributes.add(attribute);
        }
    

        logger.exit();
    }


// event listeners to update calculated fields?
/*
    @JsonProperty("LastUpdateDate")
    public void setLastUpdateDate(Date lastUpdateDate) {
        logger.entry();
        this.LastUpdateDate = lastUpdateDate;
        
        //DateTime dt = ISODateTimeFormat.dateTime().parseDateTime(lastUpdateDate);
        Date now = Calendar.getInstance().getTime();
        this.daysSinceLastUpdate = new Long(now.getTime() - lastUpdateDate.getTime()).doubleValue()/1000/60/60/24;
        
        logger.exit();
    }
*/



//------------------------------


    @Override
    public String toString() {
        return this.attributes.stream().map(a -> a.getName() + ": " + a.getValue()).reduce((acc, item)  -> acc + "," + item).get();
    }
    
    public ArrayList<String> getFieldsAsList() {
        ArrayList<String> temp = new ArrayList<String>();
        temp = this.attributes.stream().map(a -> a.getName()).collect(Collectors.toCollection(ArrayList::new));
        return temp;
    }
    
    public ArrayList<String> getFieldValuesAsList() {
        ArrayList<String> temp = new ArrayList<String>();
        temp = this.attributes.stream().map(a -> a.getValue()).collect(Collectors.toCollection(ArrayList::new)); 
        return temp;
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