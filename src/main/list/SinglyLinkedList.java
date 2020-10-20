package main.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList {

    class Node {

        int value;
        Node next;

        private Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


    private int size;
    private Node head;

    /**
     * Returns the size of list
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks if the list is empty
     */
    public boolean isEmpty() {
        return null == head;
    }


    /**
     * Get the Value at the given index
     */
    public int get(int index) {

        checkInRange(index);
        Node n = getNode(index);
        return n.value;
    }


    /**
     * Adds the element at the start of the list
     */
    public void addFirst(int value) {

        Node n = new Node(value);
        n.next = head;
        head = n;
        size++;

    }

    /**
     * Adds the element at the end of the list
     */
    public void add(int value) {
        addLast(value);
    }

    /**
     * Removes the first element from the list and return its value;
     */
    public int removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException("There is no elements in the list");
        }

        Node n = head;
        head = head.next;
        n.next = null;
        size--;
        return n.value;

    }

    /**
     * Adds the element at the end of the list
     */
    public void addLast(int value) {

        if (isEmpty()) {
            head = new Node(value);
        } else {
            Node last = getNode(size - 1);
            last.next = new Node(value);
        }
        size++;
    }


    /**
     * Removes the last element from the list and return its value;
     */
    public int removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException("There is no elements in the list");
        }
        Node last = null;
        if (size == 1) {
            last = head;
            head = null;
        } else {
            Node secondLast = getNode(size - 2);
            last = secondLast.next;
            secondLast.next = null;
        }

        size--;
        return last.value;
    }

    /**
     * Returns the first element in the list
     */
    public int getFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException("There is no elements in the list");
        }
        return head.value;
    }


    /**
     * Returns the last element in the list
     */
    public int getLast() {

        if (isEmpty()) {
            throw new NoSuchElementException("There is no elements in the list");
        }
        return getNode(size - 1).value;
    }

    /**
     * Adds the element at the given index
     */
    public void addAt(int index, int value) {

        if (index == size) {
            addLast(value);
        } else if (index == 0) {
            addFirst(value);
        } else {
            checkInRange(index);
            Node prev = getNode(index - 1);
            Node n = new Node(value);
            n.next = prev.next;
            prev.next = n;
            size++;
        }
    }

    /**
     * Removes the element at the given index
     */
    public int removeAt(int index) {

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            checkInRange(index);
            Node prev = getNode(index - 1);
            Node n = prev.next;
            prev.next = prev.next.next;
            size--;
            return n.value;
        }
    }

    /**
     * Removes the first occurrence of the value
     */
    public void removeValue(int value) {

        if (!isEmpty()) {

            if (head.value == value) {
                removeFirst();
            } else {

                Node curr = head;
                Node prev = null;
                while (curr != null && curr.value != value) {
                    prev = curr;
                    curr = curr.next;
                }

                if (curr != null) {
                    prev.next = prev.next.next;
                    size--;
                }
            }

        }
    }

    /**
     * Reverse the linked list
     */
    public void reverse() {

        if (!isEmpty()) {

            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }

            head = prev;
        }
    }

    /**
     * Prints the list
     */
    public void print() {

        if (!isEmpty()) {
            Node curr = head;

            while (curr != null) {
                System.out.print(curr.value + "-->");
                curr = curr.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }

    private Node getNode(int index) {

        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;

    }


    private void checkInRange(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index:" + index + " is out of bound");
        }
    }


}
