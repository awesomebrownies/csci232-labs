import java.util.Arrays;

public class Autocomplete {
    Term[] terms;
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        this.terms = terms;
        Arrays.sort(terms);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        Term prefixTerm = new Term(prefix, 1);
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));

        if(firstIndex == -1){return new Term[0];}
        Term[] matches = new Term[numberOfMatches(prefix)];
        for(int i = firstIndex; i <= lastIndex; i++){
            matches[i-firstIndex] = terms[i];
        }

        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        Term prefixTerm = new Term(prefix, 1);
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));

        if(firstIndex == -1) return firstIndex;

        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
        return lastIndex-firstIndex+1;
    }
    

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        
        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}