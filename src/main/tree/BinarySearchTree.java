package main.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public void insert(int val) {
        root = insert(root, val);
        size++;
    }

    private TreeNode insert(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }


    public void insertIterative(int val) {

        if (root == null) {
            root = new TreeNode(val);
        } else {

            TreeNode curr = root;
            TreeNode prev = null;

            while (curr != null) {
                prev = curr;

                if (val < curr.val) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            if (val < prev.val) {
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }

        }

        size++;
    }

    public boolean contains(int val){
        TreeNode node = search(root, val);
        return node!=null;
    }

    private TreeNode search(TreeNode node, int val) {

        if(node==null){
            return null;
        }

        if(node.val==val){
            return node;
        }else if(val<node.val){
            return search(node.left,val);
        }else{
            return search(node.right,val);
        }

    }


    public void deleteTree() {
        root = null;
        size = 0;
    }


    public List<Integer> inOrderTraversal() {
        List<Integer> list = new ArrayList<>(size);
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);

    }

    public List<Integer> preOrderTraversal() {
        List<Integer> list = new ArrayList<>(size);
        preOrderTraversal(root, list);
        return list;
    }

    private void preOrderTraversal(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        list.add(node.val);
        preOrderTraversal(node.left, list);
        preOrderTraversal(node.right, list);
    }

    public List<Integer> postOrderTraversal() {
        List<Integer> list = new ArrayList<>(size);
        postOrderTraversal(root, list);
        return list;
    }

    private void postOrderTraversal(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        postOrderTraversal(node.left, list);
        postOrderTraversal(node.right, list);
        list.add(node.val);

    }

    public String print() {
        List<Integer> list = new ArrayList<>(size);
        inOrderTraversal(root, list);
        return printTree(list);
    }


    private String printTree(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(i -> sb.append(i).append(" "));
        return sb.toString();
    }


}

