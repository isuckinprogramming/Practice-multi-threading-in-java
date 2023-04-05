package SychronizedKeywordPractice;

public class MixedSynchronizedExampleOne {
    protected static String dataToMutate;
    protected String nonStaticDataToMutate;


    public MixedSynchronizedExampleOne() {
    }

    protected static synchronized void setDataToMutate(String newData) {
        dataToMutate = newData;
    }

    protected void setNonStaticDataToMutate(String newData) {
        this.nonStaticDataToMutate = newData;
    }
}