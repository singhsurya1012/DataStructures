package test.datastructure.array;

import datastructures.array.DynamicArray;

public class DynamicArrayTest {

    public static boolean testDynamicArray() {

        boolean allTestPassed = true;

        DynamicArray array = new DynamicArray();

        allTestPassed = allTestPassed && (16 == array.capacity() && 0 == array.size());
        System.out.println("Array with default capacity and 0 size created");

        array = new DynamicArray(2);
        //[0,0]
        allTestPassed = allTestPassed && (2 == array.capacity() && 0 == array.size());
        System.out.println("Array with 2 capacity and 0 size created ");

        array.add(1);
        array.add(10);
        //[1,10]
        allTestPassed = allTestPassed && (2 == array.size());
        System.out.println("2 elements added ");

        array.add(3);
        //[1,10,3,0]
        allTestPassed = allTestPassed && (3 == array.size() && 4 == array.capacity());
        System.out.println("3rd elements added and capacity doubled ");

        array.addFront(0);
        int firstElement = array.get(0);
        //[0,1,10,3]
        allTestPassed = allTestPassed && (0 == firstElement);
        System.out.println("Element added at front");

        array.addAt(2, 2);
        int addedElement = array.get(2);
        //[0,1,2,10,3,0,0,0]
        allTestPassed = allTestPassed && (2 == addedElement);
        System.out.println("Element added at index 2");

        int index = array.find(2);
        allTestPassed = allTestPassed && (2 == index);

        int elementRemoved = array.remove();
        //[0,1,2,10,0,0,0,0]
        allTestPassed = allTestPassed && (3 == elementRemoved && 4 == array.size() && 8 == array.capacity());
        System.out.println("Element removed ");

        array.remove();
        //[0,1,2,0,0,0,0,0]
        elementRemoved = array.removeAt(1);
        //[0,2,0,0]
        allTestPassed = allTestPassed && (1 == elementRemoved && 2 == array.size()) && (4 == array.capacity());
        System.out.println("Element removed ");
        System.out.println("Capacity reduced ");

        elementRemoved = array.removeFirst();
        //[2,0]
        allTestPassed = allTestPassed && (0 == elementRemoved && 1 == array.size() && 2 == array.capacity());
        System.out.println("Element removed ");

        array.removeElement(2);
        //[0]
        allTestPassed = allTestPassed && (0 == array.size() && 1 == array.capacity());
        System.out.println("All elements removed ");

        return allTestPassed;

    }
}
