package questions.leetcode;

import java.util.ArrayList;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Bucket {
    private ArrayList<Pair<Integer, Integer>> bucket;

    public Bucket() {
        bucket = new ArrayList<>();
    }

    public int get(int key) {
        for (Pair<Integer, Integer> kv: bucket) {
            if (kv.getKey() == key) {
                return kv.getValue();
            }
        }
        return -1;
    }

    public void update(int key, int value) {
        boolean found = false;
        for (int i=0; i<bucket.size(); i++) {
            Pair<Integer, Integer> kv = bucket.get(i);
            if (key == kv.getKey()) {
                bucket.set(i, new Pair<Integer,Integer>(key, value));
                found = true;
                break;
            }
        }

        if (!found) {
            bucket.add(new Pair<>(key, value));
        }
    }

    public void remove(int key) {
        for (int i=0; i<bucket.size(); i++) {
            Pair<Integer, Integer> kv = bucket.get(i);
            if (key == kv.getKey()) {
                bucket.remove(i);
                break;
            }
        }
    }
}

class DesignHashMap {

    public int keySpace;
    public Bucket[] buckets;

    public DesignHashMap() {
        keySpace = 2069;
        buckets = new Bucket[keySpace];
        for (int i=0; i<keySpace; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void put(int key, int value) {
        int hashKey = key % keySpace;
        buckets[hashKey].update(key, value);
    }

    public int get(int key) {
        int hashKey = key % keySpace;
        return buckets[hashKey].get(key);
    }

    public void remove(int key) {
        int hashKey = key % keySpace;
        buckets[hashKey].remove(key);
    }
}
