package FIrstVideoExercise;

public class ExampleEight {

    public static void main(String[] args) {

        Thread testThread = getTestThread();
        testThread.setDaemon(true);
        testThread.start();

        //lazily implememted catch-block with the IDE.
        try {
            testThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        //if the testThread does not join the main thread. It should stop excution once it has been started
        //otherwise if it joins then it should continue execution.


    }

    /**
     * <h>This method is for testing purposes.</h>
     * <p>
     *     The fucntion should return a thread that will print a message up to
     *     a certain countdown.
     *
     *     For test purposes, the thread should be made to a daemon thread. So that
     *     when the main thread ends this thread also ends.
     *
     *     This effect has been tested true, so to counter this effect, the thread will
     *     join with the main thread in order to continue execution and stop the main thread
     *     from continues execution until this thread is completed.
     * </p>
     *
     *
     * <h>I want to explore using the synchronized keyword to a function, even if it is not needed</h>
     * <p>
     *     I want to practice writing comments, like HTML documents.
     *
     *     I like that the Intellij IDE is a flexible tool
     *     with many functionality. It feels natural, and would be
     *     perfect if it not eating 2.3 gb of the ram.
     * </p>
     *
     * @return Thread : the test thread for testing the join() function call.
     * */
    private synchronized static Thread getTestThread(){
        return new Thread ( () -> {

            int maximumLimit = 5;
            for(int iterationCount = 0; iterationCount < maximumLimit; iterationCount++) {

                System.out.println( "countdown to maximum limit of " + maximumLimit
                + "\nCurrent count : " + iterationCount
                );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        } ) ;
    }


}
