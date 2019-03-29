package t7;

import java.util.ArrayList;

public class Test7 {

    public static void main(String[] args) {

        Document document = new Document();

        ArrayList<Writer> writers = new ArrayList<>();
        writers.add(new Writer(document));
        writers.add(new Writer(document));
        writers.add(new Writer(document));

        writers.forEach(Thread::start);


        Downloader downloader = new Downloader(document);
        downloader.start();
    }

}
