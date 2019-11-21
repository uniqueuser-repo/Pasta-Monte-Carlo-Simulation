import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.IntStream;

public class Multithreader extends Thread {
    public static final Object gatekeeper = new Object();
    public static int sum = 0;
    public static double max = 0;
    public int numTrials = 0;

    public Multithreader(int numTrials) {
        this.numTrials = numTrials;
    }

    public void run() {
        int thismax = 0;
        for (int i = 0; i < numTrials; i++) {
            HashSet<Integer> uniques = new HashSet<>();
            Random rand = new Random();
            IntStream pseudorandom = rand.ints(1, 101);
            pseudorandom = pseudorandom.limit(20000);
            int[] arr = pseudorandom.toArray();
            int counter = 0;

            while (uniques.size() != 100) {
                int retrievedVal = arr[counter];
                if (!uniques.contains(retrievedVal)) {
                    uniques.add(retrievedVal);
                }
                counter++;
            }

            if (counter > thismax) {
                thismax = counter;
            }

            synchronized (gatekeeper) {
                sum += counter;
                if (thismax > max) {
                    max = thismax;
                }
            }
        }
    }

}
