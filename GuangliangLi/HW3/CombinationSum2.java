package tpmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        HashMap<String, String> dupCheckMap = new HashMap<String, String>();
        Arrays.sort(candidates);
        
        dfs(path, res, 0, candidates, target, dupCheckMap);
        List<List<Integer>> ret = new ArrayList<>(res); 
        return ret;

    }
    
    public void dfs(ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, int position,
                       int[] candidates, int target, HashMap<String, String> dupCheckMap){
        int sum = getSum(path);
        if(sum > target){
            return;
        }else if(sum == target){
            boolean existFlg = checkExist(path, dupCheckMap);
            if (!existFlg){
                ret.add(new ArrayList<Integer>(path));
                return;
            }
        }
        for(int i = position; i < candidates.length; i++){
            path.add(candidates[i]);
            dfs(path, ret, i+1, candidates, target, dupCheckMap); 
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
    
    public boolean checkExist(ArrayList<Integer> path, HashMap<String, String> dupCheckMap){
        
        StringBuffer tmp = new StringBuffer();
        for(int num : path){
            tmp = tmp.append(String.valueOf(num));
        }
        String key = tmp.toString();
        if(dupCheckMap.get(key) == null){
            dupCheckMap.put(key,key);
            return false;
        }else{
            return true;
        }
    }
}
