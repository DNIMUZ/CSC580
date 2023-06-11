/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg580hsmd.T1C_Parallel;

/**
 *
 * @author Dinie
 */
import java.util.Scanner;

public class ParallelProgram {
    public static void main(String[] args) throws Exception {
        //Creating ExecutionTimer object
        ExecutionTimer timer = new ExecutionTimer();
        
        //Creating object for Scanner
        Scanner sc = new Scanner(System.in);
        
        double A , B , C , D , E , Y , Z ;
        A = 3 ; B = 10 ; C = 2 ; D = 11 ; E = 2 ; Y = 20 ; Z = 10 ;
        
        /*
        //prompt user for input each value
        System.out.print("Enter the value of A: ");
        double A = sc.nextDouble();
        System.out.print("Enter the value of B: ");
        double B = sc.nextDouble();
        System.out.print("Enter the value of C: ");
        double C = sc.nextDouble();
        System.out.print("Enter the value of D: ");
        double D = sc.nextDouble();
        System.out.print("Enter the value of E: ");
        double E = sc.nextDouble();
        System.out.print("Enter the value of Y: ");
        double Y = sc.nextDouble();
        System.out.print("Enter the value of Z: ");
        double Z = sc.nextDouble();
        */
        
        //start timer
        timer.start();

        //Creating Thread Object:
        Thread1 thread1 = new Thread1(A, B);
        Thread2 thread2 = new Thread2(C, D, E);
        Thread3 thread3 = new Thread3(Y, Z);

        //start all thread
        thread1.start();
        thread2.start();
        thread3.start();

        try { // wait for completion of all thread and then sum
            //waiting for each thread to complete
            thread1.join();
            thread2.join();
            thread3.join();
            
            //calculate total all result from each threads 
            double total = thread1.result + thread2.result + thread3.result;
            
            //display total
            System.out.println("A * B + C * (D / E ^ 2) + Y % Z = " + total);
            
        } catch (InterruptedException IntExp) {
        }
        
        // Stop the timer
        timer.stop();

        // Display the execution time of the program
        System.out.println("The program took " + timer.getDuration() + " milliseconds to execute");
    }

}

class Thread1 extends Thread {
    public double A;
    public double B;
    public double result;
    
    //constructor 
    public Thread1(double A, double B) {
        this.A = A;
        this.B = B;
    }
    //method for execute thread
    public void run(){
        System.out.println("Thread 1 is running........");
        System.out.println("Executing A*B");
        result = A*B;
        System.out.println("Exit from thread 1. result = "+result);
    }
}
    
class Thread2 extends Thread {
    public double C;
    public double D;
    public double E;
    public double result;
    //constructor 
    public Thread2(double C, double D, double E) {
        this.C = C;
        this.D = D;
        this.E = E;
    }
    //method for execute thread
    public void run(){
        System.out.println("Thread 2 is running........");
        System.out.println("Executing C * (D / E ^ 2)");
        result = C * (D / Math.pow(E, 2));
        System.out.println("Exit from thread 2. result = "+result);
    }
}
    
class Thread3 extends Thread {
    public double Y;
    public double Z;
    public double result;
    //constructor 
    public Thread3(double Y, double Z) {
        this.Y = Y;
        this.Z = Z;
    }
    //method for execute thread
     public void run(){
        System.out.println("Thread 3 is running........");
        System.out.println("Executing Y % Z");
        result = Y % Z;
        System.out.println("Exit from thread 3. result = "+result);
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