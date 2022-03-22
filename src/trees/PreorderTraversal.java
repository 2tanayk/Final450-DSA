package trees;

import java.util.*;

public class PreorderTraversal {
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
        System.out.println(preorderTraversal(root));
    }

    private static ArrayList<Integer> preorderTraversal(Node root) {
        ArrayList<Integer> preorderList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node cur = root;
        while (true) {
            if (cur != null) {
                preorderList.add(cur.data);
                nodeStack.push(cur);
                cur = cur.left;
            } else {
                if (nodeStack.isEmpty()) {
                    break;
                }
                cur = nodeStack.pop();
                cur = cur.right;
            }
        }

        return preorderList;
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
