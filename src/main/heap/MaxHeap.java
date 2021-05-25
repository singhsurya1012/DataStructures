package main.heap;

public class MaxHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        heap = new int[maxSize];
        this.size = 0;
        this.maxSize = maxSize;
    }

    public MaxHeap(int[] arr){
        this.heap = arr;
        this.size = arr.length;
        this.maxSize = arr.length;
        heapify();
    }

    private void heapify(){
        for(int i=size/2-1; i>=0;i--){
            siftDown(i);
        }
    }

    public boolean insert(int val){

        if(size==maxSize){
            return false;
        }
        heap[size] = val;
        size++;
        siftUp(size-1);
        return true;
    }

    public int getMax(){
        return heap[0];
    }

    public int extractMax(){

        if(isEmpty()){
            return 0;
        }

        int max = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = 0;
        size--;
        siftDown(0);

        return max;
    }

    public void remove(int i){
        heap[i] = heap[0]+1;
        siftUp(i);
        extractMax();
    }

    public void changePriority(int i, int val){

        int oldPriority = heap[i];
        heap[i] = val;
        if(val>oldPriority){
            siftUp(i);
        }else{
            siftDown(i);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void siftUp(int i){

        while(i>0 && heap[i]>heap[getParent(i)]){
            swap(i, getParent(i));
            i = getParent(i);
        }

    }


    private void siftDown(int i){

        int max = i;

        int left = leftChild(i);
        if(left<size && heap[left]>heap[max]){
            max  =leftChild(i);
        }

        int right = rightChild(i);
        if(right<size && heap[right]>heap[max]){
            max = right;
        }

        if(max!=i){
            swap(i, max);
            siftDown(max);
        }

    }

    private int getParent(int i){
        return (i-1)/2;
    }

    private int leftChild(int i){
        return 2*i+1;
    }

    private int rightChild(int i){
        return 2*i+2;
    }

    private void swap(int i, int parent) {
        int temp = heap[i];
        heap[i] = heap[parent];
        heap[parent] = temp;
    }

    public void printHeap(){
        for(int i=0; i<size;i++){
            System.out.print(heap[i] + " -- ");
        }
    }

}
