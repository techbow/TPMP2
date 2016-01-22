325. Maximum Size Subarray Sum Equals K

TEST CASE: [], k = 0
           [1, -1, 5, -2, 3], k = 0
           [1, -1, 5, -2, 3], k = 3
           [-2, -1, 2, 1], k = 2

// 用hashmap存第0位到第i位的和，key为和，value为index。如果key里有 sum - k 更新max
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null) return 0;
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int sum = 0, max = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put (sum, i);
            }
        }
        return max;
    }
}


             