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
public class Savings extends Account{
    public Savings(double balance, double rate, int periods){
        setBalance(balance);
        setRate(rate);
        setPeriods(periods);
    }  
}
