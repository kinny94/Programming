import java.util.*;

class Solution {
    public String nextClosestTime(String time) {
        char[] ta = time.toCharArray();
        int[] nums = new int[4];
        nums[0] = ta[0] - '0';
        nums[1] = ta[1] - '0';
        nums[2] = ta[3] - '0';
        nums[3] = ta[4] - '0';
        Arrays.sort(nums);
        if (next(4, 9, nums, ta)
            || next(3, 5, nums, ta)
            || next(1, ta[0] == '2' ? 3 : 9, nums, ta))
        {
            return new String(ta);
        }
        next(0, 2, nums, ta);
        return new String(ta);
    }
    
    boolean next(int idx, int last, int[] nums, char[] ta)
    {
        int curr = ta[idx] - '0';
        for (int i = 0; i < 4; i++)
        {
            if (nums[i] > last)
            {
                break;
            }
            else if (nums[i] > curr)
            {
                ta[idx] = (char)(nums[i] + '0');
                return true;
            }
        }
        ta[idx] = (char)(nums[0] + '0');
        return false;
    }
}