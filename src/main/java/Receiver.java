public class Receiver implements Runnable {

    private final Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        while (true) { // solange das Paket nicht "Ende" ist, empfange weiterhin
            String receivedMsg = load.receive();

            if (receivedMsg.equals("End")) {
                break;
            }

            System.out.println(receivedMsg);

            try {
                Thread.sleep(500);  // Receiver-Loading-Zeit hinzufügen
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
