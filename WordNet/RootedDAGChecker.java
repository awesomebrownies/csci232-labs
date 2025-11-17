/* *****************************************************************************
 *  Name:              Evan Brown
 *  Last modified:     November 14th, 2025
 **************************************************************************** */

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;

public class RootedDAGChecker {
    private Digraph G;
    public RootedDAGChecker(Digraph G){
        this.G = G;
    }

    public boolean isRootedDAG(){
        //check if there are any cycles
        DirectedCycle directedCycle = new DirectedCycle(G);
        if(directedCycle.hasCycle()){
            return false;
        }
        int rootCount = 0;
        //check each vertex for to see if it is the root
        for(int i = 0; i < G.V(); i++){
            if(G.outdegree(i) == 0){
                rootCount++;
            }
        }
        if(rootCount != 1){
            return false;
        }
        return true;
    }
}
