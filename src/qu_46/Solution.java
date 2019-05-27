package qu_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	int deep=0;
	List<String>result=new ArrayList<>();
	public List<String> permute(int[] nums) {
		boolean tag[] = new boolean[nums.length];
		get_permute(nums,tag,"");
		return result;
	}
	public void get_permute(int[] nums,boolean[] tag,String per_result){
		if(per_result.length()==nums.length){
			result.add(per_result);
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(i==0)deep++;
			if(tag[i]==false){
				tag[i]=true;
				String s=per_result+nums[i];
				//per_result+=nums[i];//error 改变了第一层余后的
				//per_result的作用域范围
				//java 参数传递：值传递
				//System.out.println(""+deep+":"+per_result);
				get_permute(nums,tag,s);
				tag[i]=false;
			}
		}
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums={1,2,3};
		s.permute(nums);
		System.out.println(s.result);
	}
}

