package t7;

public class Downloader extends Thread {

    private final Document document;

    Downloader(Document document){
        this.document = document;
    }

    @Override
    public void run() {
        System.out.println("Downloading...");

        synchronized (document){
            try {
                sleep(System.currentTimeMillis() % 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            document.setData("data".getBytes());
            document.notifyAll();
        }
    }
}
