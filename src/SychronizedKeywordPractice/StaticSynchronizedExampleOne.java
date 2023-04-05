package SychronizedKeywordPractice;

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

