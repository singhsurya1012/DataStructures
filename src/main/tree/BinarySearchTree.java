package main.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public int size() {
        return size;
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

    public boolean delete(int val) {

        if (root == null) {
            return false;
        }

        root = delete(root, val);
        return true;
    }

    private TreeNode delete(TreeNode node, int val) {

        if (node == null) {
            return node;
        }

        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            size--;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {


                TreeNode parentSuccessor = node;
                TreeNode successor = node.right;

                while (successor.left != null) {
                    parentSuccessor = successor;
                    successor = successor.left;
                }

                node.val = successor.val;

                if (parentSuccessor == node) {
                    node.right = successor.right;
                } else {
                    parentSuccessor.left = successor.right;
                }
            }
        }

        return node;
    }

    public boolean deleteIterative(int val) {

        if (root == null) {
            return false;
        }

        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null) {

            if (curr.val == val) {
                delete(curr, parent);
                size--;
                return true;
            } else if (curr.val > val) {
                parent = curr;
                curr = curr.left;
            } else {
                parent = curr;
                curr = curr.right;
            }
        }
        return false;
    }

    private void delete(TreeNode curr, TreeNode parent) {

        if (curr.left == null) {

            if (parent.left.val == curr.val)
                parent.left = curr.right;
            else
                parent.right = curr.right;

        } else if (curr.right == null) {

            if (parent.left.val == curr.val)
                parent.left = curr.left;
            else
                parent.right = curr.left;
        } else {

            TreeNode parentSuccessor = curr;
            TreeNode successor = curr.right;


            while (successor.left != null) {
                parentSuccessor = successor;
                successor = successor.left;
            }

            curr.val = successor.val;

            if (parentSuccessor == curr) {
                curr.right = successor.right;
            } else {
                parentSuccessor.left = successor.right;
            }

        }


    }

    public boolean contains(int val) {
        TreeNode node = search(root, val);
        return node != null;
    }

    private TreeNode search(TreeNode node, int val) {

        if (node == null) {
            return null;
        }

        if (node.val == val) {
            return node;
        } else if (val < node.val) {
            return search(node.left, val);
        } else {
            return search(node.right, val);
        }

    }


    public void deleteTree() {
        root = null;
        size = 0;
    }

    public int height() {

        if (root == null) {
            return 0;
        }

        return 1 + Integer.max(height(root.left), height(root.right));
    }

    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Integer.max(height(node.left), height(node.right));
    }

    public int getMin() {
        if (root == null) {
            return 0;
        }
        return root.left == null ? 0 : min(root.left);
    }

    private int min(TreeNode node) {
        return node.left == null ? node.val : min(node.left);
    }

    public int getMax() {
        if (root == null) {
            return 0;
        }
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

    public boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(TreeNode node, TreeNode left, TreeNode right) {

        if (node == null)
            return true;

        if (left != null && node.val < left.val) {
            return false;
        }

        if (right != null && node.val >= right.val) {
            return false;
        }

        return isBST(node.left, left, node)
                && isBST(node.right, node, right);
    }


    public boolean isBSTUsingInOrder() {
        return isBST(root, new TreeNode(Integer.MIN_VALUE));
    }

    private boolean isBST(TreeNode node, TreeNode prev) {

        if (node == null) {
            return true;
        }

        if (!isBST(node.left, prev)) {
            return false;
        }

        if (node.val < prev.val) {
            return false;
        }

        prev.val = node.val;

        return isBST(node.right, prev);

    }

    public boolean isBSTIterative() {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != null && curr.val < prev.val) {
                return false;
            }

            prev = curr;
            curr = curr.right;

        }

        return true;
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

