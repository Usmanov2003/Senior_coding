class SharedResource  {
    private int counter = 0; 

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() { 
        counter--;
    }

    public synchronized int getCounter() { 
        return counter;
    }
}

class WorkerThread extends Thread { 
    private SharedResource resource;

    public WorkerThread(SharedResource resource) {
        this.resource = resource; 
    }

    public void run() {
        for (int i = 0; i < 10000; i++) { 
            resource.increment();
            resource.decrement();
        }
    }
}

public class ConcurrencyControlDemo { 
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(); 

        WorkerThread[] threads = new WorkerThread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkerThread(resource);
            threads[i].start();
        }

        for (WortkerThread thread : threads) { 
            try { 
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final Counter Value: " + resource.getCounter());
    }
}