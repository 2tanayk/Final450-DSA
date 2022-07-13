package tree;

import java.util.*;

public class BinaryTreeFromInorderAndPreorder {
    private static final Scanner sc = new Scanner(System.in);
    private static HashMap<Integer, Integer> map;
    private static int i;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] in = new int[n];
        int[] pre = new int[n];

        for (int j = 0; j < n; j++) {
            in[j] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            pre[j] = sc.nextInt();
        }

        Node rootNode = buildTree(in, pre, n);
    }

    public static Node buildTree(int in[], int pre[], int n) {
        i = 0;
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(in[i], i);
        }

        return buildBinaryTree(pre, 0, n - 1);
    }

    private static Node buildBinaryTree(int pre[], int l, int h) {
        if (l > h) {
            return null;
        }

        if (l == h) {
            return new Node(pre[i++]);
        }

        int val = pre[i++];

        int pos = map.get(val);

        Node root = new Node(val);
        root.left = buildBinaryTree(pre, l, pos - 1);
        root.right = buildBinaryTree(pre, pos + 1, h);

        return root;
    }
}
