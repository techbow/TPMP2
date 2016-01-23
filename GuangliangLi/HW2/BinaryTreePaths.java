package tpmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

    public List<String> getBinaryTreePaths(TreeNode root) {
        if (root == null) return null;
        List<String> path = new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        getPath(root, path, res);
        Stack stack = new Stack();
        stack.clone();
        return res;

    }
    
    public void getPath(TreeNode root, List<String> path, List<String> res){
    	if(path.size() == 0){
    		path.add(String.valueOf(root.val));
    	}else{
    		path.add("->".concat(String.valueOf(root.val)));
        }
    	if(root.left == null && root.right == null){
    		connectNode(path, res);
    		path.remove(path.size()-1);
    	}else{
        	if(root.left != null){
        		getPath(root.left, path, res);
        	}
        	if(root.right != null){
        		getPath(root.right, path, res);
        	}
        	path.remove(path.size()-1);
    	}
    }
    public void connectNode(List<String> path, List<String> res){
    	StringBuffer tmp = new StringBuffer();
    	for(int i =0; i < path.size(); i++){
    		tmp.append(path.get(i));
    	}
    	res.add(tmp.toString());
    }

}
