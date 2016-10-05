
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
public class FuzzyMem {
    
    private String name;
    private ArrayList<Fuzzifier> fuzzifiers;
    private RuleBase rules;
    private ArrayList<Fuzzifier> outputs;
    public FuzzyMem(String name)
    {
        this.name = name;
        fuzzifiers = new ArrayList<>();
    }
    
    public void addFuzzifier(String name,String type,float[] args)
    {
        fuzzifiers.add(new Fuzzifier(name,type,args));
    }
    public float[] fuzzify(float input)
    {
        float[] result = new float[fuzzifiers.size()];
        for(int i = 0;i<fuzzifiers.size();i++)
        {
            result[i] = fuzzifiers.get(i).fuzzify(input);
        }
        return result;
    }
}
