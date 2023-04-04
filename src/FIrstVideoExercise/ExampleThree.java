package FIrstVideoExercise;

public class ExampleThree {

    private static class runnableObject implements Runnable{

        @Override
        public void run() {
            System.out.println("the thread works as expected, the code inside the passed object runs properly");
        }
    }
    protected static class accessibleRunnableObject implements Runnable{

        @Override
        public void run() {
            System.out.println("the thread works as expected, the code inside the passed object runs properly"
            + "\nthis is from the protected inner class, because the private inner class cannot be accessed outside"
            + "\nI do not know if this will work out as expected."
            );
        }
    }
}

class ThreadExecutioner {

    public static void main(String[] args) {

//        this will not work because the private access modifier makes sure that the static inner class can only be
//        detected inside of the class it was declared from.
//        ExampleThree.runnableObject privaeteObjectWithCodeToRun = new ExampleThree.runnableObject();

        ExampleThree.accessibleRunnableObject privateRunnableObject = new ExampleThree.accessibleRunnableObject();

        Thread testThread = new Thread( privateRunnableObject );

        testThread.start();

    }

}