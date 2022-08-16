package tree;

import java.util.*;

import java.util.Scanner;

public class LeftView {
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
        System.out.println(leftView(root));
    }

    private static ArrayList<Integer> leftView(Node root) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        solve(root, 0, hm, ans);

        return ans;
    }

    private static void solve(Node root, int lvl, HashMap<Integer, Integer> hm, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }

        if (!hm.containsKey(lvl)) {
            hm.put(lvl, root.data);
            a.add(root.data);
        }

        solve(root.left, lvl + 1, hm, a);
        solve(root.right, lvl + 1, hm, a);
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
