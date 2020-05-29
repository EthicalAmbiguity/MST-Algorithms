import java.io.*;
import java.util.*;
import java.lang.*;


/**
 * Implementation of Prim's and Kruskal's Algorithms for Minimum Spanning Trees.
 */

public class Prim extends MSTFinder {


    /* adjacency matrix for Prim's Algorithm */
    private int[][] adjacencyMatrix;

    /**
     * @param filename the name of the file that contains the graph data.
     *                 Requires formatting as described in the README.
     */
    public Prim(String filename) {
        super(filename);
    }

    /**
     * Reads the data from this.filename into an this.adjacencyMatrix.
     */
    void readGraphFromFile() throws FileNotFoundException {
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
                }
            }
        }
    }

    /**
     * Utilizes Prim's algorithm for Minimum Spanning Trees on adjacencyMatrix
     *
     * @return the total size of the minimum spanning tree
     */
    public int prims() {

        int cur = 0;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        /* STEP 1: initialize each distance except for the starting node with a large number;
         * cannot be Integer.MAX_VALUE because it will overflow after relaxing
         */
        Arrays.fill(distances, 1000000000);
        distances[0] = 0;


        for (int node = 0; node < numNodes; node++) {

            /* STEP 2: mark the current node as visited, in order to indicate that it is already part of the MST. */
            visited[cur] = true;

            /* STEP 3: loop through all other nodes that are neighbors of the current node,
             * and are not already part of the MST. If a distance to another node is less than the current minimum
             * distance to that distance, update the MST with this new shortest distance. */
            for (int next = 0; next < numNodes; next++) {
                if (adjacencyMatrix[cur][next] > 0 && adjacencyMatrix[cur][next] < distances[next] && !visited[next])
                    distances[next] = adjacencyMatrix[cur][next];
            }

            /* STEP 4: find the next node that will be processed, which is  the non-visited node with the minimum
             * distance from the current node. */
            int min = Integer.MAX_VALUE;
            for (int next = 0; next < numNodes; next++) {
                if (distances[next] < min && !visited[next]) {
                    cur = next;
                    min = distances[next];
                }
            }
        }

        /* STEP 5: sum the distances; the result is the total distance of the MST */
        int total = 0;
        for (int distance : distances) {
            total += distance;
        }
        return total;
    }
}


