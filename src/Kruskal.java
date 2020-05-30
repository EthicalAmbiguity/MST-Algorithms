import java.io.*;
import java.util.*;
import java.lang.*;

public class Kruskal extends MSTFinder {

    private int[] parent;
    private int[] size;

    /* edge list for Kruskal's Algorithm */
    private ArrayList<Edge> edges;

    /**
     * @param filename the name of the file that contains the graph data.
     *                 Requires formatting as described in the README.
     */
    public Kruskal(String filename) {
        super(filename);
    }

    /**
     * Reads the data from this.filename into an this.adjacencyMatrix.
     */
    void readGraphFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));

        /* the number of nodes is the first number, on the first line of the text file, as described in the README */
        numNodes = in.nextInt();
        edges = new ArrayList<>();

        parent = new int[numNodes];
        size = new int[numNodes];

        /* loop through every combination of nodes */
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                int distance = in.nextInt();

                /* as described in the README, if the distance is zero, there is no connection */
                if (distance != 0 && i < j) {

                    /* translate the graph into a edge list for Kruskal's Algorithm */

                    edges.add(new Edge(i, j, distance));
                }
            }
        }

    }



    /**
     * Utilizes Kruskal's algorithm for Minimum Spanning Trees on edges
     *
     * @return the total size of the minimum spanning tree
     */
    public int kruskals() {

        /* STEP 1: sort the edges in ascending order
         by distance (the implemented compareTo() function for edges)
         */
        Collections.sort(edges);


        int totalEdges = 0; 
        int usedEdges = 0;
        int total = 0;


        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);


        while (usedEdges < numNodes - 1) {

            Edge edge = edges.get(totalEdges);

            /* STEP 2: in ascending order by distance, check if the two edges will create a cycle if joined.
             * (i.e. if the two edges are already within the same subset within the Disjoint Set).
             */
            if (!(find(edge.a) == find(edge.b)) || (find(edge.a) == -1 && find(edge.b) == -1)) {

                /* STEP 3: if the addition of the edge does not create a a cycle, add it to the Disjoint Set */
                union(edge.a, edge.b);
                usedEdges++;
                total += edge.distance;
            }
            totalEdges++;

            /* STEP 4: Repeat until the Disjoint Set has numNodes - 1 edges. */
        }

        return total;
    }

    /**
     * Find the subset an element is located in, for a Disjoint Union. Path compression optimization is used.
     * @param x - the element to be examined
     * @return
     */
    private int find(int x) {
        if (parent[x] == -1) {
            return x;
        }
        else {
            parent[x] = find(parent[x]); //path compression
            return (find(parent[x]));
        }
    }

    /**
     * Merge two elements, and their associated subsets together, for a Disjoint union.
     * Union by rank optimization is used.
     * @param x - the first element to be merged
     * @param y - the second element to be merged
     */
    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) return;

        if (size[parentX] >= size[parentY]) { //union by rank
            size[parentX] += size[parentY];
            parent[parentY] = parentX;
        }
        else {
            size[parentX] += size[parentY];
            parent[parentY] = parentX;
        }
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
