import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


import edu.princeton.cs.algs4.Digraph;

public class WordNet {
    //conversion between id and nouns
    private final ArrayList<String[]> idToSynsets = new ArrayList<>();
    private final HashMap<String, HashSet<Integer>> nounToSynsetsIds = new HashMap<>();
    //actual graph storage
    private Digraph G;

   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) throws IOException /* "throw" required for FileReader*/ {

       // Read in all synsets (and do something with them)
       BufferedReader input = new BufferedReader(new FileReader(synsets));
       String line = input.readLine();
       while (line != null) {
           String parts[] = line.split(",");
           int synId = Integer.parseInt(parts[0]);
           String synStr = parts[1];
           String[] synset = synStr.split(" ");
           //notice: the definitions are in parts[2];  we're ignoring those
           
           // need to do more here (and elsewhere, too)
            idToSynsets.add(synset);

            // For each synset, map the synId
            for(String noun : synset){
                nounToSynsetsIds.computeIfAbsent(noun, k -> new HashSet<>()).add(synId);
            }

           // Read next line from file and ..
           line = input.readLine();
       }
       input.close();

       // Read in all hypernyms with some similar code
        G = new Digraph(idToSynsets.size());
        BufferedReader hypInput = new BufferedReader(new FileReader(hypernyms));
        String hypLine = hypInput.readLine();
        while(hypLine != null){
            String parts[] = hypLine.split(",");
            int synset = Integer.parseInt(parts[0]);
            for(int i = 1; i < parts.length; i++){
                int hypernym = Integer.parseInt(parts[i]);
                G.addEdge(synset, hypernym);
            }

            hypLine = hypInput.readLine();
        }
        hypInput.close();

        RootedDAGChecker rootedDAGChecker = new RootedDAGChecker(G);
        if(!rootedDAGChecker.isRootedDAG()){
            throw new IllegalArgumentException("Input is not a Rooted DAG");
        }
   }

   // all WordNet nouns
   public Iterable<String> nouns(){
       return nounToSynsetsIds.keySet();
   }


   // is the word a WordNet noun?
   public boolean isNoun(String word) {
       return nounToSynsetsIds.containsKey(word);
   }


   // a synset (second field of synsets.txt) that is a shortest common ancestor
   // of noun1 and noun2 (defined below)
   public String sca(String noun1, String noun2) {
       ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
       return idToSynsets.get(sca.ancestor(nounToSynsetsIds.get(noun1), nounToSynsetsIds.get(noun2)))[0];
   }

   // distance between noun1 and noun2 (defined below)
   public int distance(String noun1, String noun2) {
       ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
       return sca.length(nounToSynsetsIds.get(noun1), nounToSynsetsIds.get(noun2));
   }

    public ArrayList<String[]> getIdToSynsets(){
        return idToSynsets;
    }
    public HashMap<String,HashSet<Integer>> getNounToSynsetsIds(){
        return nounToSynsetsIds;
    }
   

   // do unit testing of this class
   public static void main(String[] args) throws IOException{ //"throw" because the constructor throws.
        WordNet wnet = new WordNet("synsets.txt", "hypernyms.txt");
        //how to test
       System.out.println("SCA between dog and cat is: " + wnet.sca("dog","cat"));
   }
}
