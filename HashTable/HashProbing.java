import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class HashProbing {
    
    public static void main(String[] args) {
        Random random = new Random();

        for (int N = 1000; N <=1000000; N*=10) {
            double mean = 0;
            double collisionCount = 0;


            boolean[] arr = new boolean[(int)(1.25*N)];
            //insert N random keys into the hash table
            for(int i = 0; i < N; i++){
                int key = random.nextInt(arr.length);
                int linearProbe = 0;

                while(arr[(key+linearProbe) % arr.length]) linearProbe++;
                arr[(key+linearProbe) % arr.length] = true;
            }
            //compute the linearProbing average for an array of N values of 2N size.
            //Search misses (or inserts)
            for(int i = 0; i < 10000; i++){
                int key = random.nextInt(arr.length);
                int linearProbe = 0;
                while(arr[(key+linearProbe) % arr.length]){
                    collisionCount++;
                    linearProbe++;
                }
                collisionCount++;
            }

            //Search hits
            mean = (collisionCount/10000.0);

            StdOut.println("Average probes for a miss with N="+N+" is: "+mean);
        }
    }
}