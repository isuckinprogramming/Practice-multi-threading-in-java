package TryingOutObjectWait;

/**
 * An object to be mutated to test out how the wait() method
 * call works.
 * <br><br>
 * A normal java bean class, with private fields, and public access and mutator.
 * <br><br>
 * */
public class TestMessage {
    private String msg;

    public TestMessage(String str){
        this.msg=str;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String str) {
        this.msg=str;
    }
}
