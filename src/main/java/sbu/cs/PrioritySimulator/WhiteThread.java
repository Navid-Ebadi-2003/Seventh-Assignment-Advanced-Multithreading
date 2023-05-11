package sbu.cs.PrioritySimulator;

import java.util.concurrent.CountDownLatch;

public class WhiteThread extends ColorThread {

    private CountDownLatch latch;
    private static final String MESSAGE = "hi finished blacks, hi finished blues!";

    public WhiteThread(CountDownLatch latch) {
        this.latch = latch;
    }

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run() {
        printMessage();
        latch.countDown();
    }
}
