
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
    }
    
    public void addInput(String name)
    {
        inputs.add(new FuzzyMem(name));
    }
    
    private ArrayList<float[]> collectResults(float[] input)
    {
        
        ArrayList<float[]> result = new ArrayList<>();
        if(input.length == inputs.size())
        {
            for(int i = 0;i<inputs.size();i++)
            {
                FuzzyMem mem = inputs.get(i);
                float[] temp = mem.fuzzify(input[i]);
                result.add(temp);
            }
        }
        else
        {result = null;}
        return result;
    }
}
