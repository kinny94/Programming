package questions.leetcode.util;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    // Constructor for an empty list
    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    // Constructor for a single integer
    public NestedInteger(int value) {
        this.value = value;
        this.list = null;
    }

    // Check if this NestedInteger holds a single integer
    public boolean isInteger() {
        return value != null;
    }

    // Get the single integer this NestedInteger holds
    // Returns null if it holds a nested list
    public Integer getInteger() {
        return value;
    }

    // Set this NestedInteger to hold a single integer
    public void setInteger(int value) {
        this.value = value;
        this.list = null;
    }

    // Get the nested list this NestedInteger holds
    // Returns null if it holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }

    // Set this NestedInteger to hold a nested list
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
            value = null; // Reset value since it now holds a list
        }
        list.add(ni);
    }

    @Override
    public String toString() {
        if (isInteger()) {
            return value.toString();
        } else {
            return list.toString();
        }
    }
}

