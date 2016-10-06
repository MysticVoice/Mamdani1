
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
    
    public void addRule(int[] inputs, int targetOutput)
    {
        int[] rule = new int[(inputs.length+1)];
        for(int i = 0; i <inputs.length;i++)
        {
            rule[i] = inputs[i];
        }
        rule[inputs.length] = targetOutput;
        rules.add(rule);
    }
    
    public void useRules(float[] values)        
    {
        
    }
}
