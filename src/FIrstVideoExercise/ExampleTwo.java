package FIrstVideoExercise;

public class ExampleTwo {
    public static class InnerThreadClass extends Thread{

        public static void main(String[] args) {
            System.out.println("main method inside the static inner class is running not the outer class");
        }

        @Override
        public void run() {
            System.out.println("i love the convenient way of testing shit out, because I don't know how to use the debugger");
        }
    }

    public static void main(String[] args) {

        System.out.println("main method outside is running, inside the outer class");

        InnerThreadClass testThread = new InnerThreadClass();
        testThread.start();
    }
}
