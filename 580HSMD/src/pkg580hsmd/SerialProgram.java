/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg580hsmd;

import java.util.Scanner;

/**
 *
 * @author Dinie
 */
public class SerialProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of the ExecutionTimer class
        ExecutionTimer timer = new ExecutionTimer();

       
        
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        double A , B , C , D , E , Y , Z ;
        A = 3 ; B = 10 ; C = 2 ; D = 11 ; E = 2 ; Y = 20 ; Z = 10 ;
        
        // Start the timer
        timer.start();

        // Prompt the user to enter the values for the variables in the expression
        /*
        System.out.print("Enter value for A: ");
             A = sc.nextDouble();
        System.out.print("Enter value for B: ");
             B = sc.nextDouble();
        System.out.print("Enter value for C: ");
             C = sc.nextDouble();
        System.out.print("Enter value for D: ");
             D = sc.nextDouble();
        System.out.print("Enter value for E: ");
             E = sc.nextDouble();
        System.out.print("Enter value for Y: ");
             Y = sc.nextDouble();
        System.out.print("Enter value for Z: ");
             Z = sc.nextDouble();
        
             
        */
        
        
        
        
        // Calculate the result of the expression
        double result = A * B + C * (D / Math.pow(E, 2)) + Y % Z;
        System.out.println("The result is " + result);
        
        // Stop the timer
        timer.stop();

        // Display the execution time of the program
        System.out.println("The program took " + timer.getDuration() + " milliseconds to execute");
    }
    
}

// ExecutionTimer class to measure execution time of code in milliseconds
class ExecutionTimer {
    private long startTime; // start time of code execution in nanoseconds
    private long endTime; // end time of code execution in nanoseconds

    public void start() {
       startTime = System.nanoTime(); // record start time in nanoseconds
    }

    public void stop() {
       endTime = System.nanoTime(); // record end time in nanoseconds
    }

    public long getDuration() {
       return (endTime - startTime) / 1000000; // calculate duration in milliseconds
    }
}
