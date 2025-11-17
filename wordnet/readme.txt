/******************************************************************************
 *  Name:  Evan Brown
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 3: WordNet


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 *****************************************************************************/
I used two data structures so that I could easily convert from id to noun and nouns to id
The idToSynsets is an ArrayList<String[]>. The ArrayList allows me to add all of the words on the fly while reading through synsets.txt, and the index corresponds with the id.
The nounToSynsetsId is a HashMap<String, HashSet<Integer>>. Each word has multiple ids so I stored it in a HashMap for O(1) access times along with a HashSet.

/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 *****************************************************************************/
I used the Digraph data structure because it concisely stored adjacency lists and let me take advantage of the API


/******************************************************************************
 *  Describe concisely your algorithm to compute the shortest common
 *  ancestor in ShortestCommonAncestor. For each method in the API, what
 *  is the order of growth of the worst-case running time as a function
 *  of the number of vertices V and the number of edges E in the digraph?
 *  For each method, what is the order of growth of the best-case running time?
 *
 *  If you use hashing, you may assume the uniform hashing assumption
 *  so that put() and get() take constant time.
 *
 *  Be careful! If you use something like a BreadthFirstDirectedPaths object, 
 *  don't forget to count the time needed to initialize the marked[],
 *  edgeTo[], and distTo[] arrays.
 *****************************************************************************/

Description: ancestor() methods: First I initialize two BreadthFirstDirectedPaths, these each create marked lists for reachable paths.
 My algorithm checks each vertex within the graph, and calls the hasPathTo. If both nodes have a path to a hyponym,
 I check its distance from one node to the other against the current best, and reselect the hyponym if it is the shortest.

 Since everything inside the BreadthFirstDirectedPaths class is pre-computed,
 the O model of efficiency remains the same at O(V+E) for best and worst case.

 length() methods: The method calls ancestor, so it can then trace the path using BreadthFirstDirectedPaths distTo method. However, the order of the growth does not change.

                                              running time
method                               best case            worst case
------------------------------------------------------------------------
length(int v, int w)                O(V + E)              O(V + E)

ancestor(int v, int w)              O(V + E)              O(V + E)

length(Iterable<Integer> v,         O(V + E)              O(V + E)
       Iterable<Integer> w)

ancestor(Iterable<Integer> v,       O(V + E)              O(V + E)
         Iterable<Integer> w)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, but do include any 
 *  help from people (including course staff, TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
(TA) Bao Nguyen helped me with the ShortestCommonAncestor ancestor and length method

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
