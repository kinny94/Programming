package questions.leetcode;

import java.util.HashMap;

public class LoggerRateLimiter {
    private HashMap<String, Integer> requests;
    int limit;

    public LoggerRateLimiter() {
        requests = new HashMap<String, Integer>();
        limit = 10;
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.requests.containsKey(message)) {
            this.requests.put(message, timestamp);
            return true;
        }

        if (timestamp - this.requests.get(message) >= limit) {
            this.requests.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
