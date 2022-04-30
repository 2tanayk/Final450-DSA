package tree;

import java.util.*;

public class TopView {
    private static final Scanner sc = new Scanner(System.in);

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int lineNo;

        public Pair(Node node, int lineNo) {
            this.node = node;
            this.lineNo = lineNo;
        }
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();

        System.out.println(topView(root));
    }

    private static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Pair> nodeQ = new LinkedList<>();
        HashMap<Integer, Node> fMap = new HashMap<>();

        nodeQ.add(new Pair(root, 0));

        while (!nodeQ.isEmpty()) {
            Pair pair = nodeQ.poll();
            int lno = pair.lineNo;
            Node node = pair.node;

            if (!fMap.containsKey(lno)) {
                fMap.put(lno, node);
            }

            if (node.left != null) {
                nodeQ.add(new Pair(node.left, lno - 1));
            }

            if (node.right != null) {
                nodeQ.add(new Pair(node.right, lno + 1));
            }
        }

        Object[] c = fMap.keySet().toArray();

        for (int i = c.length - 1; i >= 0; i--) {
            if (((Integer) c[i]) <= 0) {
                ans.add(fMap.get(((Integer) c[i])).data);
            }
        }

        for (int i = 0; i < c.length; i++) {
            if (((Integer) c[i]) > 0) {
                ans.add(fMap.get(((Integer) c[i])).data);
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
