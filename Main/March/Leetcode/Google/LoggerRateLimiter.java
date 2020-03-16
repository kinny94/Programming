import java.util.*;

class LoggerRateLimiter {

    private Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public Logger() {
        this.map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
     public boolean shouldPrintMessage(int timestamp, String message) {
        if (this.map.containsKey(message)) {
            int ts = this.map.get(message);
            if (timestamp - ts >= 10) {
                this.map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            this.map.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */