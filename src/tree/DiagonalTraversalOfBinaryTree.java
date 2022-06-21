package tree;

import java.util.*;

public class DiagonalTraversalOfBinaryTree {
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

        System.out.println(diagonal(root));
    }

    private static ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();

            while (node != null) {
                ans.add(node.data);

                if (node.left != null) {
                    q.add(node.left);
                }

                node = node.right;
            }
        }

        return ans;
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
