/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joshshell
 */
public class Banker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Account> bankAccounts = new ArrayList<>();       
        do{
        bankAccounts.add(promptUser());      // adding new accounts  
        } while(
                JOptionPane.showConfirmDialog(
                        null,
                        "Do you want enter another account?", "",
                        JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION
                ); // until user selects NO
        // for each accountS
        bankAccounts.stream().map((acc) -> {  
            // displaying account informattion
            System.out.println(
                    String.format("Starting balance: %.2f", acc.getBalance())
            );
            return acc;
        }).map((acc) -> {
            System.out.println("Interest rate: " + acc.getRate());
            return acc;
        }).map((acc) -> {
            System.out.println("Periods: " + acc.getPeriods());
            return acc;            
        }).map((acc) -> {
            // calculating principal for each period
            int periods = acc.getPeriods();
            for (int i=0; i < periods; i++){
                acc.calculate();
                System.out.println(
                        String.format(
                                "Ending balance for period %d: %.2f",
                                (i+1),
                                acc.getBalance()
                        ));                
            }
            return acc;
        }).forEachOrdered((_item) -> {
            System.out.println();
        });
    }
    
     
    /**
     * prompts user for account type and account data
     * 
     * @return the account user entered
     */
    
    public static Account promptUser() {
        String[] options = {"Savings", "Checking", "CD"};
        int selected = JOptionPane.showOptionDialog(null,
                "Please select an account to open",
                "Account types",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE,null,
                options,options[0]
        );  // prompting user for account type
        
        double balance = Double.valueOf(
                JOptionPane.showInputDialog(null,"Enter beggining balance")
        );  //prompting user for balance
        double rate;
        do{
        rate = Double.valueOf(
                JOptionPane.showInputDialog(null,"Enter interest rate")
        );
        if (rate > 0.25) 
            JOptionPane.showMessageDialog(
                null,
                "Interest Rate may be not greater than 25%(0.25)"
            );
        } while (rate > 0.25); //prompting user for interest rate util they enter valid value
        int periods;
        do{
        periods = Integer.parseInt(
            JOptionPane.showInputDialog(null,"Enter periods")
        );
        if (periods < 0) 
            JOptionPane.showMessageDialog(
                null,
                "Periods may not be lower than 0"
            );
        } while (periods < 0); //prompting user for periods util they enter value
        
        switch (selected){
            case 0: {
                Savings acc = new Savings(balance, rate, periods); // savings acc 
                return acc;
            }
            case 1: {
                Checking acc = new Checking(balance, rate, periods); // checking acc
                int checkNumber;                
                do{
                checkNumber = Integer.parseInt(
                        JOptionPane.showInputDialog(null,"Enter check number")
                );
                if (checkNumber < 0) 
                    JOptionPane.showMessageDialog(
                        null,
                        "Check number may not be lower than 0"
                    );
                } while (checkNumber < 0);                
                acc.setCheckNumber(checkNumber);
                acc.setMonthlyFee(5);
                return acc;
            }
            case 2: {
                CertificateOfDeposit acc = 
                        new CertificateOfDeposit(balance, rate, periods); // cd acc
                int length = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                null,"Enter length util maturity"
                        )
                );
                acc.setLength(length);
                return acc;
            }                
        }
        return null;
    }
}
