public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String> ();
        String s = "";
        DFS(res, s, n, n, n*2);
        return res;
    }
    private void DFS(List<String> res, String s, int left, int right, int n) {
        if (left > right) {
            return;
        }
        if (n == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            DFS(res, s+"(", left-1, right, n-1);
        }
        if (right > 0) {
            DFS(res, s+")", left, right -1, n-1);
        }
        
    }
}
