package SychronizedKeywordPractice;


/**
 *
 *  This class contains the action that will be performed by
 *  a thread, there should be an instance of this class passed
 *  unto a thread, givent that this clas implements the runnable interface.
 * <br><br>
 *  Thinking back on it, this class is a failure. There is no need
 *  to seperate closely related code from each other in separate
 *  classes because this would result in having to look-up different
 *  classes in order to understand what is going on.
 * <br><br>
 *  The implementation of the Runnable interface should have been implemented
 *  as an anonymous innerclass or an on-initialization of a Runnable instance.
 *
 * */
public class ActionToRun implements Runnable {
    public ActionToRun() {
    }

    @Override
    public void run() {


        String threadDetails = "from Thread # " + Thread.currentThread().getName();
        SychronizedExampleOne refToTestObject = MainMethodRunner.testObject;

        System.out.println(
                threadDetails + " : " + MainMethodRunner.testObject.getTestObject()
        );


        String changeFromThreadTwo = "This is from thread two.";
        refToTestObject.setTestObjectWithSychronizedBlock(changeFromThreadTwo);

        System.out.println(threadDetails + refToTestObject.getTestObject());
    }
}