public class Main {
    public static void main(String[] args) {
        Thread pool = new ThreadPool(5); 

        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            pool.submit(() -> { 
                System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
            });
        }

        pool.shutdown();
    }
}