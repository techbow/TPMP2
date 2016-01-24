public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if (candidates == null || candidates.length == 0) {
             return res;
        }
        Arrays.sort(candidates);
        helper(candidates, path, 0, res, target);
        return res;
    }
    private void helper(int[] candidates, List<Integer> path, int index, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));            
        }
        if (index == candidates.length) {
            return;
        }
        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (candidates[i] == prev) continue;
            path.add(candidates[i]);
            helper(candidates, path, i+1, res, target-candidates[i]);
            prev = candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
