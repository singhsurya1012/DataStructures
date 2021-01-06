package test.tree;

import main.tree.BinarySearchTree;

public class BinarySearchTreeTest {

    public static boolean testBinarySearchTree() {

        boolean allTestPassed = true;

        BinarySearchTree bst = new BinarySearchTree();

        bst.insertIterative(15);
        bst.insertIterative(19);
        bst.insertIterative(34);
        bst.insertIterative(12);
        bst.insertIterative(15);

        System.out.println(bst.print());
        allTestPassed = allTestPassed && bst.contains(19);
        allTestPassed = allTestPassed && !bst.contains(18);
        allTestPassed = allTestPassed && bst.contains(12);

        System.out.println("Tree contains 19 : " + bst.contains(19));
        System.out.println("Tree contains 18 : " + bst.contains(18));
        System.out.println("Tree contains 12 : " + bst.contains(12));



        return true;
    }
}
