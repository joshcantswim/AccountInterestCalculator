/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author joshshell
 */
public class CertificateOfDeposit extends Account{
    private int length;
    
    public CertificateOfDeposit(double balance, double rate, int periods){
        setBalance(balance);
        setRate(rate);
        setPeriods(periods);
    }
    
    /**
     * 
     * @param length length to set 
     */
    public void setLength(int length){
        this.length = length;
    }
    
    /**
     * 
     * @return the length
     */
    public int getLength(){
        return length;
    }
}
