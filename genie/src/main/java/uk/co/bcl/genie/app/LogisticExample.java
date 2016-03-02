package uk.co.bcl.genie.app;

import java.io.File;

import jsat.ARFFLoader;
import jsat.DataSet;

import jsat.classifiers.CategoricalResults;
import jsat.classifiers.ClassificationDataSet;
import jsat.classifiers.DataPoint;

import jsat.linear.Vec;

import jsat.regression.LogisticRegression;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogisticExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Logger logger = LogManager.getRootLogger();
        logger.entry();

        /*
        String nominalPath = "C:\\JDeveloper\\mywork\\datasets\\nominal\\";
        File file = new File(nominalPath + "breast-cancer.arff");
        DataSet dataSet = ARFFLoader.loadArffFile(file);*/
        DataSet dataSet = loadDataSet();

        //We specify '0' as the class we would like to make the target class. 
        logger.info("Initialising classification data set...");
        ClassificationDataSet cDataSet = new ClassificationDataSet(dataSet, 0);
        logger.info("OK.");

        int errors = 0;
        logger.info("Initialising classifier...");
        // Changed class from Classifier to LogisticRegression, to have access to the getCoefficients method
        LogisticRegression classifier = new LogisticRegression();
        logger.info("OK.");

        logger.info("Training classifier...");
        classifier.trainC(cDataSet);
        logger.info("OK.");

        logger.debug("Data set sample size = " + dataSet.getSampleSize());
        for(int i = 0; i < dataSet.getSampleSize(); i++)
        {
            DataPoint dataPoint = cDataSet.getDataPoint(i);//It is important not to mix these up, the class has been removed from data points in 'cDataSet' 
            int truth = cDataSet.getDataPointCategory(i);//We can grab the true category from the data set

            //Categorical Results contains the probability estimates for each possible target class value. 
            //Classifiers that do not support probability estimates will mark its prediction with total confidence. 
            CategoricalResults predictionResults = classifier.classify(dataPoint);

            int predicted = predictionResults.mostLikely();
            if(predicted != truth)
                errors++;
            System.out.println( i + "| True Class: " + truth + ", Predicted: " + predicted + ", Confidence: " + predictionResults.getProb(predicted) );
        }

        System.out.println(errors + " errors were made, " + 100.0*errors/dataSet.getSampleSize() + "% error rate" );
        
        Vec coefficients = classifier.getCoefficents();
        
        logger.info("Coefficients = " + coefficients.toString());
        
        logger.exit();
        
    }
    
    private static DataSet loadDataSet() {        
        Logger logger = LogManager.getRootLogger();
        logger.entry();
        String nominalPath = "C:\\JDeveloper\\mywork\\datasets\\nominal\\";
        File file = new File(nominalPath + "breast-w.arff");
        logger.info("Loading data file " + file.getAbsolutePath());
        DataSet dataSet = ARFFLoader.loadArffFile(file);
        logger.debug("There are " + dataSet.getNumFeatures() + " features for this data set.");
        logger.debug(dataSet.getNumCategoricalVars() + " categorical features");
        logger.debug("They are:");
        for(int i = 0; i <  dataSet.getNumCategoricalVars(); i++)
            logger.debug("\t" + dataSet.getCategoryName(i));
        logger.debug(dataSet.getNumNumericalVars() + " numerical features");
        logger.debug("They are:");
        for(int i = 0; i <  dataSet.getNumNumericalVars(); i++)
            logger.debug("\t" + dataSet.getNumericName(i));

        logger.debug("\nThe whole data set");
        for(int i = 0; i < dataSet.getSampleSize(); i++)
        {
            DataPoint dataPoint = dataSet.getDataPoint(i);
            logger.debug(dataPoint);
        }
        logger.exit();

        return dataSet;
    }
}
