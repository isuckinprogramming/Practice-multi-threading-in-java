package SychronizedKeywordPractice;

class mainRunner{
    static SychronizedExampleOne testObject = new SychronizedExampleOne();

    public static void main(String[] args) {

        ActionToRun ActionObj = new ActionToRun();

        Thread testThreadOne = new Thread( ActionObj, " 1" );
        Thread testThreadTwo = new Thread( ActionObj, "2" );


        testThreadOne.start();
//
//        try {
//
//            testThreadOne.join();
//        } catch (InterruptedException e) {
//
//            throw new RuntimeException(e);
//        }

        testThreadTwo.start();

    }

    private void exampleFromGuide(){


        Thread testThreadOne = new Thread (
            () ->{

            }
        );


        Thread testThreadTwo = new Thread (
            () ->{

            }
        );


        testThreadOne.start();
        testThreadTwo.start();

    }


}


class ActionToRun implements Runnable{
    @Override
    public void run() {


        String threadDetails = "from Thread # " + Thread.currentThread().getName();
        SychronizedExampleOne refToTestObject = mainRunner.testObject;

        System.out.println(
            threadDetails + " : " + mainRunner.testObject.getTestObject()
        );


        String changeFromThreadTwo = "This is from thread two.";
        refToTestObject.setTestObjectWithSychronizedBlock( changeFromThreadTwo );

        System.out.println( threadDetails + refToTestObject.getTestObject());
    }
}




public class SychronizedExampleOne {

    protected String testObject = null;


    protected synchronized void setTestObjectWithSynchronizedFunction( String newObject ){

        this.testObject = newObject;
    }

    protected synchronized void setTestObjectWithSychronizedBlock( String newObject ){
        synchronized ( this ){
            this.testObject = newObject;
        }
    }

    protected synchronized String getTestObject(){

        return testObject;
    }


}
