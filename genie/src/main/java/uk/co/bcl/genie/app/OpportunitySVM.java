package uk.co.bcl.genie.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpportunitySVM {

    static Logger logger = LogManager.getRootLogger();
/*
    public static void main(String[] args) {
        logger.entry();
        OpportunityController controller = new OpportunityController();
        List<SalesCloudOpportunityVO> results = controller.getAllSalesCloudOpportunities();

        String newline = System.getProperty("line.separator");
        String output = results.parallelStream().map(item -> item.getDataAsString()).reduce((acc, item) -> acc + newline + item).get();

        String nominalPath = "/home/luisfilipe/jdeveloper/mywork/datasets/";
        File newTextFile = new File(nominalPath + "test.arff");
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(newTextFile);
            fileWriter.write(getHeader() + newline + "@DATA" + newline);
            fileWriter.write(output.replaceAll("null","?"));
            fileWriter.close();
        } catch (IOException e) {
            logger.error(e.toString());
        }

        logger.debug(output);

        //We specify '0' as the class we would like to make the target class. 
        logger.info("Loading data set");
        newTextFile = new File(nominalPath + "test.arff");
        logger.debug(newTextFile.canRead());
        logger.debug(newTextFile.exists());
        logger.debug(newTextFile.length());
        
        //ClassificationDataSet dataset = new ClassificationDataSet(ARFFLoader.loadArffFile(newTextFile), 3);
        ClassificationDataSet dataset = new ClassificationDataSet(OpportunityDataSet.getOpportunityDataSet(results));

        logger.info("Initialising model");
        PlatSMO model = new PlatSMO(new RBFKernel());
        
        model.setCacheMode(CacheMode.FULL);
        
        logger.info("Evaluate model");
        ClassificationModelEvaluation cme = new ClassificationModelEvaluation(model, dataset);
        cme.evaluateCrossValidation(10);

        int errors = 0;

        for(int i = 0; i < dataset.getSampleSize(); i++)
        {
            DataPoint dataPoint = dataset.getDataPoint(i);//It is important not to mix these up, the class has been removed from data points in 'cDataSet' 
            int truth = dataset.getDataPointCategory(i);//We can grab the true category from the data set

            //Categorical Results contains the probability estimates for each possible target class value. 
            //Classifiers that do not support probability estimates will mark its prediction with total confidence. 
            CategoricalResults predictionResults = cme.getClassifier().classify(dataPoint);
            int predicted = predictionResults.mostLikely();
            if(predicted != truth)
                errors++;
            System.out.println( i + "| True Class: " + truth + ", Predicted: " + predicted + ", Confidence: " + predictionResults.getProb(predicted) );
        }

        System.out.println(errors + " errors were made, " + 100.0*errors/dataset.getSampleSize() + "% error rate" );




        logger.exit();
    }
*/
    
    private static String getHeader() {
        
        String title, attributes;
        
        title = "   % 1. Title: Opportunity predictor model\n" + 
                 "   % \n" + 
                 "   % 2. Author: Luis Figueira\n" +
                 "   % \n" +
//                 "   % " + (new SalesCloudOpportunityVO().getFieldsAsString()) + 
                 "\n" + 
                 "@RELATION opportunity\n";
              
        attributes = "@ATTRIBUTE BudgetedFlag {true,false}\n" + 
                     "@ATTRIBUTE SalesStage {\"01 - Qualification\",\"02 - Opportunity\",\"03 - Building Vision\",\"04 - Presentation\",\"05 - Agreement\",\"06 - Negotiation\",\"07 - Closed\",\"08 - Lost\"}\n" +
                     "@ATTRIBUTE SalesMethod {\"Accelerated Sales Process\",\"Line Set-Enabled Sales Process\",\"Standard Sales Process\"}\n" + 
                     //"@ATTRIBUTE StatusCode {\"LOST\",\"NO_SALE\",\"OPEN\",\"WON\"}\n" +
                     "@ATTRIBUTE class {\"LOST\",\"NO_SALE\",\"OPEN\",\"WON\"}\n" +
                     "@ATTRIBUTE OptyId string\n" +
                     "@ATTRIBUTE WinProb numeric\n" +
                     "@ATTRIBUTE PrimaryCompetitorId string\n" +
                     "@ATTRIBUTE OwnerResourcePartyId string\n" + 
                     "@ATTRIBUTE DaysSinceLastUpdate numeric\n" +
                     "@ATTRIBUTE PrimaryOrganizationId string\n" +
                     "@ATTRIBUTE Revenue numeric\n" +
                     "@ATTRIBUTE OptyNumber string\n" +
                     "@ATTRIBUTE TargetPartyId string\n" + 
                     "@ATTRIBUTE EffectiveDate numeric\n" +
                     "@ATTRIBUTE LastUpdateDate numeric\n";
        
        return title + attributes;
    }
}