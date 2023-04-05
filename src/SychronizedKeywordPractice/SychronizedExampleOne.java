package SychronizedKeywordPractice;

/**
 *
 * I just wrote this today, I forgot already what it is meant to do.
 * <br><br>
 * My naming sucks.
 * <br><br>
 * I still cannot understand why I made this class.
 * <br><br>
 * I remember trying out synchronized blocks and synchronized keywords
 * on functions. I mean they both work the same way, they prevent other
 * threads from accessing the code if there is a thread in current access
 * to the code.
 * <br><br>
 * Works like an auto-lock that prevents others from accessing something.
 *
 * */
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


