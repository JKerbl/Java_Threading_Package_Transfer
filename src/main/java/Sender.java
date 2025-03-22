import java.util.List;

public class Sender implements Runnable {

    private final Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        List<String> packages = List.of("First package", "Second Package", "Third Package", "Fourth Page", "End");

        for (String packet : packages) {
            data.send(packet);

            try {
                Thread.sleep(500);  // Server-Loading-Zeit hinzufügen
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
