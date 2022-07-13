package tree;

import java.util.*;

public class BoundaryTraversalOfBinaryTree {
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

        System.out.println(boundary(root));
    }

    private static ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(root.data);

        if (root.left != null) {
            leftBoundaryTraversal(root.left, ans);
        }

        if (root.left != null || root.right != null) {
            rootBoundaryTraversal(root, ans);
        }

        if (root.right != null) {
            rightBoundaryTraversal(root.right, ans);
        }

        return ans;
    }


    private static void leftBoundaryTraversal(Node node, ArrayList<Integer> ans) {
        if (node.left == null && node.right == null) {
            return;
        }

        ans.add(node.data);

        if (node.left != null) {
            leftBoundaryTraversal(node.left, ans);
        } else {
            leftBoundaryTraversal(node.right, ans);
        }
    }

    private static void rootBoundaryTraversal(Node node, ArrayList<Integer> ans) {
        if (node.left == null && node.right == null) {
            ans.add(node.data);
            return;
        }


        if (node.left != null) {
            rootBoundaryTraversal(node.left, ans);
        }

        if (node.right != null) {
            rootBoundaryTraversal(node.right, ans);
        }
    }

    private static void rightBoundaryTraversal(Node node, ArrayList<Integer> ans) {
        if (node.left == null && node.right == null) {
            return;
        }

        if (node.right != null) {
            rightBoundaryTraversal(node.right, ans);
        } else {
            rightBoundaryTraversal(node.left, ans);
        }

        ans.add(node.data);
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
