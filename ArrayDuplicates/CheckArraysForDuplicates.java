import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;

public class CheckArraysForDuplicates
{
  
    
    public static void main(String[] args) {

        /* ===================================
         * No need to touch the next batch of code - it should just work.
         * Your changes will start after the StopwatchCPU object is created
         * ===================================
         */

        // will not be using any type of has (space complexity is not O9k)

        // algorithm must run O(N log k) where N is total number of keys and k is number of arrays

        // input each element in each array into the red-black binary tree

        if (args.length < 1) {
            StdOut.println("Usage: java CheckArraysForDuplicates filename");
            System.exit(1);
        }
        String filename = args[0];
        
        In in = new In(filename);
        
        int k = in.readInt(); // how many arrays
        int[] sizes = new int[k];  
        int[][] vals = new int[k][];  

        /* Read in all numbers into a set of arrays */
        for (int i = 0; i < k; i++) {
            int n = in.readInt();
            sizes[i] = n;
            vals[i] = new int[n];
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < sizes[i]; j++) {
                vals[i][j] = in.readInt();
            }
        }
        
        /* ===================================
         * Now it's your turn:  how to use a RedBlack tree (of size k) to solve this?
         */
        boolean duplicate = false; // set this to "true" if you find a duplicate!
        StopwatchCPU sw = new StopwatchCPU();

        RedBlackBST<Integer, Integer> rbt = new RedBlackBST<Integer, Integer>();
        int[] offsets = new int[k];
        for (int i = 0; i < k; i++) {
            offsets[i] = 0;
            
            // anything here to check for duplicates?
            if (rbt.contains(vals[i][offsets[i]])) {
                duplicate = true;
                break;
            } else {
                rbt.put(vals[i][offsets[i]++], i); // use the array entry as the key, and the array index as the value
            }
        }
            
        /* now what? */
        // select lowest value in Red-Black BST
        // increment offset array
        // add next value from array
        // compare to previous value && check which array
        // repeat
        while (!rbt.isEmpty()) {
            int val = rbt.min();
            int arrayNum = rbt.get(val);
            rbt.deleteMin();
            if (offsets[arrayNum] < vals[arrayNum].length) {
                int nextVal = vals[arrayNum][offsets[arrayNum]++];
                if (rbt.contains(nextVal)) {
                    duplicate = true;
                }
                else {
                    rbt.put(nextVal, arrayNum);
                }
            }
        }

        
        double elapsed = sw.elapsedTime();

        
        StdOut.println("The arrays do " + (duplicate ? "" : "not ") + "contain a duplicate");
        StdOut.println("elapsed time: " + elapsed + " seconds");
        
    }

   
}

