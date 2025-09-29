import java.util.*;

class KeyObject {
    int value;
    int frequency;

    public KeyObject(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }
}

class LFUCache {

    // Maps the key to KeyObject (which holds value and frequency)
    Map<Integer, KeyObject> map;
    
    // Maps frequency to a LinkedHashSet of keys (to track which keys have which frequency)
    Map<Integer, LinkedHashSet<Integer>> frequencyMap;
    
    int capacity;
    int minFrequency;  // To keep track of the minimum frequency

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.minFrequency = 0;  // Initially, no frequency
    }

    public int get(int key) {
        // If the key is not in the cache, return -1
        if (!map.containsKey(key))
            return -1;

        // Get the KeyObject and increase the frequency
        KeyObject object = map.get(key);
        int originalFrequency = object.frequency;
        int newFrequency = originalFrequency + 1;

        // Remove the key from the current frequency list
        Set<Integer> elements = frequencyMap.get(originalFrequency);
        elements.remove(key);

        // If the old frequency list is now empty, remove it from the frequencyMap
        if (elements.size() == 0) {
            frequencyMap.remove(originalFrequency);
            if (originalFrequency == minFrequency) {
                minFrequency++;  // If this was the minimum frequency, increment it
            }
        }

        // Add the key to the new frequency list
        frequencyMap.putIfAbsent(newFrequency, new LinkedHashSet<>());
        frequencyMap.get(newFrequency).add(key);

        // Update the frequency of the KeyObject in the map
        object.frequency = newFrequency;
        map.put(key, object);

        return object.value;
    }

    public void put(int key, int value) {
        // If the capacity is zero, we can't store anything
        if (capacity == 0) {
            return;
        }

        // If the key is already in the cache, update its value and call `get` to update its frequency
        if (map.containsKey(key)) {
            map.get(key).value = value;  // Update value
            get(key);  // This will also update the frequency
            return;
        }

        // If the cache is at capacity, we need to remove the least frequently used (LFU) item
        if (map.size() >= capacity) {
            // The least frequently used items are in `frequencyMap.get(minFrequency)`
            Set<Integer> elements = frequencyMap.get(minFrequency);
            Integer lfuKey = elements.iterator().next();  // Get the first item in the least frequently used set
            elements.remove(lfuKey);  // Remove it from the frequency set

            // If the set is now empty, remove the frequency group from the map
            if (elements.size() == 0) {
                frequencyMap.remove(minFrequency);
            }

            // Finally, remove the LFU key from the main map
            map.remove(lfuKey);
        }

        // Insert the new key with a frequency of 1
        KeyObject newObject = new KeyObject(value, 1);
        map.put(key, newObject);
        frequencyMap.putIfAbsent(1, new LinkedHashSet<>());
        frequencyMap.get(1).add(key);

        // Reset the minimum frequency to 1 (since we just inserted a new item with frequency 1)
        minFrequency = 1;
    }
}