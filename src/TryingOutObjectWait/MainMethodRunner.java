package TryingOutObjectWait;

public class MainMethodRunner {

    public static void main(String[] args) {

        testOutFirstSample();

    }

    /**
     *
     * sample code from Digital Ocean website.
     * <br><br>
     * The function shows how the wait and notify method
     * work with many threads.
     * <br><br>
     * The purpose of this test is to find out how the wait
     * method of the object class affects two threads accessing the
     * same sychronized block.
     * <br><br>
     * There are two threads accessing two threads, and one of those
     * threads will be the first to access the synchronized block,
     * which blocks any other threads from accessing the same
     * synchronized block.
     * <br><br>
     * The wait() method should work like an indefinite sleep() method,
     * a sleep method but with no time limit, and the only condition
     * for continuing the thread should be the notify method call of the
     * object that is the monitor object of the synchronized block.
     * <br><br>
     *
     * */
    public static void testOutFirstSample(){

        //this single TestMessage instance will be passed to two threads.
        TestMessage msg = new TestMessage("process it");



        TestWaiter waiter = new TestWaiter(msg);
        new Thread(waiter,"Waiter Thread 1" ).start();

        TestWaiter waiter1 = new TestWaiter(msg);
        new Thread(waiter1, "Waiter Thread 2").start();

        TestNotifier notifier = new TestNotifier(msg);
        new Thread(notifier, "Fucking Notifier Thread").start();
        System.out.println("All the threads are started");
    }
}
