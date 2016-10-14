/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fredrik
 */
public class CroppedFuzzifier extends Fuzzifier{
    
    private double limit;
    
    public CroppedFuzzifier(String name, String type, double[] args, double limit) {
        super(name, type, args);
        this.limit = limit;
    }
    
    @Override
    public double fuzzify(double input)
    {
        double result = super.fuzzify(input);
        if(result>limit)
        {
            result = limit;
        }
        return result;
    }
    
    public double getLimit()
    {
        return limit;
    }
}
