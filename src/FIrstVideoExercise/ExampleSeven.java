package FIrstVideoExercise;

//kinda new to this way of importing a function, so instead of importing the class, only the static method is imported,
//I don't know what are the effects of putting a static keyword infront of an import keyword in java.

import static java.lang.Thread.sleep;

public class ExampleSeven {

    /**
     * The test works as expected, according to the tutorial, the thread which is
     * set to be daemon thread should end as well.
     *
     * In a normal case, or a case where this is not a daemon thread.
     *
     * The test thread is set to run infinitely, with this, the process should not stop
     * after the main thread finishes.
     *
     * If a thread is a daemon thread, after the main method finishes, the daemon thread ends
     * as well.
     *
     * */
    public static void main(String[] args) throws InterruptedException {

        testingOutDaemonThreads();


        /**
         *
         *  I like that the Intellij IDE provides many suggestions, be great if it did not swallow the whole ram
         *  over 2 gb of ram during runtime is worth it.
         *  this method call is suggested by the IDE
         *
         * */
        sleep(4234);
    }


    /**
     *  <h1>The function starts a thread with an infinite loop.</h1>
     * <p>
     *
     * There is a need to add an infinite loop to the thread
     * because I want to see if the thread created would also stop
     * when the main thread stops.
     *
     * </p>
     *
     * <p> <br>
     * To check for this condition, the main thread would call this method
     * then after calling this thread the main thread would finish execution.
     *
     * So the process should end by then. Otherwise not sure what would happen.
     * </p>
     */
    private static void testingOutDaemonThreads(){

        Thread testThread = new Thread( () -> {

            while( true ){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("test daemon thread is running.");
            }
        } );

        /**
         * <p>
         *
         * after switching the property behind this
         * method to true, after the main method ends, this thread
         * should end as well. I expect the terminal to stop printing the message
         * when the thread ends.
         *
         * </p>
         * */
        testThread.setDaemon(true);

        testThread.start();
    }



}
