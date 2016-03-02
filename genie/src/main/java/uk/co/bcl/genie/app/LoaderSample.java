package uk.co.bcl.genie.app;

import java.io.File;

import jsat.ARFFLoader;
import jsat.DataSet;

import jsat.classifiers.DataPoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * data load sample from: https://github.com/EdwardRaff/JSAT/wiki/How-to-load-a-data-set
 *
 */
public class LoaderSample 
{
    static Logger logger = LogManager.getRootLogger();

    public static void main( String[] args )
    {
        logger.entry();
        String nominalPath = "C:\\JDeveloper\\mywork\\datasets\\nominal\\";
        File file = new File(nominalPath + "iris.arff");
        logger.trace("Loading dataset...");
        DataSet dataSet = ARFFLoader.loadArffFile(file);
        System.out.println("There are " + dataSet.getNumFeatures() + " features for this data set.");
        System.out.println(dataSet.getNumCategoricalVars() + " categorical features");
        System.out.println("They are:");
        for(int i = 0; i <  dataSet.getNumCategoricalVars(); i++)
            System.out.println("\t" + dataSet.getCategoryName(i));
        System.out.println(dataSet.getNumNumericalVars() + " numerical features");
        System.out.println("They are:");
        for(int i = 0; i <  dataSet.getNumNumericalVars(); i++)
            System.out.println("\t" + dataSet.getNumericName(i));

        System.out.println("\nThe whole data set");
        for(int i = 0; i < dataSet.getSampleSize(); i++)
        {
            DataPoint dataPoint = dataSet.getDataPoint(i);
            System.out.println(dataPoint);
        }
        logger.exit();
    }
}
