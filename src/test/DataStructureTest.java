package test;

import test.array.DynamicArrayTest;
import test.list.SinglyLinkedListTest;

import java.util.LinkedList;
import java.util.List;

public class DataStructureTest {


    public static void main(String[] args) {

        boolean dynamicArrayTest = DynamicArrayTest.testDynamicArray();
        System.out.println("Dynamic Array Test " + (dynamicArrayTest ? "Passed" : "Failed"));

        boolean singlyLinkedListTest = SinglyLinkedListTest.testSinglyLinkedList();
        System.out.println("Singly Linked List Test " + (singlyLinkedListTest ? "Passed" : "Failed"));

    }

}
