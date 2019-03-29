package t7;

public class Writer extends Thread {

    final private Document document;

    Writer(Document document) {
        this.document = document;
    }

    @Override
    public void run() {

        synchronized (document) {
            while (!document.isReady()) {
                try {
                    document.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        System.out.println("Writing data from " + Thread.currentThread().getName());
    }
}
