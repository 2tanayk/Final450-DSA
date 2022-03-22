package trees;

import java.util.*;

public class InorderTraversal {
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
        System.out.println(inorderTraversal(root));
    }

    private static ArrayList<Integer> inorderTraversal(Node root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node cur = root;
        while (true) {
            if (cur != null) {
                nodeStack.push(cur);
                cur = cur.left;
            } else {
                if (nodeStack.isEmpty()) {
                    break;
                }
                cur = nodeStack.pop();
                inorderList.add(cur.data);
                cur = cur.right;
            }
        }

        return inorderList;
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
