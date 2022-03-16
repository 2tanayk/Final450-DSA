package trees;

import java.util.*;

public class ReverseLevelOrderTraversal {
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
        System.out.println(reverseLevelOrderTraversal(root));
    }

    private static ArrayList<Integer> reverseLevelOrderTraversal(Node root) {
        ArrayList<Integer> rList = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
        Queue<Node> rQueue = new LinkedList<>();
        rQueue.add(root);
        rQueue.add(new Node(Integer.MIN_VALUE));

        int level = 0;
        ArrayList<Integer> tempList = new ArrayList<>();

        while (!rQueue.isEmpty()) {
            Node cur = rQueue.poll();

            if (cur.data == Integer.MIN_VALUE) {
                levelMap.put(level, tempList);
                if (rQueue.isEmpty()) {
                    break;
                }
                tempList = new ArrayList<>();
                rQueue.add(new Node(Integer.MIN_VALUE));
                level++;
                continue;
            }

            tempList.add(cur.data);

            if (cur.left != null) {
                rQueue.add(cur.left);
            }

            if (cur.right != null) {
                rQueue.add(cur.right);
            }

        }

        for (int i = levelMap.size() - 1; i >= 0; i--) {
            rList.addAll(levelMap.get(i));
        }
        return rList;
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
