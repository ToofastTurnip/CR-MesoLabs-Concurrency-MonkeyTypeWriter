package io.zipcoder;

public class MonkeyTypewriter {

    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        Copier unsafeCopier = new UnsafeCopier(introduction);
//        while (unsafeCopier.stringIterator.hasNext()) {
//            Thread monkey1 = new Thread(unsafeCopier);
//            Thread monkey2 = new Thread(unsafeCopier);
//            Thread monkey3 = new Thread(unsafeCopier);
//            Thread monkey4 = new Thread(unsafeCopier);
//            Thread monkey5 = new Thread(unsafeCopier);
//            monkey1.start();
//            monkey2.start();
//            monkey3.start();
//            monkey4.start();
//            monkey5.start();
//        }

        while (unsafeCopier.stringIterator.hasNext()) {
            for (int i = 0; i < 5; i++) {
                Thread monkey = new Thread(unsafeCopier);
                monkey.start();
            }
        }

        Copier safeCopier = new SafeCopier(introduction);
//        while (safeCopier.stringIterator.hasNext()) {
//            Thread safeMonkey1 = new Thread(safeCopier);
//            Thread safeMonkey2 = new Thread(safeCopier);
//            Thread safeMonkey3 = new Thread(safeCopier);
//            Thread safeMonkey4 = new Thread(safeCopier);
//            Thread safeMonkey5 = new Thread(safeCopier);
//            safeMonkey1.start();
//            safeMonkey2.start();
//            safeMonkey3.start();
//            safeMonkey4.start();
//            safeMonkey5.start();
//        }

        while (safeCopier.stringIterator.hasNext()) {
            for (int i = 0; i < 5; i++) {
                Thread monkey = new Thread(safeCopier);
                monkey.start();
            }
        }

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        unsafeOutput(unsafeCopier.copied);
        safeOutput(safeCopier.copied);
    }

    // Made these for testing and didn't need them lol
    public static void unsafeOutput(String output) {
        System.out.println(output);
    }

    public static void safeOutput(String output) {
        System.out.println(output);
    }
}