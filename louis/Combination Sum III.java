public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> path = new ArrayList<Integer> ();
        helper(res, path, n, 1, k);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> path, int n, int index, int k) {
        if (n == 0 && path.size() == k) {
            res.add(new ArrayList<Integer> (path));
        }
        for (int j = index; j <= 9; j++) {
            if (j > n || path.size() > k) break;
            path.add(j);
            helper(res, path, n - j, j + 1, k);
            path.remove(path.size() - 1);
        }
    }
}
