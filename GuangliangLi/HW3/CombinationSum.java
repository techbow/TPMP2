package tpmp;

import java.util.ArrayList;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum1(int[] candidates, int target) {
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        dfs(path, res, 0, candidates, target);
        return res;

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