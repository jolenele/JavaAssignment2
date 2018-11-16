/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author 101107083
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
       
        
       Bank ree2 = new Bank();
       
       Boolean Bool = ree2.addAccount(1,200.00, "Jason2");
        ree2.depositAccount(1,1000);
        System.out.print("\n" + ree2.printAccounts());
    }
    
}
