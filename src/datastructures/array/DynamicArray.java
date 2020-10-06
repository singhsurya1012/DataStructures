package datastructures.array;

public class DynamicArray {

    /**
     * Size of the dynamic array
     */
    private int size;

    private int[] array;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_ARRAY_CAPACITY = 16;


    /**
     * Initialize the array with default capacity
     */
    public DynamicArray() {
        array = new int[DEFAULT_ARRAY_CAPACITY];
    }


    /**
     * Initialize array with given capacity
     *
     * @param capacity
     */
    public DynamicArray(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Please provide valid capacity greater than zero");
        } else {
            array = new int[capacity];
        }
    }

    /**
     * Get the current size of the array
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Get the current capacity of the array
     *
     * @return
     */
    public int capacity() {
        return array.length;
    }


    /**
     * Checks if the array is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns element at given index
     *
     * @param index
     * @return
     */
    public int get(int index) {

        checkInRange(index);
        return array[index];
    }

    private void checkInRange(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index:" + index + " is out of bound");
        }
    }

    /**
     * add element at the end of array
     *
     * @param element to be added
     * @return
     */
    public boolean add(int element) {
        checkCapacity();
        array[size++] = element;
        return true;
    }

    /**
     * Adds element at the given index
     *
     * @param index
     * @param element
     * @return
     */
    public boolean addAt(int index, int element) {
        checkInRange(index);
        checkCapacity();
        rightShiftArray(index);
        array[index] = element;
        size++;
        return true;
    }

    /**
     * Adds the element at the front of the array
     *
     * @param element
     * @return
     */
    public boolean addFront(int element) {
        return addAt(0, element);
    }

    /**
     * Removes the element from the end of the array
     *
     * @return
     */
    public int remove() {
        int elementToBeRemoved = array[size - 1];
        array[--size] = 0;
        checkExtraCapacity();
        return elementToBeRemoved;
    }


    /**
     * Removes the element
     *
     * @param index
     * @return
     */
    public int removeAt(int index) {

        checkInRange(index);
        int elementToBeRemoved = array[index];
        array[index] = 0;
        leftShiftArray(index);

        array[--size] = 0;

        checkExtraCapacity();
        return elementToBeRemoved;
    }


    /**
     * Removes the first element from the array
     *
     * @return
     */
    public int removeFirst() {
        return removeAt(0);
    }


    /**
     * Removes the first occurrence of element
     *
     * @param element
     * @return
     */
    public boolean removeElement(int element) {

        int index = find(element);
        if (index != -1)
            removeAt(index);
        return true;

    }

    /**
     * Finds the given element and return the index. -1 if element not found
     *
     * @param element
     * @return
     */
    public int find(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element)
                return i;

        }
        return -1;
    }


    private void leftShiftArray(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
    }

    private void rightShiftArray(int index) {
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
    }

    private void checkCapacity() {
        if (size == array.length) {
            grow();
        }
    }

    private void grow() {
        int newCapacity = array.length * 2;
        this.array = copyArray(newCapacity);

    }

    private void checkExtraCapacity() {
        if (array.length >= size * 4) {
            shrink();
        }
    }

    private void shrink() {
        int newCapacity = array.length / 2;
        this.array = copyArray(newCapacity);
    }

    private int[] copyArray(int capacity) {
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }
}
