package tree;

import java.util.*;

public class RightView {
    private static final Scanner sc = new Scanner(System.in);

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Node root = createBinaryTree();
        System.out.println(rightView(root));
    }

    private static ArrayList<Integer> rightView(Node root) {
        rightPreorderTraversal(root, 0);
        return ans;
    }

    private static void rightPreorderTraversal(Node root, int level) {
        if (root == null) {
            return;
        }

        if (ans.size() == level) {
            ans.add(root.data);
        }

        rightPreorderTraversal(root.right, level + 1);

        rightPreorderTraversal(root.left, level + 1);
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
