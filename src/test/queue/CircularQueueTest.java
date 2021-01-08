package test.queue;

import main.queue.CircularQueue;

public class CircularQueueTest {

    public static boolean testCircularQueue() {

        boolean allTestPassed = true;

        CircularQueue queue = new CircularQueue(3);

        allTestPassed = allTestPassed && queue.enQueue(1);
        allTestPassed = allTestPassed && queue.enQueue(2);
        allTestPassed = allTestPassed && queue.enQueue(3);

        allTestPassed = allTestPassed && queue.isFull();

        allTestPassed = allTestPassed &&  queue.deQueue();
        allTestPassed = allTestPassed &&  queue.enQueue(6);

        allTestPassed = allTestPassed &&  !queue.enQueue(7);

        allTestPassed = allTestPassed &&  queue.deQueue();
        allTestPassed = allTestPassed &&  queue.deQueue();
        allTestPassed = allTestPassed &&  queue.deQueue();

        allTestPassed = allTestPassed && queue.isEmpty();

        return  allTestPassed;
    }
}
