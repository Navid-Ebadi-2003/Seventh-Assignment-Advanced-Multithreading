package sbu.cs.Semaphore;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Resource {

    public static void accessResource(String name) {
        try {
            System.out.println(name + "   " + java.time.LocalTime.now());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
