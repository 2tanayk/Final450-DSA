package graph;

import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV = sc.nextInt();
        List<Node> graph = new ArrayList<>();
        graph.add(null);
        for (int i = 1; i <= nV; i++) {
            graph.add(new Node(i));
        }

        int nE = sc.nextInt();
        for (int i = 0; i < nE; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();

            graph.get(source).neighbors.add(graph.get(dest));
            graph.get(dest).neighbors.add(graph.get(source));
        }

        Node ref = cloneGraph(graph.get(1));

    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        if (node.neighbors.size() == 0) {
            return new Node(node.val);
        }

        HashMap<Integer, Node> created = new HashMap<>();
        HashMap<Integer, Boolean> exp = new HashMap<>();

        boolean flag = false;

        Queue<Node> oQ = new LinkedList<>();
        Queue<Node> cQ = new LinkedList<>();

        oQ.add(node);
        Node ref = new Node(node.val);
        cQ.add(ref);
        created.put(node.val, ref);

        while (!oQ.isEmpty()) {
            Node cur = oQ.poll();
            Node cur2 = cQ.poll();

            if (exp.containsKey(cur.val)) {
                continue;
            }
            exp.put(cur.val, true);

            if (!flag) {
                ref = cur2;
                flag = true;
            }


            for (Node n : cur.neighbors) {
                Node newNode;
                if (created.containsKey(n.val)) {
                    newNode = created.get(n.val);
                } else {
                    newNode = new Node(n.val);
                    created.put(n.val, newNode);
                }

                cur2.neighbors.add(newNode);
                cQ.add(newNode);
                oQ.add(n);
            }
        }

        return ref;
    }
}
