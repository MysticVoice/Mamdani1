
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
public class FuzzySystem {
    ArrayList<FuzzyMem> inputs;
    FuzzyMem output;
    RuleBase rules;
    public FuzzySystem(String outName)
    {
        inputs = new ArrayList<>();
        output = new FuzzyMem(outName);
        rules = new RuleBase();
    }
    
    public void addInput(String name)
    {
        inputs.add(new FuzzyMem(name));
    }
    
    public void addInputFuzzymem(FuzzyMem input)
    {
        inputs.add(input);
    }
    
    public void addOutputFuzz(FuzzyMem output)
    {
        this.output = output;
    }
    
    public ArrayList<double[]> collectResults(double[] input)
    {
        
        ArrayList<double[]> result = new ArrayList<>();
        if(input.length == inputs.size())
        {
            for(int i = 0;i<inputs.size();i++)
            {
                FuzzyMem mem = inputs.get(i);
                double[] temp = mem.fuzzify(input[i]);
                result.add(temp);
            }
        }
        else
        {result = null;}
        return result;
    }
    
    public double sampleDist(double count, ArrayList<CroppedFuzzifier> fuzzies)
    {
        double result = 0;
        double start = getStart(fuzzies);
        //System.out.println("Start: "+ start + "\n");
        double end = getEnd(fuzzies);
        double total= end-start;
        double stepLen = (double)(total/count);
        //System.out.println("Step length: " + stepLen);
        double mass = 0;
        for(int i = 0;i<count;i++)
        {
            double temp = 0;
            double input = start+(stepLen*i);
            for(Fuzzifier fuzz:fuzzies)
            {
                double temp2 = fuzz.fuzzify(input)*(input+stepLen/2);
                if(temp2>temp)
                {
                    temp = temp2;
                    mass += fuzz.fuzzify(input);
                }
            }
            
            result += temp;
            //System.out.println(result);
        }
        result = result/mass;
        return result;
    }
    
    public double getStart(ArrayList<CroppedFuzzifier> fuzzies)
    {
        double result = fuzzies.get(0).getArgs()[fuzzies.get(0).getArgs().length-1];
        for(CroppedFuzzifier fuzz:fuzzies)
        {
            if(fuzz.getArgs()[0]<result)
            {
                result = fuzz.getArgs()[0];
            }
                
        }
        return result;
    }
    
    public double getEnd(ArrayList<CroppedFuzzifier> fuzzies)
    {
        double result = 0;
        for(CroppedFuzzifier fuzz:fuzzies)
        {
            if(fuzz.getArgs()[fuzz.getArgs().length-1] >result)
            {
                result = fuzz.getArgs()[fuzz.getArgs().length-1];
            }
                
        }
        return result;
    }
    
    public RuleBase getRules()
    {
        return rules;
    }
    
    public FuzzyMem getInput(int num)
    {
        return inputs.get(num);
    }
    
    public FuzzyMem getOutput()
    {
        return output;
    }
}
