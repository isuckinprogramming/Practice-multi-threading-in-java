package TryingOutObjectWait;

public class TestNotifier implements Runnable {

    private TestMessage msg;

    public TestNotifier(TestMessage msg) {
        this.msg = msg;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name + " started");

        try {

            Thread.sleep(1000);

            synchronized (msg) {
                msg.setMsg(name);

//                Thread.sleep(3000);

//                msg.notify();
                 msg.notifyAll();
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
