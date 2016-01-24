public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(res, path, nums, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        res.add(new ArrayList<Integer>(path));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
