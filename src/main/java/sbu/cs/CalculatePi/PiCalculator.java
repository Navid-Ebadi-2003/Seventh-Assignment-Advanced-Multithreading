package sbu.cs.CalculatePi;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

public class PiCalculator {

    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     Experiment with different algorithms to find accurate results.

     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.

     * @param //floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */

    BigDecimal pi = BigDecimal.valueOf(3);
    BigDecimal n = BigDecimal.valueOf(2);
    BigDecimal s = BigDecimal.ONE;

    Lock L =new ReentrantLock();


    public void calculator(){

        L.lock();
        try {

            pi = pi.add(s.multiply(BigDecimal.valueOf(4).divide(n.multiply((n.add(BigDecimal.ONE)).multiply(n.add(BigDecimal.valueOf(2)))), 1000, RoundingMode.HALF_UP)));
            s = s.multiply(BigDecimal.valueOf(-1));
            n = n.add(BigDecimal.valueOf(2));
        }
        finally {
            L.unlock();
        }
    }
    public class Task extends Thread{
        public void run(){
            calculator();
        }
    }
    public String calculate(int floatingPoint)
    {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for(int i = 0 ; i<1000000 ; i++){

            Task task = new Task();
            threadPool.execute(task);
        }

        threadPool.shutdown();

        pi = pi.divide(BigDecimal.ONE,floatingPoint,RoundingMode.DOWN);

        return pi.toString();
    }

    public static void main(String[] args) {
        // Use the main function to test the code yourself
    }
}
