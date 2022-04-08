package greedy;

import java.util.*;

public class HuffmanEncoding {
    private static class HuffmanNode {
        boolean isLeaf = true;
        char letter;
        int index;
        int frequency;
        HuffmanNode left, right;

        public HuffmanNode(char letter, int index, int frequency) {
            this.letter = letter;
            this.index = index;
            this.frequency = frequency;
        }

        public HuffmanNode(boolean isLeaf, int index, int frequency) {
            this.isLeaf = isLeaf;
            this.index = index;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "HuffmanNode{" +
                    "isLeaf=" + isLeaf +
                    ", letter=" + letter +
                    ", index=" + index +
                    ", frequency=" + frequency +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();
        int[] fArr = new int[n];


        for (int i = 0; i < n; i++) {
            fArr[i] = sc.nextInt();
        }

        System.out.println(huffmanCodes(s, fArr, n));
    }

    private static ArrayList<String> huffmanCodes(String s, int[] f, int n) {
        ArrayList<String> hCodes = new ArrayList<>();

        PriorityQueue<HuffmanNode> nodeQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.frequency != o2.frequency) {
                return o1.frequency - o2.frequency;
            } else {
                return o1.index - o2.index;
            }
        });

        for (int i = 0; i < n; i++) {
            nodeQ.add(new HuffmanNode(s.charAt(i), i, f[i]));
        }

        HuffmanNode root = nodeQ.peek();
        int nIndex = n;

        while (!nodeQ.isEmpty()) {
            HuffmanNode n1 = nodeQ.poll();
            HuffmanNode n2 = null;
            if (!nodeQ.isEmpty()) {
                n2 = nodeQ.poll();
            }

            if (n2 != null) {
                HuffmanNode newNode = new HuffmanNode(false, nIndex++, (n1.frequency + n2.frequency));
                if (root != null && root.frequency < newNode.frequency) {
                    root = newNode;
                }
                newNode.left = n1;
                newNode.right = n2;
                nodeQ.add(newNode);
            }
        }

        preorderTraversal(root, hCodes, "");

        return hCodes;
    }

    private static void preorderTraversal(HuffmanNode node, ArrayList<String> hCodes, String code) {
        if (node == null) {
            return;
        }

        if (node.isLeaf) {
            hCodes.add(code);
        }
        preorderTraversal(node.left, hCodes, code + "0");
        preorderTraversal(node.right, hCodes, code + "1");
    }
}
