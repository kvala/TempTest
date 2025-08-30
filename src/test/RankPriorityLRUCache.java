import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class RankLRUCache<K, V> {

    private class CacheEntry {
        K key;
        V value;
        long rank;

        CacheEntry(K key, V value, long rank) {
            this.key = key;
            this.value = value;
            this.rank = rank;
        }
    }

    private final int capacity;
    private final HashMap<K, CacheEntry> cacheMap;
    private final PriorityQueue<CacheEntry> priorityQueue;
    private long accessCounter = 0;

    public RankLRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        
        // The comparator determines the eviction policy.
        // In this case, we evict the item with the lowest rank.
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingLong(entry -> entry.rank));
    }

    public V get(K key) {
        if (cacheMap.containsKey(key)) {
            CacheEntry entry = cacheMap.get(key);
            // Update the rank of the accessed item.
            // A simple LRU rank could be a timestamp or a counter.
            // Note: This requires an O(log n) update in the PriorityQueue.
            priorityQueue.remove(entry); // O(n) in a standard PQ, but can be optimized
            entry.rank = ++accessCounter;
            priorityQueue.add(entry); // O(log n)
            return entry.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            CacheEntry existingEntry = cacheMap.get(key);
            // Update the existing entry's value and rank
            priorityQueue.remove(existingEntry); // O(n)
            existingEntry.value = value;
            existingEntry.rank = ++accessCounter;
            priorityQueue.add(existingEntry); // O(log n)
        } else {
            // Evict if cache is full
            if (cacheMap.size() >= capacity) {
                CacheEntry lowestRanked = priorityQueue.poll(); // O(log n)
                if (lowestRanked != null) {
                    cacheMap.remove(lowestRanked.key);
                }
            }
            // Add new entry
            CacheEntry newEntry = new CacheEntry(key, value, ++accessCounter);
            cacheMap.put(key, newEntry);
            priorityQueue.add(newEntry); // O(log n)
        }
    }
}
