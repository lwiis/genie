package uk.co.bcl.genie.model.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpportunityMetaDataVO implements Serializable {
    @SuppressWarnings("compatibility:4175033265503859970")
    private static final long serialVersionUID = 1L;
    static Logger logger = LogManager.getRootLogger();

    //private List<ResourceVO> opportunities = new ArrayList<ResourceVO>();
    private ResourceVO opportunities = new ResourceVO();

    //public void setOpportunities(List<ResourceVO> opportunities) {
    public void setOpportunities(ResourceVO opportunities) {
        logger.entry();
        this.opportunities = opportunities;
        logger.exit();
    }

    //public List<ResourceVO> getOpportunities() {
    public ResourceVO getOpportunities() {
        logger.entry();
        logger.exit();
        return opportunities;
    }

    //public OpportunityMetaDataVO(List<ResourceVO> opportunities) {
    public OpportunityMetaDataVO(ResourceVO opportunities) {
        logger.entry();
        this.opportunities = opportunities;
        logger.exit();
    }
    
    public OpportunityMetaDataVO() {
        logger.entry();
        logger.exit();
    }
}
