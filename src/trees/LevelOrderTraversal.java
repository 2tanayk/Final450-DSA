package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {
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
        System.out.println(levelOrderTraversal(root));
    }


    public static ArrayList<Integer> levelOrderTraversal(Node root) {
        Queue<Node> lQueue = new LinkedList<>();
        ArrayList<Integer> lList = new ArrayList<>();

        lQueue.add(root);

        while (!lQueue.isEmpty()) {
            Node current = lQueue.poll();
            lList.add(current.data);

            if (current.left != null) {
                lQueue.add(current.left);
            }

            if (current.right != null) {
                lQueue.add(current.right);
            }
        }
        return lList;
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
