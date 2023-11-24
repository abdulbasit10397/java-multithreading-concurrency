package section3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoiningThreads {
    public static void main(String[] args) throws InterruptedException {
        /** We want to calculate the !0, !3435, !35435, !2324, !4656, !23, !2435, !5566 */
        List<Long> numbers = Arrays.asList(10000000000L, 0L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566l);

        List<FactorialThread> threads = new ArrayList<>();
        for(long n : numbers) {
            threads.add(new FactorialThread(n));
        }

        for(Thread thread : threads) {
            thread.start();
        }

        for(Thread thread : threads) {
            thread.join(2000); /**Means that if a thread is taking more than 2 seconds, move to next*/
        }

        for(int i=0; i<numbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if(factorialThread.isFinished()) {
                System.out.println("Factorial of number: " + numbers.get(i) + " is : " + factorialThread.getResult());
            } else {
                System.out.println("Factorial of number: " + numbers.get(i) + " is still in progress.");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ONE;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        private BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;
            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }

            return tempResult;
        }

        private boolean isFinished() {
            return isFinished;
        }

        private BigInteger getResult() {
            return result;
        }

    }
}
