package tpmp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int [] candidates = {1,2,3,4,5,6,7,8,9};
        
        dfs(path, res, 0, candidates, k, n);
        List<List<Integer>> ret = new ArrayList<>(res); 
        return ret;

    }
    
    public void dfs(ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, int position,
                       int[] candidates, int cnt, int target){
        int sum = getSum(path);
        if(sum > target){
            return;
        }else if(sum == target){
            if(path.size() == cnt){
                ret.add(new ArrayList<Integer>(path));
                return;
            }
        }
        for(int i = position; i < candidates.length; i++){
            path.add(candidates[i]);
            dfs(path, ret, i + 1, candidates, cnt, target); 
            path.remove(path.size() - 1);
        }
            
    }
    
    public int getSum(ArrayList<Integer> path){
        int sum = 0;
        for(int i = 0; i < path.size(); i++){
            sum = sum + path.get(i);
        }
        return sum;
    }
    


}
