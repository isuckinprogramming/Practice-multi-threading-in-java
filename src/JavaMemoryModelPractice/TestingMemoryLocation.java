package JavaMemoryModelPractice;

/**
 * <h>
 *     I want to test out how java handles the location of variables involved in a multi-threaded setting
 * </h>
 *
 * <p>
 *     This class will have the main method to test out the memory location of the
 *     variables and objects involved between two or more test threads.
 * </p>
 *
 *
 * */
public class TestingMemoryLocation {

    public static void main(String[] args) {


//        Thread testThreadOne = new Thread( action, "thread one" );
//
//        Thread testThreadTwo = new Thread( action, "thread two" );
//
//        Thread testThreadThree = new Thread( action, "thread three" );
//
//        Thread testThreadFour = new Thread( action, "thread four" );
//
//        Thread testThreadFive = new Thread( action, "thread Five" );
//
//        Thread testThreadSix = new Thread( action, "thread SIX" );
//
//
//        testThreadOne.start();
//        testThreadTwo.start();
//
//        testThreadThree.start();
//        testThreadFour.start();
//
//        testThreadFive.start();
//        testThreadSix.start();


        ActionToRun action = new ActionToRun();

        ActionWithNoRunnable testAction = new ActionWithNoRunnable();

        for(int i = 0; i < 10; i++) {

            Thread testThread = new Thread( action, ( "thread # " + i ) );
            testThread.start();

        }

        Thread testThreadForNoRunnable = new Thread( testAction::actionToBeRunned, "no runnable test thread." );
        testThreadForNoRunnable.start();
    }
}

class ActionToRun implements Runnable {

    int variableToIncrement = 0;
    @Override
    /**
     *
     * I intend to test out if the global variable to modify by a
     * function that will be called out by two or more threads, would have
     * the exact value as per the total amount of times the variable would
     * be modified.
     *
     *In 10 iterations with 2 threads, the values were exact over three tries.
     *
     * From thread : thread two
     * the value of the variable to increment is : 20
     * From thread : thread one
     * the value of the variable to increment is : 10
     *
     *
     * In 10 iterations with 4 threads, the values were exact over three tries.
     *
     *From thread : thread two
     * the value of the variable to increment is : 20
     * From thread : thread one
     * the value of the variable to increment is : 10
     * From thread : thread four
     * the value of the variable to increment is : 40
     * From thread : thread three
     * the value of the variable to increment is : 30
     *
     *
     *
     * */
    public void run() {

        int iterationLimit = 100_000_000;

        for( int iterationCount = 0; iterationCount < iterationLimit; iterationCount++ ){

//            both works the same, I just want to write it in a way the process is more explicit.
//            variableToIncrement++;
            variableToIncrement = variableToIncrement + 1;

        }

        /**
         * Want to test this out myself.
         * */
        System.out.println(
        "From thread : " + Thread.currentThread().getName() +
        " | Variable To Increment : " + variableToIncrement +
        " | Memory Location : " + this
        );
    }
}

class ActionWithNoRunnable {

    /**
     * I want to test out if I can pass the function and object to
     * a thread that requires a Runnable Object as one of the
     * constructor parameters.
     *
     * yeah this works.s
     * */
    public void actionToBeRunned(){

        System.out.println("this method runs.");
    }
}