package trees;

import java.util.*;

public class PostorderTraversal {
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
        System.out.println(postorderTraversal(root));
    }

    private static ArrayList<Integer> postorderTraversal(Node root) {
        ArrayList<Integer> postorderList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node cur = root;

        while (cur != null || !nodeStack.isEmpty()) {
            if (cur != null) {
                nodeStack.push(cur);
                cur = cur.left;
            } else {
                Node temp = nodeStack.peek().right;
                if (temp == null) {
                    temp = nodeStack.pop();
                    postorderList.add(temp.data);

                    while (!nodeStack.isEmpty() && temp == nodeStack.peek().right) {
                        temp = nodeStack.pop();
                        postorderList.add(temp.data);
                    }
                } else {
                    cur = temp;
                }
            }
        }

        return postorderList;
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
