/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_network_3;

/**
 *
 * @author Pierre
 */
public class classC extends Thread{
    public void run(){
        System.out.println("Enter thread C");
        for(int i = 1;i<6;i++){
            System.out.println("\t Hello from thread C with i = "+i);
        }
        System.out.println("Exit from thread C");
    }
}
