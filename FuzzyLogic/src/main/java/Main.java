
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Fredrik
 */
public class Main {
    
    public static void main(String args[])
    {
        double marketValueInput = 800000;
        double locationInput = 7;
        
        
        FuzzySystem sys = new FuzzySystem("House Evaluation");
        sys.addInput("Market value");
        sys.addInput("Location");
        
        //----------Market Value-----------//
        FuzzyMem marketVal = sys.getInput(0);
        double[] low = new double[4];
        low[0] = -1;
        low[1] = 0;
        low[2] = 75000;
        low[3] = 100000;
        marketVal.addFuzzifier("LOW", "trapmf", low);
        
        double[] med = new double[4];
        med[0] = 50000;
        med[1] = 100000;
        med[2] = 200000;
        med[3] = 250000;
        marketVal.addFuzzifier("Medium", "trapmf", med);
        
        double[] high = new double[4];
        high[0] = 200000;
        high[1] = 300000;
        high[2] = 650000;
        high[3] = 850000;
        marketVal.addFuzzifier("High", "trapmf", high);
        
        double[] vHigh = new double[4];
        vHigh[0] = 650000;
        vHigh[1] = 850000;
        vHigh[2] = 1000000;
        vHigh[3] = 1000001;
        marketVal.addFuzzifier("Very High", "trapmf", vHigh);
        
        //---------------Location--------------//
        FuzzyMem location = sys.getInput(1);
        double[] bad = new double[4];
        bad[0] = -1;
        bad[1] = 0;
        bad[2] = (double)1.5;
        bad[3] = 4;
        location.addFuzzifier("bad", "trapmf", bad);
        
        double[] fair = new double[4];
        fair[0] = (double)2.5;
        fair[1] = 5;
        fair[2] = 6;
        fair[3] = (double)8.5;
        location.addFuzzifier("fair", "trapmf", fair);
        
        double[] excelent = new double[4];
        excelent[0] = 6;
        excelent[1] = (double) 8.5;
        excelent[2] = 10;
        excelent[3] = 11;
        location.addFuzzifier("excelent", "trapmf", excelent);
        
        
        //---------------Output----------------//
        FuzzyMem output = new FuzzyMem("House");
        double[] ovLow = new double[3];
        ovLow[0] = -1;
        ovLow[1] = 0;
        ovLow[2] = 3;
        output.addFuzzifier("Very Low", "trimf", ovLow);
        
        double[] oLow = new double[3];
        oLow[0] = 0;
        oLow[1] = 3;
        oLow[2] = 6;
        output.addFuzzifier("Low", "trimf", oLow);
        
        double[] oMed = new double[3];
        oMed[0] = 2;
        oMed[1] = 5;
        oMed[2] = 8;
        output.addFuzzifier("Medium", "trimf", oMed);
        
        double[] oHigh = new double[3];
        oHigh[0] = 4;
        oHigh[1] = 7;
        oHigh[2] = 10;
        output.addFuzzifier("High", "trimf", oHigh);
        
        double[] ovHigh = new double[3];
        ovHigh[0] = 7;
        ovHigh[1] = 10;
        ovHigh[2] = 11;
        output.addFuzzifier("Very High", "trimf", ovHigh);
        sys.addOutputFuzz(output);
        
        RuleBase rules = sys.getRules();
        rules.addRule(0,1000,1);
        rules.addRule(1000,0,1);
        rules.addRule(0,0,0);
        rules.addRule(1,0,1);
        rules.addRule(2,0,2);
        rules.addRule(3,0,3);
        rules.addRule(0,1,1);
        rules.addRule(1,1,2);
        rules.addRule(2,1,3);
        rules.addRule(3,1,4);
        rules.addRule(0,2,2);
        rules.addRule(1,2,3);
        rules.addRule(2,2,4);
        rules.addRule(3,2,4);
        
        double[] inputs = new double[2];
        inputs[0] = marketValueInput;
        inputs[1] = locationInput;
        ArrayList<double[]> fuzzified = sys.collectResults(inputs);
        
        
        
        String result = "Membership " + getPrintFromDoubleArray(fuzzified);
        
        ArrayList<CroppedFuzzifier> fuzzies = rules.ruleEval(fuzzified, output);
        result += "House: "+ sys.sampleDist(100, fuzzies);
        System.out.println(result + "   " );
    }
    
    public static String getPrintFromDoubleArray(ArrayList<double[]> array)
    {
        String result = "Values: ";
        for(double[] d:array)
        {
            result += "\n";
            for(double dd:d)
            {
                result += dd + "   ";
            }
        }
        result += "\n";
        return result;
    }
    
}
