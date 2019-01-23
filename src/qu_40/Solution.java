package qu_40;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
public class Solution {
	List<List<Integer>>result=new ArrayList<List<Integer>>();
	Stack<Integer>stack=new Stack<Integer>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        cal(candidates,target,0);
        return result;
    } 
    private void cal(int[] candidates,int target,int index) {
    	if(target<0)return;
    	if(target==0) {
    		//System.out.println(new ArrayList<Integer>(stack));
    		List<Integer> l = new ArrayList<Integer>(stack);
    		if(!result.contains(l)) {
    			result.add(l);
    		}
    		return;
    	}
      	while(index<candidates.length&&target-candidates[index]>=0) {
    		stack.push(candidates[index]);
    		cal(candidates,target-candidates[index],index+1);
    		stack.pop();
    		index++;
    	}
    }
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] a = {10,1,2,7,6,1,5};
		List<List<Integer>>result=s.combinationSum2(a,8);
		System.out.println(result);
	}
}
