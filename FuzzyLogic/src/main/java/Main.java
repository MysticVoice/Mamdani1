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
        FuzzyMem fuzzy = new FuzzyMem("test");
        float[] arguments = new float[4];
        float input = (float)1.5;
        arguments[0] = 0;
        arguments[1] = 1;
        arguments[2] = 2;
        arguments[3] = 3;
        fuzzy.addFuzzifier("", "trapmf", arguments);
        System.out.println("Result was: " + fuzzy.fuzzify(input)[0]);
        
    }
}
