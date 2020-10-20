package test.array;

import main.array.DynamicArray;

public class DynamicArrayTest {

    public static boolean testDynamicArray() {

        boolean allTestPassed = true;

        DynamicArray array = new DynamicArray();

        allTestPassed = 16 == array.capacity() && 0 == array.size();

        array = new DynamicArray(2);
        //[0,0]
        allTestPassed = allTestPassed && (2 == array.capacity() && 0 == array.size());

        array.add(1);
        array.add(10);
        //[1,10]
        allTestPassed = allTestPassed && (2 == array.size());

        array.add(3);
        //[1,10,3,0]
        allTestPassed = allTestPassed && (3 == array.size() && 4 == array.capacity());

        array.addFront(0);
        int firstElement = array.get(0);
        //[0,1,10,3]
        allTestPassed = allTestPassed && (0 == firstElement);

        array.addAt(2, 2);
        int addedElement = array.get(2);
        //[0,1,2,10,3,0,0,0]
        allTestPassed = allTestPassed && (2 == addedElement);

        int index = array.find(2);
        allTestPassed = allTestPassed && (2 == index);

        int elementRemoved = array.remove();
        //[0,1,2,10,0,0,0,0]
        allTestPassed = allTestPassed && (3 == elementRemoved && 4 == array.size() && 8 == array.capacity());

        array.remove();
        //[0,1,2,0,0,0,0,0]
        elementRemoved = array.removeAt(1);
        //[0,2,0,0]
        allTestPassed = allTestPassed && (1 == elementRemoved && 2 == array.size()) && (4 == array.capacity());

        elementRemoved = array.removeFirst();
        //[2,0]
        allTestPassed = allTestPassed && (0 == elementRemoved && 1 == array.size() && 2 == array.capacity());

        array.removeElement(2);
        //[0]
        allTestPassed = allTestPassed && (0 == array.size() && 1 == array.capacity());

        return allTestPassed;

    }
}
