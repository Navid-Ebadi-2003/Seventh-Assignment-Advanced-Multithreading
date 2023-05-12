package sbu.cs.Semaphore;
import java.util.concurrent.*;

public class Operator extends Thread {

    Semaphore sem ;

    String name ;

    public Operator(Semaphore sem ,String name) {
        this.name= name;
        this.sem = sem;
    }

    public String get_name() {
        return name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++)
        {
            try {

                Resource.accessResource(get_name());    // critical section - a Maximum of 2 operators can access the resource concurrently

                sleep(500);

                sem.acquire();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sem.release();
        }
    }
}
