/******************************************************************************
 *  Name: Evan Brown
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
The firstIndexOf() method follows the classic binary search algorithm using subarrays on either side of the tested value in an ordered array.
When the search hit event occurs, rather than returning, the algorithm will pick the left subarray. This will continue until eventually the hi
and lo values equal each other, which will be the first instance of the array that equals the search key.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: O (N log N)

allMatches(): O (log N + M log M)

numberOfMatches(): O (log N)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
Matt helped me with the BinarySearchDeluxe binary search by helping me realize dividing the subarrays should not include the test element
Bao helped me code the Term class by telling me to code in a more abstract sense (there are built in helper methods for many of the tasks)
/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/

I had a lot of trouble with binary search algorithm. It's hard to try to code from scratch and looking at the textbook examples helped.



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/

This assignment helped me understand the importance of implementing Comparator classes that will be used
for large scale sorting. I found it extremely useful that the Arrays.sort method can be so versatile in collaboration with the
Comparator class.