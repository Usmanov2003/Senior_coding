import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map;

public class DatabaseSharding { 
    private List<Map<Integer, String>> shards;
    private int numberOfShards;

    public DatabaseSharding(int numberOfShards) { 
        this.numberOfShards = numberOfShards;
        this.shards = new ArrayList<>();
        for (int i = 0; i < numberOfShards; i++) {
            this.shards.add(new hashMap<>());
        }
    }

    public void put(int key, String value) { 
        int shardsIndex = key % numberOfShards;
        shards.get(shardIndex).put(key, value);
    }

    public String get(int key) { 
        int shardIndex = key % numberOfShards;
        return shards.get(shardIndex).get(key);
    }

    public static void main(String[] args) {
        DatabaseSharding databaseSharding = new DatabaseSharding(4);

        databaseSharding.put(1, "Data 1");
        databaseSharding.put(2, "Data 2");
        databaseSharding.put(5, "Data 5");
        databaseSharding.put(6, "Data 6");

        System.out.println(databaseSharding.get(1)); 
        System.out.println(databaseSharding.get(2)); 
        System.out.println(databaseSharding.get(5)); 
        System.out.println(databaseSharding.get(6)); 
    }
}