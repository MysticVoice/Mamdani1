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
//        FuzzyMem fuzzy = new FuzzyMem("test");
//        
//        float[] arguments = new float[4];
//        float input = (float)2.8;
//        arguments[0] = 0;
//        arguments[1] = 1;
//        arguments[2] = 2;
//        arguments[3] = 3;
//        fuzzy.addFuzzifier("Low", "trapmf", arguments);
//        
//        float[] arguments2 = new float[4];
//        arguments2[0] = 2;
//        arguments2[1] = 3;
//        arguments2[2] = 4;
//        arguments2[3] = 5;
//        fuzzy.addFuzzifier("Medium", "trapmf", arguments2);
//        
//        float[] arguments3 = new float[4];
//        arguments3[0] = 4;
//        arguments3[1] = 5;
//        arguments3[2] = 6;
//        arguments3[3] = 7;
//        fuzzy.addFuzzifier("High", "trapmf", arguments3);
//        
//        float[] arguments4 = new float[4];
//        arguments4[0] = 6;
//        arguments4[1] = 7;
//        arguments4[2] = 8;
//        arguments4[3] = 9;
//        fuzzy.addFuzzifier("Very High", "trapmf", arguments4);
//        
//        float[] result= fuzzy.fuzzify(input);
//        System.out.println("Results were: " + result[0]+" , "+result[1]+" , "+result[2] + " , "+result[3]);
//        
        FuzzySystem sys = new FuzzySystem("House Evaluation");
        sys.addInput("Apartment value");
        sys.addInput("Location");
    }
}
