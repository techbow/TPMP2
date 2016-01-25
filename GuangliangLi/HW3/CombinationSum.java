package tpmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        
        dfs(path, res, 0, candidates, target);
        
        List<List<Integer>> ret = new ArrayList<>(res);
        return ret;

    }
    
    public void dfs(ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, int position,
                       int[] candidates, int target){
        int sum = getSum(path);
        if(sum > target){
            return;
        }else if(sum == target){
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = position; i < candidates.length; i++){
            path.add(candidates[i]);
            dfs(path, ret, i, candidates, target); 
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