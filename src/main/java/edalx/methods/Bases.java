/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

import java.lang.StringBuilder;

/**
 *
 * @author Alexander
 */
public class Bases {

    public double horner(Double[] coef, double x) {
        double inc = coef[coef.length - 1];
        for (int i = coef.length - 2; i >= 0; i--) {
            inc = inc * x + coef[i];
        }
        return inc;
    }

    public String base10_baseN(Integer[] coef, int base) {
        int num = convertArray_Double(coef);
        System.out.println("___///"+num);
        int exp = findExp(num, base);
        StringBuilder numBaseDif = new StringBuilder();
        Integer aux = 0;
        for (int i = 0; i <=exp+1; i++) {
            aux = num % base;
            switch (aux) {
                case 10:
                    numBaseDif.append("A");
                    break;
                case 11:
                    numBaseDif.append("B");
                    break;
                case 12:
                    numBaseDif.append("C");
                    break;
                case 13:
                    numBaseDif.append("D");
                    break;
                case 14:
                    numBaseDif.append("E");
                    break;
                case 15:
                    numBaseDif.append("F");
                    break;
                default:
                    numBaseDif.append(aux.toString());

            }
            System.out.println("====="+aux);
           
            num = (num - aux) / base;

        }
        return numBaseDif.reverse().toString();
    }
    public Double baseM_base10(String[] coef, int base){
        Double[] vectorCoeficientes=new Double[coef.length];
        Integer aux=0;
        for (int i = 0; i < coef.length; i++) {
            switch (coef[i]) {
                case "A":
                    aux=10;
                    break;
                case "B":
                   aux=11;
                    break;
                case "C":
                    aux=12;
                    break;
                case "D":
                    aux=13;
                    break;
                case "E":
                   aux=14;
                    break;
                case "F":
                    aux=15;
                    break;
                default:
                    aux=Integer.parseInt(coef[i]);
            }
            vectorCoeficientes[i]=Double.parseDouble(aux.toString());
        }
        return horner(vectorCoeficientes, base);
    }

    public int convertArray_Double(Integer[] coef) {
        StringBuilder concat = new StringBuilder();
        for (int i = coef.length - 1; i >= 0; i--) {
            concat.append(coef[i].toString());
        }
        return Integer.parseInt(concat.toString());
    }

    public int findExp(Integer m, int base) {
        int cont = 0;
        while (Math.pow(base, cont) < m) {
            cont++;
        }
        return cont - 1;
    }

}
