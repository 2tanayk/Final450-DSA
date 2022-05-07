package tree;

import java.util.*;

public class ZigZagTraversal {
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

        System.out.println(traverseZigZag(root));
    }

    private static ArrayList<Integer> traverseZigZag(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Node> nStack = new Stack<>();
        nStack.push(root);
        ans.add(root.data);
        int i = 0;

        while (!nStack.empty()) {

            Stack<Node> tempStack = new Stack<>();
            while (!nStack.empty()) {
                Node node = nStack.pop();

                if (i % 2 == 0) {
                    if (node.right != null) {
                        ans.add(node.right.data);
                        tempStack.push(node.right);
                    }

                    if (node.left != null) {
                        ans.add(node.left.data);
                        tempStack.push(node.left);
                    }
                } else {
                    if (node.left != null) {
                        ans.add(node.left.data);
                        tempStack.push(node.left);
                    }

                    if (node.right != null) {
                        ans.add(node.right.data);
                        tempStack.push(node.right);
                    }
                }

            }
            nStack = tempStack;
            i++;
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
