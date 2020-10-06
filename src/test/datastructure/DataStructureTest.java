package test.datastructure;

import test.datastructure.array.DynamicArrayTest;

public class DataStructureTest {


    public static void main(String[] args) {

        boolean dynamicArrayTest = DynamicArrayTest.testDynamicArray();
        System.out.println("Dynamic Array Test " + (dynamicArrayTest ? "Passed" : "Failed"));

    }

}
