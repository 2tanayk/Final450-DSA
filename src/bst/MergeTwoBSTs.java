package bst;

import java.util.*;

public class MergeTwoBSTs {
    private static final Scanner sc = new Scanner(System.in);
    static TreeNode<Integer> prev, head;

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root1 = createBinaryTree();
        TreeNode<Integer> root2 = createBinaryTree();

        mergeBST(root1, root2);
    }

    static TreeNode<Integer> mergeBST(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        prev = null;
        head = null;
        bstToLinkedList(root1);
        root1 = head;

        prev = null;
        head = null;
        bstToLinkedList(root2);
        root2 = head;

        head = mergeSortedLinkedLists(root1, root2);

        int n = countNodes(head);

        return linkedListToBalancedBST(n);
    }

    private static TreeNode<Integer> linkedListToBalancedBST(int n) {
        if (n <= 0) {
            return null;
        }
        TreeNode<Integer> left = linkedListToBalancedBST(n / 2);

        TreeNode<Integer> root = head;

        root.left = left;

        head = head.right;

        root.right = linkedListToBalancedBST(n - n / 2 - 1);

        return root;
    }

    private static int countNodes(TreeNode<Integer> head) {
        int ct = 0;

        while (head != null) {
            ct++;
            head = head.right;
        }

        return ct;
    }

    private static TreeNode<Integer> mergeSortedLinkedLists(TreeNode<Integer> head1, TreeNode<Integer> head2) {
        TreeNode<Integer> dummy = new TreeNode<>(-1);

        TreeNode<Integer> cur = dummy, prev = null;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                cur.right = head1;
                head1.left = cur;

                head1 = head1.right;
            } else {
                cur.right = head2;
                head2.left = cur;

                head2 = head2.right;
            }

            cur = cur.right;
        }

        if (head1 != null) {
            while (head1 != null) {
                cur.right = head1;
                head1.left = cur;

                head1 = head1.right;
                cur = cur.right;
            }
        } else {
            while (head2 != null) {
                cur.right = head2;
                head2.left = cur;

                head2 = head2.right;
                cur = cur.right;
            }
        }
        if (dummy.right != null) {
            dummy.right.left = null;
        }

        return dummy.right;
    }


    private static void bstToLinkedList(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        bstToLinkedList(node.left);

        if (head == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        bstToLinkedList(node.right);
    }

    private static TreeNode<Integer> createBinaryTree() {
        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) return null;

        TreeNode<Integer> rootNode = new TreeNode<Integer>(data);

        System.out.println("Enter left value for " + data + ":");
        rootNode.left = createBinaryTree();

        System.out.println("Enter right value for " + data + ":");
        rootNode.right = createBinaryTree();

        return rootNode;
    }
}
