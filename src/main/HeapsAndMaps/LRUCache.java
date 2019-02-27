package HeapsAndMaps;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 *
 * Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.
 *
 *  NOTE: If you are using any global variables, make sure to clear them in the constructor.
 * Example :
 *
 * Input :
 *          capacity = 2
 *          set(1, 10)
 *          set(5, 12)
 *          get(5)        returns 12
 *          get(1)        returns 10
 *          get(10)       returns -1
 *          set(6, 14)    this pushes out key = 5 as LRU is full.
 *          get(5)        returns -1
 */
public class LRUCache {
    private Deque<Integer> deque;
    private HashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        deque = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            deque.removeFirstOccurrence(key);
            deque.addFirst(key);
            return map.get(key);
        }
        else
            return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            deque.removeFirstOccurrence(key);
            deque.addFirst(key);
            map.put(key, value);
        }
        else {
            if (deque.size()==capacity) {
                int toRemove = deque.removeLast();
                map.remove(toRemove);
            }
            deque.addFirst(key);
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache1 = new LRUCache(2);
        cache1.set(1, 10);
        cache1.set(5, 12);
        System.out.println(cache1.get(5));
        System.out.println(cache1.get(1));
        System.out.println(cache1.get(10));
        cache1.set(6, 14);
        System.out.println(cache1.get(5));
    }
}
