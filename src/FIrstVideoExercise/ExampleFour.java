package FIrstVideoExercise;

import java.util.concurrent.Executors;

public class ExampleFour {


    /*
    * Trying out creating a thread using an anonymous class.
    *
    * I want to practice keeping my attention focus on the task,
    * at the same time put my hand on the wheels.
    *
    * The focus would be to try out ways to create a thread in java
    *
    * */
    public static void main(String[] args) {

        Thread testThread = new Thread(
                () -> {
            System.out.println(
                "the thread runs properly, the name of the thread is: "
                + Thread.currentThread().getName()
            );

            while ( Thread.currentThread().isAlive() ){
                System.out.println(" thread is running...");
                try {
                    Thread.sleep(2123);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    throw new RuntimeException(e);
                }
            }
            ;
        },
        "test thread with a name"
        );

        testThread.start();
    }
}
