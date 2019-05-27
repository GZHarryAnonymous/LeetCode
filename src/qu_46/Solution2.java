package qu_46;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>>result=new ArrayList<>();
		boolean tag[] = new boolean[nums.length];
		List<Integer> per_result=new ArrayList<>();
		get_permute(nums,tag,per_result,result);
		return result;
	}
	public void get_permute(int[] nums,boolean[] tag,List<Integer> per_result,List<List<Integer>> result){
		if(per_result.size()==nums.length){
			result.add(new ArrayList<>(per_result));
			//per_result.clear();
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(tag[i]==false){
				tag[i]=true;
				List<Integer> per_result_new=new ArrayList<>(per_result);
				per_result_new.add(nums[i]);
				//String s=per_result+nums[i];
				//per_result+=nums[i];//error 改变了第一层余后的
				//per_result的作用域范围
				//java 参数传递：值传递
				//System.out.println(""+deep+":"+per_result);
				get_permute(nums,tag,per_result_new,result);
				tag[i]=false;
			}
		}
	}
	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[] nums={1,2,3};
		System.out.println(s.permute(nums));
	}
}

