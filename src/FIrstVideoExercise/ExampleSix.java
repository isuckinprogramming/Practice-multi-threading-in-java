package FIrstVideoExercise;

public class ExampleSix {

    public static void main(String[] args) {

    Thread testThread = new Thread( new testRunnableWithStop(), "test thread." );

     testThread.start();
    }


}

class testRunnableWithStop implements  Runnable {

    /**
     * not sure if this variable should be synchronized or not, since this would be modified
     * by possibly one or more threads.
     * <p>
     * given that the function for accessing it is synchrized, so should the variable be synchronized.
     */

    private boolean isStop = false;

    // access modifier -> generic parameters -> synchronized -> static -> return type -> function name
    /**
     *
     * The syncrhonized keyword is complicated because it does a lot of things in the background.
     *<br>
     *
     * a function or a variable with the syncronized keyword makes it so that only one thread has
     * access to it a time.
     *<br>
     * <br>
     * the syncronized keyword prevents other threads from accessing the function if one thread is
     * currently using it.
     * */

    public synchronized void requestStop() {

        this.isStop = true;
    }

    public synchronized boolean isThreadStopped() {
        return isStop;
    }


    @Override
    public void run() {
        while(Thread.currentThread().isAlive() ){

            try {
                Thread.sleep(2342);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println( "the method is running, but is not doing anything of importance ");
        }
    }
}
