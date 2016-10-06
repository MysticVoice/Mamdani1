
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
    
    
    
    public ArrayList<CroppedFuzzifier> getFuzzyMembership(float input)
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
    
    public float sampleDist(int count, ArrayList<Fuzzifier> fuzzies)
    {
        float result = 0;
        float start = fuzzies.get(0).getArgs()[0];
        int argPos = fuzzies.get(fuzzies.size()-1).getArgs().length;
        float end = fuzzies.get(fuzzies.size()-1).getArgs()[argPos];
        float total= start-end;
        float stepLen = total/count;
        for(int i = 0;i<count;i++)
        {
            float temp = 0;
            float input = stepLen*count;
            for(Fuzzifier fuzz:fuzzies)
            {
                float temp2 = fuzz.fuzzify(input);
                if(temp2>temp)
                {
                    temp = temp2;
                }
            }
            result += temp;
        }
        return result;
    }
}
