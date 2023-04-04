
public class Main {
    public static void main(String[] args) {

        ThreadCompletionRate();
    }

    public static void testingThreadNames(){

        System.out.println("name of this thread : " + Thread.currentThread().getName() );

        Thread testThread = new Thread(
            new Runnable(){
                public void run(){
                System.out.println(
                "name of thread : " + Thread.currentThread().getName() +
                "\nI hate java and I miss java" );
            }
        }
        , "fucking thread");


        testThread.start();
    }


    public static void ThreadCompletionRate(){

        Integer numberToChange = 23;

        customThread testThreadOne = new customThread( numberToChange, "first thread" );
        customThread testThreadTwo = new customThread( numberToChange, "second thread" );

        testThreadOne.start();
        testThreadTwo.start();

        System.out.println( numberToChange );
    }
}

class customThread extends Thread{

    Integer variableToEdit;

    public customThread( Integer variableToEdit, String name){

        super(name);
        this.variableToEdit = variableToEdit;

    }

    public void run(){


        System.out.println("fucking thread runs : " + Thread.currentThread().getName());
    }
}

class something implements Runnable{

    @Override
    public void run() {

    }
}
