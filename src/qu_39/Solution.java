package qu_39;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.Iterator;
public class Solution {
	Stack<Integer>stack=new Stack<Integer>();
	List<List<Integer>>result=new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		for(int k:candidates) {
			System.out.println(k);
			}
		cal(candidates,target,0);
		return result;
	}
	private void cal(int[] candidates,int target,int index) {
		if(target<0)return;
		if(target==0) {
			List<Integer> tmp = new ArrayList<Integer>(stack);
			System.out.println(tmp);
			result.add(tmp);
			return;
		}
		while(index<candidates.length&&target-candidates[index]>=0) {
			stack.push(candidates[index]);
			cal(candidates,target-candidates[index],index);
			stack.pop();
			index++;
		}
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] a = {8,7,4,3};
		List<List<Integer>>result=s.combinationSum(a,11);
		System.out.println(result);
	}
}
