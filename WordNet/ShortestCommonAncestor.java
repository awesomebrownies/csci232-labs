import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;

public class ShortestCommonAncestor {

    private Digraph G;

   // constructor takes a rooted DAG as argument
   public ShortestCommonAncestor(Digraph G) {
       this.G = new Digraph(G);
   }

   private void checkBounds(int vertex){
       if(vertex < 0 || vertex >= G.V()){
           throw new IndexOutOfBoundsException(vertex + " is out of bounds for the digraph");
       }
   }

   // length of shortest ancestral path between v and w
   public int length(int v, int w) {
       checkBounds(v);
       checkBounds(w);

       int ancestor = ancestor(v,w);
       BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(G, w);
       BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(G, v);
       return bfsW.distTo(ancestor) + bfsV.distTo(ancestor);
   }

   // a shortest common ancestor of vertices v and w
   public int ancestor(int v, int w) {
       checkBounds(v);
       checkBounds(w);

       BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(G, w);
       BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(G, v);

       int minLength = G.V();
       int ancestor = -1;

       for(int i = 0; i < G.V(); i++){
           //for each node calculate path distance
           if(bfsW.hasPathTo(i) && bfsV.hasPathTo(i)){
               int pathLength = bfsW.distTo(i) + bfsV.distTo(i);
               if(pathLength < minLength){
                   minLength = pathLength;
                   ancestor = i;
               }
           }
       }

       return ancestor;
   }
   


   private void checkSubset(Iterable<Integer> subset){
       for(Integer i : subset){
           if(i == null) throw new NullPointerException();
           checkBounds(i);
       }
   }

   // length of shortest ancestral path of vertex subsets A and B
   public int length(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
       if (subsetA == null || subsetB == null)
           throw new NullPointerException();
       checkSubset(subsetA);
       checkSubset(subsetB);

       // Output shortest length of all pairs
       int ancestor = ancestor(subsetA, subsetB);
       BreadthFirstDirectedPaths bfsA = new BreadthFirstDirectedPaths(G, subsetA);
       BreadthFirstDirectedPaths bfsB = new BreadthFirstDirectedPaths(G, subsetB);
       return bfsA.distTo(ancestor) + bfsB.distTo(ancestor);
   }

   // a shortest common ancestor of vertex subsets A and B
   public int ancestor(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
       if (subsetA == null || subsetB == null)
           throw new NullPointerException();
       checkSubset(subsetA);
       checkSubset(subsetB);

       // Output shortest common ancestor of all pairs
       BreadthFirstDirectedPaths bfsA = new BreadthFirstDirectedPaths(G, subsetA);
       BreadthFirstDirectedPaths bfsB = new BreadthFirstDirectedPaths(G, subsetB);

       int minLength = G.V();
       int ancestor = -1;

       for(int i = 0; i < G.V(); i++){
           //for each node calculate path distance
           if(bfsA.hasPathTo(i) && bfsB.hasPathTo(i)){
               int pathLength = bfsA.distTo(i) + bfsB.distTo(i);
               if(pathLength < minLength){
                   minLength = pathLength;
                   ancestor = i;
               }
           }
       }

       return ancestor;
   }

   
   // do unit testing of this class
   public static void main(String[] args) {

       // Build unit tests
       if (args.length < 1) {
           manualUnitTest();
       } else {
           In in = new In(args[0]);
           Digraph G = new Digraph(in);
           ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
           while (!StdIn.isEmpty()) {
               int v = StdIn.readInt();
               int w = StdIn.readInt();
               int length   = sca.length(v, w);
               int ancestor = sca.ancestor(v, w);
               StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
           }
       }
   }
   
   // Unit test made by me
   public static void manualUnitTest() {
    // Basic tree test
       int numVertices = 6;// or whatever
       Digraph d1 = new Digraph(numVertices);
       d1.addEdge(1, 0); // add a bunch of these, to form some tree-like shape, e.g.:
       d1.addEdge(3,1);
       d1.addEdge(4,1);
       d1.addEdge(5,2);
       d1.addEdge(2,0);
       /*
        *             0
        *          /      \
        *         1        2
        *        / \      / \
        *       3   4    5 
        */
       
       ShortestCommonAncestor sca = new ShortestCommonAncestor(d1);
       int w = 3;
       int x = 2;
       int y = 5;
       int z = 4;

       StdOut.println("Testing Case: 1");
       StdOut.println("length: " + sca.length(x, y));
       StdOut.println("ancestor: " + sca.ancestor(x, y));


       // testing sets with some iterable type
       Bag<Integer> b1 = new Bag<Integer>();
       Bag<Integer> b2 = new Bag<Integer>();

       b1.add(x);
       b1.add(y);
       b2.add(w);
       b2.add(z);

       StdOut.println("Testing Case: 2");
       StdOut.println("length: " + sca.length(b1, b2));
       StdOut.println("ancestor: " + sca.ancestor(b1, b2));
   }
}