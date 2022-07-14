package tree;

import java.util.*;

public class MinDistanceBetweenTwoNodesOfBinaryTree {
    private static final Scanner sc = new Scanner(System.in);

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(findDist(root, n1, n2));
    }

    private static int findDist(Node root, int n1, int n2) {
        if (n1 == n2) {
            return 0;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        int l1 = findNode(root, n1, 0, s1);
        int l2 = findNode(root, n2, 0, s2);

        Node lca = findLCA(n1, n2, l1, l2, s1, s2);


        return findDistFromLCA(lca, n1) + findDistFromLCA(lca, n2) - 2;
    }

    private static int findDistFromLCA(Node node, int val) {
        if (node == null) {
            return 0;
        }
        if (node.data == val) {
            return 1;
        }

        int a = findDistFromLCA(node.left, val);
        int b = findDistFromLCA(node.right, val);

        if (a == 0 && b == 0) {
            return 0;
        }

        return a + b + 1;
    }

    private static Node findLCA(int n1, int n2, int l1, int l2, Stack<Node> s1, Stack<Node> s2) {
        if (l1 > l2) {
            return findLCA(n2, n1, l2, l1, s2, s1);
        }

        while (s1.size() < s2.size()) {
            if (s2.peek().data == n1) {
                return s2.pop();
            }
            s2.pop();
        }

        while (s1.peek() != s2.peek()) {
            s1.pop();
            s2.pop();
        }

        return s1.pop();
    }

    private static int findNode(Node node, int val, int lvl, Stack<Node> s) {
        if (node == null) {
            return -1;
        }

        if (node.data == val) {
            return lvl;
        }

        s.push(node);

        int lAns = findNode(node.left, val, lvl + 1, s);

        if (lAns != -1) {
            return lAns;
        }

        int rAns = findNode(node.right, val, lvl + 1, s);

        if (rAns != -1) {
            return rAns;
        }

        s.pop();

        return -1;
    }

    private static Node createBinaryTree() {
        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) return null;

        Node rootNode = new Node(data);

        System.out.println("Enter left value for " + data + ":");
        rootNode.left = createBinaryTree();

        System.out.println("Enter right value for " + data + ":");
        rootNode.right = createBinaryTree();

        return rootNode;
    }
}
