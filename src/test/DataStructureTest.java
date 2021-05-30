package test;

import test.array.DynamicArrayTest;
import test.heap.MaxHeapTest;
import test.list.SinglyLinkedListTest;
import test.queue.CircularQueueTest;
import test.tree.BinarySearchTreeTest;
import test.trie.TrieTest;

public class DataStructureTest {


    public static void main(String[] args) {

        boolean dynamicArrayTest = DynamicArrayTest.testDynamicArray();
        System.out.println("Dynamic Array Test " + (dynamicArrayTest ? "Passed" : "Failed"));

        boolean singlyLinkedListTest = SinglyLinkedListTest.testSinglyLinkedList();
        System.out.println("Singly Linked List Test " + (singlyLinkedListTest ? "Passed" : "Failed"));

        boolean circularQueueTest = CircularQueueTest.testCircularQueue();
        System.out.println("Circular Queue Test " + (circularQueueTest ? "Passed" : "Failed"));

        boolean binarySearchTreeTest = BinarySearchTreeTest.testBinarySearchTree();
        System.out.println("Binary Search Tree Test " + (binarySearchTreeTest ? "Passed" : "Failed"));

        boolean maxHeapTest = MaxHeapTest.testMaxHeap();
        System.out.println("Max Heap Test " + (maxHeapTest ? "Passed" : "Failed"));

        boolean rWayTrieTest = TrieTest.testRWayTrie();
        System.out.println("R Way Trie Test " + (rWayTrieTest ? "Passed" : "Failed"));


        boolean ternarySearchTrieTest = TrieTest.testTernarySearchTrie();
        System.out.println("Ternary Search Trie Test " + (ternarySearchTrieTest ? "Passed" : "Failed"));
    }

}
