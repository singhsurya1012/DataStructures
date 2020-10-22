package main.queue;

public class CircularQueue {

    private final int[] queue;
    private int size;
    private int head;
    private int tail;

    public CircularQueue(int size) {
        this.queue = new int[size];
        this.size = size;
        this.head = -1;
        this.tail = -1;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = 0;
        }

        tail = (tail + 1) % size;
        queue[tail] = value;
        return true;
    }

    public boolean deQueue() {

        if(isEmpty()) {
            return false;
        }

        if(head==tail){
            head = -1;
            tail = -1;
            return true;
        }

        head = (head+1)%size;
        return true;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public boolean isEmpty() {
        return head == -1;
    }

}
