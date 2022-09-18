package interview.lru_cache;

import java.util.*;

public class LruCache<K, V> {

    private final int maxCapacity;
    private final Map<K, V> storage;
    private final List<K> queue;
    private int capacity = 0;

    public LruCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.storage = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public void add(K key, V value) {
        if (storage.containsKey(key)) {
            storage.put(key, value);
            queue.remove(key);
            queue.add(key);
        } else {
            storage.put(key, value);
            if (capacity < maxCapacity) {
                capacity++;
            } else {
                K removed = queue.remove(0);
                storage.remove(removed);
                queue.add(key);
            }
            queue.add(key);
        }
    }

    public Optional<V> get(K key) {
        return Optional.ofNullable(storage.get(key));
    }

    public static void main(String[] args) {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.add(1, "one");
        cache.add(2, "two");
        cache.add(1, "one-updated");
        cache.add(3, "three");
        System.out.println(cache.get(1));
    }
}
