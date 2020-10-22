package main.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue {

    private final LinkedList<Integer> list;

    public Queue() {
        this.list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void enQueue(int value) {
        list.add(value);
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        list.remove();
        return true;
    }

    public int peek() {

        if(isEmpty()) {
            throw new NoSuchElementException("There is no elements in the queue");
        }

        return list.getFirst();
    }
}
