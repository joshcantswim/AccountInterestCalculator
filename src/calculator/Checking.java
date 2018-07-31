/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;


public class Checking extends Account{
    private int checkNumber;
    private double monthlyFee;
    
    public Checking(double balance, double rate, int periods){
        setBalance(balance);
        setRate(rate);
        setPeriods(periods);
    }    
    
    @Override
    public void calculate(){
            double balance = getBalance();
            double rate = getRate();
            setBalance((balance * rate) + balance - monthlyFee);        
    }   
    
    /**
     * 
     * @param checkNumber check number to set
     */
    public void setCheckNumber(int checkNumber){
        this.checkNumber = checkNumber;
    }
    
    /**
     * 
     * check number
     */
    public int getCheckNumber(){
        return checkNumber;
    }
    
    /**
     * 
     * set monthly fee
     */
    public void setMonthlyFee(double monthlyFee){
        this.monthlyFee = monthlyFee;
    }
    
    /**
     * 
     * get monthly fee 
     */
    public double getMonthlyFee(){
        return monthlyFee;
    }
    
    
}
