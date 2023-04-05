package SychronizedKeywordPractice;


class ActionToRun implements Runnable{
    @Override
    public void run() {


        String threadDetails = "from Thread # " + Thread.currentThread().getName();
        SychronizedExampleOne refToTestObject = MainMethodRunner.testObject;

        System.out.println(
            threadDetails + " : " + MainMethodRunner.testObject.getTestObject()
        );


        String changeFromThreadTwo = "This is from thread two.";
        refToTestObject.setTestObjectWithSychronizedBlock( changeFromThreadTwo );

        System.out.println( threadDetails + refToTestObject.getTestObject());
    }
}



public class SychronizedExampleOne {
    protected String testObject = null;
    protected synchronized void setTestObjectWithSynchronizedFunction( String newObject ){

        getTestObject();
        this.testObject = newObject;
    }

    protected synchronized void setTestObjectWithSychronizedBlock( String newObject ){
        synchronized ( this ){
            this.testObject = newObject;
        }
    }
    protected synchronized String getTestObject(){
        return this.testObject;
    }
}


