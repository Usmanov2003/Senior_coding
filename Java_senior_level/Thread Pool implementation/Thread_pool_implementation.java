import java.util.concurrent.BlockingQueue; 
import java.util.concurrent.LinkedBlockingQueue; 

public class ThreadPool { 
    private final BlockingQueue<Runnable> queue; 
    private final Thread[] threads;

    public ThreadPool(int numOfThreads) {
        queue = new LinkedBlockingQueue<>();
        threads = new Thread[numOfThreads];

        for (int i = 0; i < numOfThreads; i++) { 
            threads[i] = new Thread(new Worker());
            threads[i].start();
        }
    }

    public void submit(Runnable task) { 
        try {
            queue.put(task);
        } catch (InterruptedException e) { 
            Thread.currentThread().interrupt();
        }
    }

    private class Worker implements Runnable {
        @Override 
        public void run() {
            while (true) {
                try { 
                    Runnable task = queue.take();
                    task.run();
                } catch(InterruptedException e) { 
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public shutdown() { 
        for (Thread thread : threads) { 
            thread.interrupt();
        }
    }
}