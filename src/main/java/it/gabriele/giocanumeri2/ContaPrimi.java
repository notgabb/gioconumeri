package it.gabriele.giocanumeri2;

public class ContaPrimi extends Thread {

    private final int min;
    private final int max;

    public ContaPrimi(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        int primes = 0;
        int start = min;

        // If min is even, skip to the next odd
        if (min % 2 == 0) {
            start = min + 1;
        }

        // Every odd number is 2 away
        for (int i = start; i < max; i += 2) {
            double root = Math.sqrt(i);

            boolean isPrime = true;

            for (int j = 1; j < root; j++) {
                if (i % j != 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes++;
            }
        }

        long elapsedTimesout = System.currentTimeMillis() - startTime;
        System.out.println("---------------------");
        System.out.printf("Thread %d ha contato %d numeri primi in %d millisecondi %n", threadId(), primes, elapsedTimesout);
    }
}
