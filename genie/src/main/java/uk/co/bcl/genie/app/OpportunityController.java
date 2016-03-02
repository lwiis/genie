package uk.co.bcl.genie.app;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.co.bcl.genie.model.SalesCloudOpportunityListVO;
import uk.co.bcl.genie.model.SalesCloudOpportunityVO;
import uk.co.bcl.genie.utils.SalesCloudRestTemplate;

public class OpportunityController {

    static Logger logger = LogManager.getRootLogger();

    static String resourceBaseUri =
        "https://cbgl-test.crm.us2.oraclecloud.com/salesApi/resources/11.1.10/opportunities";

    static SalesCloudRestTemplate restTemplate = new SalesCloudRestTemplate("SMILLS", "X9NYSQqX");

/*
    public void main(String args[]) {
        logger.entry();
        //getAllSalesCloudOpportunities();
        getSalesCloudOpportunity("Ase_0020");
        //getFieldsMap(SalesCloudOpportunityVO.class);
        logger.exit();
    }

    
    //public static HashMap<String,String> getFieldsMap(Class clazz) {
    //TODO get this to work!!!!!
    public void getFieldsMap(Class clazz) {
        logger.entry();
        
        HashMap<String, String> attributes = new HashMap<String, String>();
        
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            logger.debug("Field: " + f.toString());

            Class t = f.getType();
            if (!(t == Logger.class || f.getName() == "serialVersionUID")) {
                if (t == boolean.class || t == String.class || t == Integer.class)
                    attributes.put(t.getName(), null);
            }
        }
        
        String resourceUri = resourceBaseUri + "/describe";
        logger.info("Getting " + resourceUri);
              
        //ResourceListOpportunityVO response = restTemplate.getForObject(resourceUri, ResourceListOpportunityVO.class);
        
        logger.info("done");
        String response = restTemplate.getForObject(resourceUri, String.class);
        
        // TODO get the properties of the attributes that were declared on the opportunityVO object in use

        //logger.debug("response returned " + response.getResources().size() + " resources.");

        String output = response.toString();
        
        logger.debug(output);
        
        logger.exit();
        
        //return tempResult;
    }
*/

    public SalesCloudOpportunityVO getSalesCloudOpportunity(String optyNumber) {
        logger.entry();

        //TODO read the fields from SalesCloudOpportunityVO and limit the REST query to those fields
                
        String params = "?onlyData=true&fields=" + (new SalesCloudOpportunityVO()).getFieldsAsString();
            
        String resourceUri = resourceBaseUri + "/" + optyNumber + params;
        logger.info("Getting " + resourceUri);

        SalesCloudOpportunityVO response = restTemplate.getForObject(resourceUri, SalesCloudOpportunityVO.class);

        logger.debug(response.toString());
        logger.debug(response.getFieldsAsString());
        logger.debug(response.getDataAsString());
        logger.exit();

        return response;
    }

    public List<SalesCloudOpportunityVO> getAllSalesCloudOpportunities() {
        logger.entry();
        logger.exit();
        return getAllSalesCloudOpportunities(25, 0);
    }

    public List<SalesCloudOpportunityVO> getAllSalesCloudOpportunities(Integer limit, Integer offset) {
        logger.entry();

        //TODO is there some URI class that takes care of all the "/"?
        //Added Creation data to enforce query sequence. Documentation says order is not guaranteed unless orderBy is used
        //https://docs.oracle.com/cloud/latest/salescs_gs/FAURS.pdf

        String params = "?q=StatusCode!=OPEN&orderBy=CreationDate&limit=" + limit + "&offset=" + offset + "&onlyData=true&fields=" + (new SalesCloudOpportunityVO()).getFieldsAsString();
            
        String resourceUri = resourceBaseUri + params;
        
        logger.info("Getting " + resourceUri);

        SalesCloudOpportunityListVO response = restTemplate.getForObject(resourceUri, SalesCloudOpportunityListVO.class);

        List<SalesCloudOpportunityVO> tempResult;
        tempResult = response.getItems();

        logger.debug(response.toString());
        logger.debug("count: " + response.getCount());
        logger.debug("limit: " + response.getLimit());
        logger.debug("offset: " + response.getOffset());
        logger.debug("totalResults: " + response.getTotalResults());
        logger.debug("hasMore: " + response.isHasMore());

        if (response.isHasMore()) {
            logger.debug("More records found...");
            tempResult.addAll(getAllSalesCloudOpportunities(limit, offset + limit));
        }
        
        logger.debug("Total records: " + tempResult.size());
        
        logger.exit();

        return tempResult;
    }
}
