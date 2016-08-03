/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.models;

/**
 *
 * @author Alexander
 */
public class ModelPivoting {
    int [] marcas;
    double [] resultado;

    public ModelPivoting() {
    }

    public ModelPivoting(int[] marcas, double[] resultado) {
        this.marcas = marcas;
        this.resultado = resultado;
    }

    public int[] getMarcas() {
        return marcas;
    }

    public void setMarcas(int[] marcas) {
        this.marcas = marcas;
    }

    public double[] getResultado() {
        return resultado;
    }

    public void setResultado(double[] resultado) {
        this.resultado = resultado;
    }
    
}
