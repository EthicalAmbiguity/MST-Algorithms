import java.io.*;
import java.util.*;
import java.lang.*;


/**
 * Implementation of Prim's and Kruskal's Algorithms for Minimum Spanning Trees.
 */

public class PrimAndKruskal {

    private String filename;
    private int numNodes;


    /* adjacency matrix for Prim's Algorithm */
    private int[][] adjacencyMatrix;

    private int[] parent;
    private int[] size;

    /* edge list for Kruskal's Algorithm */
    private ArrayList<Edge> edges = new ArrayList<>();

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
        numNodes = in.nextInt();
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
    }

    /**
     * Utilizes Prim's algorithm for Minimum Spanning Trees on adjacencyMatrix
     * @return the total size of the minimum spanning tree
     */
    public int prims() {
        
        int cur = 0;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        /* initialize each distance with a large number; cannot be Integer.MAX_VALUE because
        * it will overflow after relaxing
        * */
        Arrays.fill(distances, 1000000000);

        distances[0] = 0; //replace array index with whatever the starting element is
        for (int node = 0; node < numNodes; node++) { //MST with prims
            visited[cur] = true;
            for (int next = 0; next < numNodes; next++) {
                if (adjacencyMatrix[cur][next] > 0 && adjacencyMatrix[cur][next] < distances[next] && !visited[next]) distances[next] = adjacencyMatrix[cur][next];
            }
            int min = Integer.MAX_VALUE;
            for (int next = 0; next < numNodes; next++) {
                if (distances[next] < min && !visited[next]) {
                    cur = next;
                    min = distances[next];
                }
            }
        }

        int total = 0;
        for (int distance : distances) {
            total += distance;
        }
        return total;
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


