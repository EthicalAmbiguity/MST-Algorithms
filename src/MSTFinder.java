import java.io.*;
import java.util.*;
import java.lang.*;

abstract class MSTFinder {
    protected String filename;
    protected int numNodes;

    /**
     * @param filename the name of the file the adjacency matrix data is contained in.
     */

    public MSTFinder(String filename) {
        this.filename = filename;

        /* check if the file exists */
        try {
            readGraphFromFile();
        }

        /* if the file doesn't exist, exit */
        catch (FileNotFoundException e) {
            System.out.println("The requested file does not exist. Stopping.");
            return;
        }
    }

    abstract void readGraphFromFile() throws FileNotFoundException;
}
