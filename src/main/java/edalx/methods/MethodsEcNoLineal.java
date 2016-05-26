/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

import org.lsmp.djep.djep.*;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;

/**
 *
 * @author edalx
 */
public class MethodsEcNoLineal {
    
   public double evalFunction(String expresion, double point){
        JEP function=new JEP();
        double result=0;
        function.addStandardFunctions();//add mathematics functions
        function.addStandardConstants();//add mathematics constants as pi, e
        function.setImplicitMul(true);
        function.addVariable("x", point);//add primary variable and the point to evaluate
        function.parseExpression(expresion);//add objetive function
        
        if(function.hasError()){
            System.out.println("Hubo un error en el ingreso de la función");
            System.out.println(function.getErrorInfo());
        }
        
        result=function.getValue();//get result of function evaluate in @point 
        return result;
    }
   public String derivate(String expresion){
        DJep function=new DJep();
        String result="";
        function.addStandardFunctions();//add mathematics functions
        function.addStandardConstants();//add mathematics constants as pi, e
        function.setImplicitMul(true);
        function.setAllowUndeclared(true);
        function.setAllowAssignment(true);
        function.addStandardDiffRules();
        try{
            Node node=function.parse(expresion);
            Node diff=function.differentiate(node, "x");
            Node sim=function.simplify(diff);
            result=function.toString(sim);
        }catch(Exception err){
            System.out.println("Ocurrió un error en el procedimiento");
        }
        return result;
   }
}
