
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
    public FuzzyMem(String name)
    {
        this.name = name;
        fuzzifiers = new ArrayList<>();
    }
    
    public void addFuzzifier(String name,String type,double[] args)
    {
        fuzzifiers.add(new Fuzzifier(name,type,args));
    }
    
    public double[] fuzzify(double input)
    {
        double[] result = new double[fuzzifiers.size()];
        for(int i = 0;i<fuzzifiers.size();i++)
        {
            result[i] = fuzzifiers.get(i).fuzzify(input);
        }
        return result;
    }
    
    public Fuzzifier getFuzzifier(int i)
    {
        return fuzzifiers.get(i);
    }
    
    public ArrayList<CroppedFuzzifier> getFuzzyMembership(double input)
    {
        ArrayList<CroppedFuzzifier> result = new ArrayList<>();
        for(int i = 0;i<fuzzifiers.size();i++)
        {
            Fuzzifier fuzz = fuzzifiers.get(i);
            
            CroppedFuzzifier cFuzz = new CroppedFuzzifier(fuzz.getName()+" Cropped",fuzz.getType(),fuzz.getArgs(),fuzz.fuzzify(input));
            result.add(cFuzz);
        }
        return result;
    }
    
    
}
