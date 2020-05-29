import java.io.*;
import java.util.*;
import java.lang.*;


/**
 * Implementation of Prim's and Kruskal's Algorithms for Minimum Spanning Trees.
 */

public class PrimAndKruskal {

    private String filename;

    /* adjacency matrix for Prim's Algorithm */
    private int[][] adjacencyMatrix;

    private int[] parent;
    private int[] size;
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    /**
     * @param filename the name of the file that contains the graph data. Requires formatting as described in the README.
     */
    PrimAndKruskal(String filename) {

        this.filename = filename;

        /* check if the file exists */
        try {
            readGraphFromFile();
        }

        /* if the file doesn't exist , exit */
        catch (FileNotFoundException e) {
            System.out.println("The requested file does not exist. Stopping.");
            return;
        }

        System.out.println("test2");
    }

    /**
     * Reads the data from this.filename into an this.adjacencyMatrix.
     */
    private void readGraphFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));

        /* the number of nodes is the first number, on the first line of the text file, as described in the README */
        int numNodes = in.nextInt();
        adjacencyMatrix = new int[numNodes][numNodes];

        /* loop through every combination of nodes */
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                int distance = in.nextInt();

                /* as described in the README, if the distance is zero, there is no connection */
                if (distance != 0) {
                    
                    /* translate the graph into an adjacency matrix for Prim's Algorithm */
                    adjacencyMatrix[i][j] = distance;

                    /* translate the graph into a edge list for Kruskal's Algorithm */
                    edges.add(new Edge(i, j, distance));
                }
            }
        }

        System.out.println();
    }

    /**
     * Implementation of an Edge for Kruskal's algorithm.
     */
    private static class Edge implements Comparable<Edge> {

        //implements comparator function into a class, change the compare function depending on how you want to sort (this - a = 1 means sort smallest to largest)

        int a, b, distance;

        Edge() {
        }

        Edge(int a, int b, int distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        public int compareTo(Edge a) {
            return this.distance - a.distance;
        }
    }
}


