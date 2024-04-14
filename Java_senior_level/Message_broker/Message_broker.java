import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageBroker { 
    private BlockingQueue<String> queue 

    public MessageBroker() { 
        this.queue = new LinkedBlockingQueue<>();
    }

    public void sendMessage(String message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) { 
            Thread.currentThread().interrupt();
        }
    }

    public String reveiveMessage() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public static void main(String[] args) {
        MessageBroker broker = new MessageBroker();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                broker.sendMessage("Message " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) { 
                System.out.println("Received: " + broker.receiveMessage());
            }
        }).start();
    }
} 