public class PrimAndKruskalTester {
    public static void main(String[] args) {
        Kruskal kruskalTest1 = new Kruskal("Tester/test1.txt");
        System.out.println("The result MST distance calculated by kruskalTest1.kruskals is: " + kruskalTest1.kruskals());

        Prim primTest1 = new Prim("Tester/test1.txt");
        System.out.println("The result MST distance calculated by primTest1.prims is: " + primTest1.prims());

        Kruskal kruskalTest2 = new Kruskal("Tester/test2.txt");     //file doesn't exist
    }
}
