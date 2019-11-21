public class randomizer {
    public static void main(String[] args) {
        int numThreads = 7;
        int perThread = 1000000;

        Multithreader[] arr = new Multithreader[numThreads];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Multithreader(perThread);
            arr[i].start();
        }

        for (int i = 0; i < arr.length; i++) {
            try {
                arr[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Multithreader.sum / (perThread * numThreads));
    }
}
