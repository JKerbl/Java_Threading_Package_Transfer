public class Data {

    private String packet;
    private boolean transfer = true;

    // receive() wird vom Receiver-Thread aufgerufen:
    public synchronized String receive() {
        while (transfer) { // warten solange es kein neues Paket gibt
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        transfer = true;
        notifyAll();
        return packet;
    }

    // send() wird vom Sender-Thread aufgerufen:
    public synchronized void send(String packet) {
        while (!transfer) { // wartet, solange ein Paket noch unterwegs ist
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.packet = packet;
        transfer = false;
        notifyAll();
    }
}
