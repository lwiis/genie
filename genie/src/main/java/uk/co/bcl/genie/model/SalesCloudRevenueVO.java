package uk.co.bcl.genie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesCloudRevenueVO {

    private String revnId;
    private String revnNumber;
    private String optyId;
    private String targetPartyId;
    private String revnAmountCurcyCode;
    private String prodGroupId;
    private String statusCode; 

    private Double unitPrice;
    private Double revnAmount;
    private Double winProb; 
    
    private Integer quantity;
    
    public SalesCloudRevenueVO(String revnId, String revnNumber, String optyId) {
        this.revnId = revnId;
        this.revnNumber = revnNumber;
        this.optyId = optyId;
    }



    public SalesCloudRevenueVO(String revnId, String revnNumber, String optyId, String targetPartyId,
                               String revnAmountCurcyCode, String prodGroupId, String statusCode,
                               Double unitPrice, Double revnAmount, Double winProb, Integer quantity) {
        this.revnId = revnId;
        this.revnNumber = revnNumber;
        this.optyId = optyId;
        this.targetPartyId = targetPartyId;
        this.revnAmountCurcyCode = revnAmountCurcyCode;
        this.prodGroupId = prodGroupId;
        this.statusCode = statusCode;
        this.unitPrice = unitPrice;
        this.revnAmount = revnAmount;
        this.winProb = winProb;
        this.quantity = quantity;
    }

    public void setRevnId(String revnId) {
        this.revnId = revnId;
    }
    
    public String getRevnId() {
        return revnId;
    }

    public void setOptyId(String optyId) {
        this.optyId = optyId;
    }

    public String getOptyId() {
        return optyId;
    }

    public void setTargetPartyId(String targetPartyId) {
        this.targetPartyId = targetPartyId;
    }

    public String getTargetPartyId() {
        return targetPartyId;
    }

    public void setRevnAmountCurcyCode(String revnAmountCurcyCode) {
        this.revnAmountCurcyCode = revnAmountCurcyCode;
    }

    public String getRevnAmountCurcyCode() {
        return revnAmountCurcyCode;
    }

    public void setProdGroupId(String prodGroupId) {
        this.prodGroupId = prodGroupId;
    }

    public String getProdGroupId() {
        return prodGroupId;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setRevnAmount(Double revnAmount) {
        this.revnAmount = revnAmount;
    }

    public Double getRevnAmount() {
        return revnAmount;
    }

    public void setWinProb(Double winProb) {
        this.winProb = winProb;
    }

    public Double getWinProb() {
        return winProb;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setRevnNumber(String RevnNumber) {
        this.revnNumber = RevnNumber;
    }

    public String getRevnNumber() {
        return revnNumber;
    }

}


/*
 * 
 * {
  "items" : [ {
    "RevnId" : 300000048515674,
    "TargetPartyId" : 300000040282435,
    "CustomerAccountId" : null,
    "BUOrgId" : 300000000748008,
    "Comments" : null,
    "CommitFlag" : true,
    "CostAmount" : 0,
    "ResourcePartyId" : 300000010398678,
    "DownsideAmount" : 0,
    "ExpectAmount" : 2500,
    "MarginAmount" : 0,
    "OptyId" : 300000048515670,
    "UnitPrice" : null,
    "InventoryItemId" : null,
    "InventoryOrgId" : null,
    "Quantity" : null,
    "RevnAmount" : 5000,
    "RevnAmountCurcyCode" : "USD",
    "TypeCode" : null,
    "UpsideAmount" : 5000,
    "WinProb" : 50,
    "UOMCode" : null,
    "ExpectDlvryDate" : null,
    "CreatedBy" : "HWINTERSHAW",
    "CreationDate" : "2015-08-24T13:39:36+00:00",
    "LastUpdatedBy" : "ASENSIER",
    "LastUpdateDate" : "2015-11-11T18:32:49+00:00",
    "LastUpdateLogin" : "2229DF2DBC2576E2E053A69F480AF97D",
    "Description" : null,
    "OrganizationId" : null,
    "PrimaryFlag" : false,
    "RevnNumber" : "2018",
    "ProdGroupId" : 300000040281641,
    "ProdGroupName" : "Marketing Cloud",
    "RecurFrequencyCode" : "NONE",
    "RecurEndDate" : null,
    "RecurParentRevnId" : null,
    "RecurNumberPeriods" : null,
    "RecurQuantity" : null,
    "RecurUnitPrice" : null,
    "RecurRevnAmount" : null,
    "RecurTypeCode" : "NONRECUR",
    "RecurStartDate" : null,
    "SalesCreditTypeCode" : "QUOTA",
    "SplitParentRevnId" : null,
    "SplitPercent" : 100,
    "SplitTypeCode" : "NONE",
    "StatusCode" : "OPEN",
    "EffectiveDate" : "2015-09-13",
    "CloseReasonCode" : null,
    "PrCmptPartyId" : null,
    "RecurPeriodOrEndDateCode" : "EndAfter",
    "ActualCloseDate" : null,
    "PrTerritoryVersionId" : 300000048514085,
    "ConversionRate" : 1,
    "ConversionRateType" : "Corporate",
    "OwnerDealExpirationDate" : null,
    "OwnerDealProtectedDate" : null,
    "OwnerLockAsgnFlag" : false,
    "Name1" : "UK Cloud",
    "ForecastOverrideCode" : "CRITERIA",
    "ItemNumber" : null,
    "ItemNumberInternal" : null,
    "ProductType" : "Group",
    "NqSplitAllocTypeCode" : "PROPORTIONAL",
    "RecurDownsideAmount" : null,
    "RecurUpsideAmount" : null,
    "CrmCurcyCode" : "USD",
    "CrmConversionRateType" : "Corporate",
    "CrmConversionRate" : 1,
    "RevnCategoryCode" : null,
    "OptyLeadId" : null,
    "SalesChannelCd" : "ZPM_INDIRECT_CHANNEL_TYPES",
    "PrPartOrgPartyId" : null,
    "PartEngagementTypeCd" : null,
    "CreditRcptPartOrgPartyId" : null,
    "PartOrgPartyId" : null,
    "PartOrgPartyName" : null,
    "ParentRevnId" : null,
    "RevnLineTypeCode" : "STANDARD_REVN",
    "RevnSequenceNumber" : null,
    "SalesAccountId" : 300000040282439,
    "Discount" : null,
    "RecurTypeCodeTrans" : "NONRECUR",
 * 
 */