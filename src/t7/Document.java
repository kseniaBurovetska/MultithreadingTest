package t7;

public class Document {

    private volatile byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    boolean isReady(){
        return data != null;
    }
}
