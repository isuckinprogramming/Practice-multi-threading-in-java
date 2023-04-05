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

        for(int i = 0; i < 2; i++) {

            Thread testThread = new Thread( action, ( "thread # " + i ) );
            testThread.start();

        }

        Thread testThreadForNoRunnable = new Thread( testAction::actionToBeRunned, "no runnable test thread." );
        testThreadForNoRunnable.start();
    }
}



/**
 *
 * I intend to test out if the global variable to modify by a
 * function that will be called out by two or more threads, would have
 * the exact value as per the total amount of times the variable would
 * be modified.
 * <br><br>
 *In 10 iterations with 2 threads, the values were exact over three tries.
 *<br><br>
 * From thread : thread two<br>
 * the value of the variable to increment is : 20<br>
 * From thread : thread one<br>
 * the value of the variable to increment is : 10<br>
 *
 *<br><br>
 * In 10 iterations with 4 threads, the values were exact over three tries.
 *<br><br>
 *From thread : thread two<br>
 * the value of the variable to increment is : 20<br>
 * From thread : thread one<br>
 * the value of the variable to increment is : 10<br>
 * From thread : thread four<br>
 * the value of the variable to increment is : 40<br>
 * From thread : thread three<br>
 * the value of the variable to increment is : 30 <br>
 *
 *<br><br>
 *Going over 100, and reaching 1000 iterations causes
 * inconsistencies in the amount of times the variable
 * to increment should be incremented
 *<br><br>
 * From thread : thread # 1 | Variable To Increment : 100004599 | Memory Location : JavaMemoryModelPractice.ActionToRun@c933bce <br>
 * From thread : thread # 0 | Variable To Increment : 89106744 | Memory Location : JavaMemoryModelPractice.ActionToRun@c933bce <br>
 * */
class ActionToRun implements Runnable {

    int variableToIncrement = 0;

    @Override
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

/**
 *
 * I want to test out the process of creating an object that does not
 * implement the Runnable interface, but have a method that can be called
 * by a Thread.
 *
 *
 * */
class ActionWithNoRunnable {

    /**
     * I want to test out if I can pass the function and object to
     * a thread that requires a Runnable Object as one of the
     * constructor parameters.
     *
     * yeah this works.
     *
     *
     *  Somehow passing the object and using the "::" operator then followed by
     *  the function worked. I don't know how it precisely works or why does it work.
     *
     *  Runnable =  Object + :: + Object.ActionToRun
     *
     *  possible for an object that does not implement the Runnable interface to have their
     *  method be performed by the Thread.
     *
     * */
    public void actionToBeRunned(){

        System.out.println("this method runs.");
    }
}

class ObjectWithMultipleAction{


    public void actionOne(){

        System.out.println( "This is from the first action.");
    }

    public void actionTwo(){

        System.out.println( "This is from the second action.");
    }

    public void run(){

        System.out.println(
                "this is from the action named \"run\"," +
                " which I intend to test if the thread will call this " +
                "instead of the other method. ");


    }



}







