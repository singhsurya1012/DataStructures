package test.heap;

import main.heap.MaxHeap;

public class MaxHeapTest {

    public static boolean testMaxHeap() {

        boolean allTestPassed = true;

        MaxHeap heap = new MaxHeap(10);

        heap.insert(15);
        heap.insert(7);
        heap.insert(9);
        heap.insert(8);

        allTestPassed = allTestPassed && heap.getMax()==15;

        heap.insert(12);
        heap.insert(18);

        allTestPassed = allTestPassed && heap.getMax()==18;
        allTestPassed = allTestPassed && heap.extractMax()==18;
        allTestPassed = allTestPassed && heap.getMax()==15;
        allTestPassed =  allTestPassed && heap.size()==5;

        heap.insert(3);
        heap.insert(10);

        heap.remove(2);

        allTestPassed = allTestPassed && heap.getMax()==15;
        allTestPassed =  allTestPassed && heap.size()==6;

        heap.changePriority(4,17);

        allTestPassed = allTestPassed && heap.getMax()==17;
        allTestPassed =  allTestPassed && heap.size()==6;

        MaxHeap heapFromArray = new MaxHeap(new int[]{9,7,12,3,15,17});
        allTestPassed = allTestPassed && heapFromArray.getMax()==17;
        allTestPassed =  allTestPassed && heapFromArray.size()==6;

        return allTestPassed;


    }
}
