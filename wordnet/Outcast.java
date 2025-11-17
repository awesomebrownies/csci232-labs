import java.io.IOException;
import java.util.Arrays;

public class Outcast {
   WordNet wordnet;
   // constructor takes a WordNet object
   public Outcast(WordNet wordnet) {    
       //initialize
       this.wordnet = wordnet;
   }
   
   // given an array of WordNet nouns, return an outcast
   public String outcast(String[] nouns) {
       if (wordnet == null) throw new NullPointerException();

       int outcast_id = 0;
       int distanceMax = 0;
       int[] distanceSum = new int[nouns.length];
       for(int i = 0; i < nouns.length; i++){
           for(int j = i+1; j < nouns.length; j++){
               int distance = wordnet.distance(nouns[i], nouns[j]);
               distanceSum[i] += distance;
               distanceSum[j] += distance;
           }
       }
       for(int i = 0; i < distanceSum.length; i++){
           if(distanceSum[i] > distanceMax){
               distanceMax = distanceSum[i];
               outcast_id = i;
           }
       }
       return nouns[outcast_id];
   }
   
   // Unit Test client
   public static void main(String[] args) throws IOException { //throw because WordNet throws
       WordNet wordnet = new WordNet(args[0], args[1]);
       Outcast outcast = new Outcast(wordnet);
       for (int t = 2; t < args.length; t++) {
           In in = new In(args[t]);
           String[] nouns = in.readAllStrings();
           StdOut.println(args[t] + ": " + outcast.outcast(nouns));
       }
   }
}