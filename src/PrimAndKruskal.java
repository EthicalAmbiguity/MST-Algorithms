import java.io.*;
import java.util.*;
import java.lang.*;


/**
 * Implementation of Prim's and Kruskal's Algorithms for Minimum Spanning Trees.
 */

public class PrimAndKruskal {

    private String filename;

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
            System.exit(0);
        }
        System.out.println("test2");
    }

    /**
     * Reads the data from this.filename into an adjcency list.
     */
    void readGraphFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));

    }
}


/*
ID: unethical
LANG: JAVA
TASK:
*/
