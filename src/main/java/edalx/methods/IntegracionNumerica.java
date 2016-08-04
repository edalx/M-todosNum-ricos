/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;
import org.nfunk.jep.*;
/**
 *
 * @author Alexander
 */
public class IntegracionNumerica {
    /**
     * @param expresion function to be evaluated
     * @param point point in where is evaluate the function
     * @return result of evaluate expresion in the point
     */
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
   
    public Double trapecio(String function, double a, double b, int n){
        double sizePartition=(b-a)/n;
        double result=0;
        try{
        for (int i = 1; i < n; i++) {
            result=result+evalFunction(function,a+i*sizePartition);
        }
        result=(sizePartition/2)*(evalFunction(function, a)+evalFunction(function, b))+sizePartition*result;
        }catch(Exception err){
            return null;
        }
        return result;
        
    }
    
    public double simpson1_3(String function, double a, double b, int n){
        double sizePartition=(b-a)/n;
        double result=0;
        double sresultpar=0;
        double sresultimpar=0;
        for (int i = 1; i < n; i++) {
            if (i%2==0) {
                sresultpar=sresultpar+evalFunction(function, a+i*sizePartition);
            }else{
                sresultimpar=sresultimpar+evalFunction(function, a+i*sizePartition);
            }
        }
        result=(sizePartition/3)*(evalFunction(function,a)+evalFunction(function,b)
                +2*sresultpar+4*sresultimpar);
        
        return result;
    }
}

