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
public class Solution2 {
	Stack<List<Integer>>stack=new Stack<List<Integer>>();
	Map<Integer,List<Integer>>map=new HashMap<Integer,List<Integer>>();
	List<List<Integer>>result=new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer>composite=new ArrayList<Integer>();
		for(int k:candidates) {
			int tmp=k;
        	composite.add(k);
        	while(tmp<=target) {//1+1=2;出现重复的地方，Map(2,[2])会覆盖掉Map(2,[1,1])
        		List<Integer>list=new ArrayList<Integer>();
        		list.addAll(composite);
        		map.put(tmp,list);
        		tmp+=k;
        		composite.add(k);
        	}
        	composite.clear();
        }
        Object[] com=map.keySet().toArray();
        Arrays.sort(com);
        for(Object k:com) {
        	System.out.println(k);
        	System.out.println(map.get(k));
        }
        cal(com,target,0);
        return result;
    }
	private void cal(Object[] com,int target,int index) {
		if(target<0)return;
		if(target==0) {
			List<List<Integer>> tmp =  new ArrayList<List<Integer>>(stack);
			List<Integer>res=new ArrayList<Integer>();
			for(List<Integer>l:tmp) {
				res.addAll(l);
			}
			System.out.println(res);
			result.add(res);
			return;
		}
		while(index<com.length&&target-(int)com[index]>=0) {
			stack.push(map.get((int)com[index]));
			cal(com,target-(int)com[index],index+1);
			stack.pop();
			index++;
		}
	}
	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[] a = {1,2};
		List<List<Integer>>result=s.combinationSum(a,2);
		System.out.println(result);
	}
}
