
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
public class RuleBase {
    
    ArrayList<int[]> rules;
    public RuleBase()
    {
        rules = new ArrayList<>();
    }
    
//    public void addRule(int[] inputs, int targetOutput)
//    {
//        int[] rule = new int[(inputs.length+1)];
//        for(int i = 0; i <inputs.length;i++)
//        {
//            rule[i] = inputs[i];
//        }
//        rule[inputs.length] = targetOutput;
//        rules.add(rule);
//    }
    
    public void addRule(int input1,int input2, int output)
    {
        int[] rule = new int[3];
        rule[0] = input1;
        rule[1] = input2;
        rule[2] = output;
        rules.add(rule);
    }
    
    public ArrayList<CroppedFuzzifier> ruleEval(ArrayList<double[]> inputs,FuzzyMem output)
    {
        ArrayList<CroppedFuzzifier> result = new ArrayList<>();
        double[] input1 = inputs.get(0);
        double[] input2 = inputs.get(1);
        for(int[] vals:rules)
        {
            if(vals[0] == 1000)
            {
                if(input2[vals[1]]>0)
                {
                    double temp = input2[vals[1]];
                    Fuzzifier fuzz = output.getFuzzifier(vals[2]);
                    double[] arguments = fuzz.getArgs();
                    String name = "Cropped "+fuzz.getName();
                    String type = fuzz.getType();
                    CroppedFuzzifier fuzz2 = new CroppedFuzzifier(name,type,arguments,temp);
                    result.add(fuzz2);
                }
            }
            else if(vals[1] == 1000)
            {
                if(input1[vals[0]]>0)
                {
                    double temp = input1[vals[0]];
                    Fuzzifier fuzz = output.getFuzzifier(vals[2]);
                    double[] arguments = fuzz.getArgs();
                    String name = "Cropped "+fuzz.getName();
                    String type = fuzz.getType();
                    CroppedFuzzifier fuzz2 = new CroppedFuzzifier(name,type,arguments,temp);
                    result.add(fuzz2);
                }
            }
            else
            {
                if(input1[vals[0]] >0 && input2[vals[1]]>0)
                {
                    double temp;
                    if(input1[vals[0]] >input2[vals[1]])
                    {
                        temp = input2[vals[1]];
                    }
                    else
                    {
                        temp = input1[vals[0]];
                    }
                    Fuzzifier fuzz = output.getFuzzifier(vals[2]);
                    double[] arguments = fuzz.getArgs();
                    String name = "Cropped "+fuzz.getName();
                    String type = fuzz.getType();
                    CroppedFuzzifier fuzz2 = new CroppedFuzzifier(name,type,arguments,temp);
                    result.add(fuzz2);
                }
            }
        }
        
        //printings(result);
        
        return result;
    }
    public void printings(ArrayList<CroppedFuzzifier> r)
    {
        String printstring = "Fuzzies: ";
        for(CroppedFuzzifier fuzzfuzz:r)
        {
            printstring += fuzzfuzz.getName() + "  " + fuzzfuzz.getLimit() + "   "+ fuzzfuzz.fuzzify(7.4);
            fuzzfuzz.fuzzify(4);
        }
        System.out.println(printstring);
    }
}
