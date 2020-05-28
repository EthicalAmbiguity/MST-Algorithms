import java.io.*;
import java.util.*;
import java.lang.*;


/**
 * Implementation of Prim's and Kruskal's Algorithms for Minimum Spanning Trees.
 */

public class PrimAndKruskal {

    private String filename;
    private int[][] adjacencyMatrix;

    /**
     * @param filename the name of the file that contains the graph data. Requires formatting as described in the README.
     */
    PrimAndKruskal(String filename) {
        this.filename = filename;
        try {
            readGraphFromFile();
        }
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
        int n = in.nextInt(); // the number of nodes in the graph.
        adjacencyMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = in.nextInt(); // transfer the graph data into an adjacency matrix
            }
        }

    }
}


