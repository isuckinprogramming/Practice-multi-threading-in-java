package TryingOutObjectWait;

public class TestWaiter implements Runnable {

    private TestMessage msg;

    public TestWaiter(TestMessage m){
        this.msg=m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {

            try{
                //I cannot understand the value that comes form the currentTimeMillis, What does all of those numbers mean????????
                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                msg.wait();

            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+" processed: " + msg.getMsg() );
        }
    }
}
