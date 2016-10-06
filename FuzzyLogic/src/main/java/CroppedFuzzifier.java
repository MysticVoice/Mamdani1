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
    
    private float limit;
    
    public CroppedFuzzifier(String name, String type, float[] args, float limit) {
        super(name, type, args);
        this.limit = limit;
    }
    
    @Override
    public float fuzzify(float input)
    {
        float result = super.fuzzify(input);
        if(result>limit)
        {
            result = limit;
        }
        return result;
    }
}
