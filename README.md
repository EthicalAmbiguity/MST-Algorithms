# MST Algorithms
This is my final project for Prof. Conrad's "Java Data Structures"; it is an implementation of Prim's and Kruskal's Algorithms for Minimum Spanning Trees.
	
## Structure
  The code is structured into four classes: 
  * [MSTFinder.java](https://github.com/EthicalAmbiguity/MST-Algorithms/blob/master/src/MSTFinder.java) is an abstract class which is the superclass of the classes that implement Prim's and Kruskal's algorithms.
  * [Prim.java](https://github.com/EthicalAmbiguity/MST-Algorithms/blob/master/src/Prim.java) is a subclass of MSTFinder and implements Prim's algorithm via the prims() method.
  * [Kruskal.java](https://github.com/EthicalAmbiguity/MST-Algorithms/blob/master/src/Kruskal.java) is a subclass of MSTFinder and implements Kruskal's algorithm via the kruskals() method.
  * [PrimAndKruskalsTester.java](https://github.com/EthicalAmbiguity/MST-Algorithms/blob/master/src/PrimAndKruskalTester.java) is a tester class that demonstrates the prims() and kruskals() method, as well as what happens when an invalid graph is provided.

## Using the Program
As implemented in MSTFinder.java, both the Prim and Kruskal classes take in the filename of an adjacency matrix as a constructor parameter. The provided example, which is used in PrimAndKruskalsTester.java, is [test1.txt](https://github.com/EthicalAmbiguity/MST-Algorithms/blob/master/Tester/test1.txt):

    5
    0 4 3 0 0
    4 0 2 2 0
    3 2 0 0 6
    0 2 0 0 7
    0 0 6 7 0
The first row contains one number (n), the number of nodes in the adjacency list. Each subsequent row (2 to n+1) contains n numbers, separated by spaces, describing the edge length between two nodes, or 0 if they are not connected; each row and column bijects into a corresponding node, and the valaue at their intersection is the distance between them. For example, the number that is two rows down and three columns right (2) describes the distance between nodes 2 and 3. Thus, the data is mirrored between the top right and bottom left diagonals, and the upper left to lower right diagonal all consists of 0's, since a node cannot be connected to itself. if the file cannot be found, the program returns with an error message.

