/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fredrik
 */
public class Fuzzifier {
    private String name;
    private String type;
    private float[] args;
    private boolean setup;
    public Fuzzifier(String name,String type,float[] args)
    {
        this.name = name;
        if(verifyType(type))
        {
            this.type = type;
        }
        if(verifyArgs(args))
        {
            this.args = args;
            setup = true;
        }
        else
        {
            setup = false;
        }
        
    }
    
    public boolean verifyArgs(float[] args)
    {
        boolean result = false;
        if(type == "trimf")
        {
            if(args.length == 3)
            {
                return true;
            }
        }
        else if(type == "trapmf")
        {
            if(args.length == 4)
            {
                return true;
            }
        }
        return result;
    }
    
    public boolean verifyType(String type)
    {
        boolean result = false;
        if(type == "trimf")
        {
            
            result = true;
        }
        else if(type == "trapmf")
        {

            result = true;
        }
        return result;
    }
    
    public float fuzzify(float input)
    {
        float result = 0;
        if(type == "trimf")
        {
            result = trimFuzz(input);
        }
        else if(type == "trapmf")
        {
            result = trapFuzz(input);
        }
        
        return result;
    }
    
    public float trimFuzz(float input)
    {
        float result = 0;
        float line1 = lineMem(input,args[0],args[1],true);
        float line2 = lineMem(input,args[1],args[2],false);
        result = line1;
        if(line1>line2)
        {
            result = line2;
        }
        if(result < 0)
        {
            result = 0;
        }
        return result;
    }
    
    public float trapFuzz(float input)
    {
        float result = 0;
        float line1 = lineMem(input,args[0],args[1],true);
        float line2 = (float)1.0;
        float line3 = lineMem(input,args[2],args[3],false);
        result = line2;
        if(result>line1)
        {
            result = line1;
        }
        if(result>line3)
        {
            result = line3;
        }
        if(result < 0)
        {
            result = 0;
        }
        return result;
    }
    
    public float lineMem(float input, float arg1, float arg2,boolean positive)
    {
        float result = 0;
        
        float x = 1/(arg2-arg1);
        if(positive)
        {
            result = (input-arg1)*x;
        }
        else
        {
            result = ((input-arg1)*-x)+1;
        }
        return result;
    }
}
