package tpmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        getSubsets(ret, path, 0, nums);
        List<List<Integer>> res = new ArrayList<>(ret);
        return res;
    }
    
    private void getSubsets(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path, int pos, int[] nums){
        ret.add(new ArrayList<Integer>(path));
        for(int i = pos; i < nums.length; i++){
            path.add(nums[i]);
            getSubsets(ret, path, i + 1, nums);
            path.remove(path.size()-1);
        }
    }
}
