package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of vertices:");
        int nV = sc.nextInt();
        System.out.println("Enter no. of edges:");
        int nE = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(nV);

        for (int i = 0; i < nV; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 1; i <= nE; i++) {
            System.out.println("Enter source and destination vertices:");
            int source = sc.nextInt();
            int destination = sc.nextInt();

            addEdge(adjacencyList, source, destination);
        }

        printGraph(adjacencyList);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Adjacency List of " + i + " ");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print("->" + adjacencyList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
