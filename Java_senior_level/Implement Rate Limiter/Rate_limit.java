import java.util.concurrent.atomic.AtomicLong; 

public class RateLimiter { 
    private final long capacity; 
    private final long refillRate; 
    private AtomicLong tokens;
    private long lastRefillTime; 

    public RateLimiter(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillrate;
        this.tokens = new AtomicLong(capacity);
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean tryAcquire() {
        refillToken();
        if (tokens.get() > 0) { 
            tokens.decrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    private synchronized void refillToken() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastRefillTime;
        long tokensToAdd = elapsedTime * refillRate / 1000;
        tokens.set(Math.min(capacity, tokensget() + tokensToAdd));
        lastRefillTime = currentTime;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(10, 1); 

        for(int i = 0; i < 20; i++) { 
            if (rateLimiter.tryAcquire()) { 
                System.out.println("Action " + (i + 1) + " allowed");
            } else { 
                System.out.println("Action " + (i + 1) + " blocked");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { 
                e.printStackTrace();
            }
        }
    }
}