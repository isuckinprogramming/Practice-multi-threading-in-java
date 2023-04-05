package SychronizedKeywordPractice;


/**
 * I want to test out if there is only one instance of an object then
 * would it result to multiple threads having to block each other to
 * gain access over the synchronized methods or code blocks.
 * <br><br>
 * To test this out, a integer variable is incremented by
 * a synchronized function, this integer variable is private
 * so that the only way to access or mutate it is through the
 * methods of this class.
 * <br><br>
 * There are no getters for this integer variable, so to
 * mutate it, the increment method for this class would
 * be called, which is synchronized, so if more than one thread
 * would access it, then the later thread coming to access the method
 * would have to wait.
 * <br><br>
 * I hope that this would prevent the loss of incrementations on
 * the variable. Which is evident when there are two
 * threads updating the value of a thread base on the previous
 * reading of the data of a variable. Which should be
 * solved by the synchronized keyword.
 * <br><br>
 * but there are still missing incrementations.
 *
 *
 * */
public class StaticSynchronizedExampleOne {

    protected static Integer testNumber = 0;


    protected static synchronized void incrementTestNumber() {
        testNumber += 1;
    }

    protected static synchronized void setTestObjectWithSynchronizedFunction(String newObject) {

//        testObject = newObject;
    }

    protected static synchronized void setTestObjectWithSychronizedBlock(String newObject) {
        synchronized (StaticSynchronizedExampleOne.class) {
//            this.testObject = newObject;
        }
    }
//
//    protected static synchronized String getTestObject(){
//
//        return testObject;
//    }
}

