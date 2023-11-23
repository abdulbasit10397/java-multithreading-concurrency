package section3;

import java.math.BigInteger;

public class ThreadInterrupt_E2 {
    public static void main (String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("20001"), new BigInteger("10000000")));
        thread.start();

        /** The following method is NOT going to invoke the interrupted exception
         * in LongComputationTask thread.
         * We will have to handle the interrupt explicitly to stop the tread.
         * */
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for(BigInteger i= BigInteger.ZERO; i.compareTo(power) != 0; i=i.add(BigInteger.ONE)) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely Interrupted Thread");
                    return BigInteger.ZERO;
                }

                result = result.multiply(base);
            }

            return result;
        }
    }
}
