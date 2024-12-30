package questions.leetcode;

import java.util.HashMap;
import java.util.TreeMap;

class TimeBasedKeyValueStore {

    HashMap<String, TreeMap<Integer, String>> keyTimeMap;

    public TimeBasedKeyValueStore() {
        keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new TreeMap<Integer, String>());
        }
        keyTimeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }

        Integer floor = keyTimeMap.get(key).floorKey(timestamp);
        if (floor != null) {
            return keyTimeMap.get(key).get(floor);
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
