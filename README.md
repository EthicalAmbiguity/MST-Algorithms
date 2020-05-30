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

