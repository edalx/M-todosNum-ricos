/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.models;

/**
 *
 * @author edalx
 */
public class mCrout {
    private double[][] L;
    private double[][] U;

    public mCrout(double[][] L, double[][] U) {
        this.L = L;
        this.U = U;
    }

    public mCrout() {
    }

    public double[][] getL() {
        return L;
    }

    public void setL(double[][] L) {
        this.L = L;
    }

    public double[][] getU() {
        return U;
    }

    public void setU(double[][] U) {
        this.U = U;
    }
    
}
