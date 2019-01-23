package qu_40;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
public class Solution4 {
	List<List<Integer>>result=new ArrayList<List<Integer>>();
	List<Integer>list=new ArrayList<Integer>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len=Math.min(Math.abs(Arrays.binarySearch(candidates, target)+1), candidates.length);
        //System.out.println(len);
        cal(candidates,target,0,len);
        return result;
    }
    private void cal(int[] candidates,int target,int index,int len) {
    	if(target<0)return;
    	if(target==0) {
    		if(!result.contains(list)) {
    			result.add(new ArrayList<Integer>(list));
    		}
    		return;
    	}
    	int lastPop=-1;
    	for(int i=index;i<len;i++) {
    		if(candidates[i]>target)break;//¼õÖ¦
    		if(candidates[i]==lastPop) {
      			continue;
      		}
    		list.add(candidates[i]);
    		//System.out.println("add:"+candidates[i]);
    		cal(candidates,target-candidates[i],i+1,len);
    		lastPop=list.remove(list.size()-1);
    		//System.out.println("remove:"+candidates[i]);
    	}
    }
	public static void main(String args[]) {
		Solution4 s = new Solution4();
		int[] a = {2,5,2,1,2};
		List<List<Integer>>result=s.combinationSum2(a,5);
		System.out.println(result);
	}
}
