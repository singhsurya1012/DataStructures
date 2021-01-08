package test.tree;

import main.tree.BinarySearchTree;

public class BinarySearchTreeTest {

    public static boolean testBinarySearchTree() {

        boolean allTestPassed = true;

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(15);
        bst.insert(19);
        bst.insert(18);
        bst.insert(12);
        bst.insert(32);
        bst.insert(25);
        bst.insert(57);
        bst.insert(14);
        bst.insert(43);
        bst.insert(62);
        bst.insert(23);

        allTestPassed =allTestPassed && 11==bst.size();

        allTestPassed = allTestPassed && bst.contains(19);
        allTestPassed = allTestPassed && !bst.contains(88);
        allTestPassed = allTestPassed && bst.contains(12);

        allTestPassed = allTestPassed && bst.delete(57);
        allTestPassed = allTestPassed && bst.delete(19);
        allTestPassed = allTestPassed && bst.delete(12);
        allTestPassed = allTestPassed && bst.delete(15);
        allTestPassed = allTestPassed && bst.delete(88);

        allTestPassed =allTestPassed && 7==bst.size();

        bst.insertIterative(88);
        bst.insertIterative(43);
        bst.insertIterative(29);
        bst.insertIterative(25);


        allTestPassed = allTestPassed && bst.deleteIterative(43);
        allTestPassed = allTestPassed && bst.deleteIterative(62);


        allTestPassed = allTestPassed && !bst.contains(19);
        allTestPassed = allTestPassed && bst.contains(88);
        allTestPassed = allTestPassed && bst.contains(23);

        allTestPassed = allTestPassed && 88==bst.getMax();
        allTestPassed = allTestPassed && 14==bst.getMin();


        allTestPassed = allTestPassed && bst.isBST();
        allTestPassed = allTestPassed && bst.isBSTIterative();
        allTestPassed = allTestPassed && bst.isBSTUsingInOrder();

        allTestPassed =allTestPassed && 9==bst.size();

        return allTestPassed;
    }
}
