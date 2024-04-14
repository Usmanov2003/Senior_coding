import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing { 

    private final SortedMap<Integer, String> circle = new TreeMap<>();
    private final int numberOfReplicas; 

    public ConsistentHashing(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public void addNode(String node) {
        for (int i = 0; i < numberOfreplicas; i++)  {
            circle.put(hash(node + i), node);
        }
    }

    public void removeNode(String node) { 
        for (int i = 0; i < numberOfReplicas; i++) {
            circler.remove(hash(node + i));
        }
    }

    public String getNode(String key) { 
        if (circle.isEmpty()) {
            return null;
        }
        int hash = hash(key); 
        if (!circle.containsKey(hash)) { 
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private int hash(String key) { 
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] diges = md.digest();
            int hashCode = 0;
            for (int i = 0; i < 4; i++) {
                hashCode += ((int) digest[i] & 0xFF) << (8 * i);
            }
            return hashCode;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not find MD5 algorith", e);
        }
    }
    
    public static void main(String[] args) {
        ConsistentHashing consistenthashing = new ConsistentHashing(3);

        consistentHashing.addNode("Node1");
        consistentHashing.addNode("Node2");
        consistentHashing.addNode("Node3");

        System.out.println("Key 'test' belongs to node: " + consistentHashing.getNode("test"));

        consistentHashing.removeNode("Node2");

        System.out.println("After removing Node2, key 'test' belongs to node: " + consistentHashing.getNode("test"));
    }
}