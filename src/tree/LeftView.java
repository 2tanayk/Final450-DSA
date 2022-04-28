package tree;

import java.util.*;

import java.util.Scanner;

public class LeftView {
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
        System.out.println(leftView(root));
    }

    private static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        int height = heightOfBinaryTree(root) - 1;

        if (root == null) {
            return ans;
        }

        Stack<Node> pStack = new Stack<>();
        HashMap<Node, Integer> pDepthMap = new HashMap<>();


        int depthTraversed = 0;
        ans.add(root.data);

        Node parent = root;
        Node cur = root;

        int backtrackD = height + 1;
        boolean backtrackFlag = false;

        while (true) {
            // System.out.print(height+" "+depthTraversed);
            if (cur != null && cur.left != null) {
                pStack.add(cur);
                pDepthMap.put(cur, depthTraversed);
                cur = cur.left;

                if (backtrackFlag) {
                    backtrackD++;
                }

                if (backtrackFlag && backtrackD > depthTraversed) {
                    ans.add(cur.data);
                } else if (!backtrackFlag) {
                    ans.add(cur.data);
                    depthTraversed++;
                }

            } else if (cur != null && cur.right != null) {
                pStack.add(cur);
                pDepthMap.put(cur, depthTraversed);
                cur = cur.right;

                if (backtrackFlag) {
                    backtrackD++;
                }

                if (backtrackFlag && backtrackD > depthTraversed) {
                    ans.add(cur.data);
                } else if (!backtrackFlag) {
                    ans.add(cur.data);
                    depthTraversed++;
                }
            } else {
                if (depthTraversed == height || backtrackD == height) {
                    break;
                } else {
                    if (!pStack.empty()) {
                        backtrackFlag = true;
                        Node temp = pStack.pop();
                        cur = temp.right;
                        backtrackD = pDepthMap.get(temp) + 1;
                    } else {
                        break;
                    }
                }
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

    private static int heightOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)) + 1;
    }


}
