package qu_41;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
	public int firstMissingPositive(int[] nums) {
		if(nums.length==0)return 1;//nums 为空
		Arrays.sort(nums);// 双中心快排
		int firstMiss = 1;
		for (int num : nums) {
			if (num < 0)
				continue;// 确保正数
			if (num > 0) {
				if (num > firstMiss)
					return firstMiss;
				if (num < firstMiss)
					continue;// 考虑重复的情况。[1,1]
				firstMiss++;
			}
		}
		return nums[nums.length - 1] + 1;// [1,2,3]应该返回4
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums = {1,1};
		int result= s.firstMissingPositive(nums);
		System.out.println(result);
	}
}
/*相关说明：
 *基于LeetCode平台算法的一个刷题记录！
 *已经共享至public repository，链接如下：
 *https://github.com/GZHarryAnonymous/LeetCode
 *欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 *个人博客：https://gzharryanonymous.github.io/
 *欢迎来访！当然，如果来访还打赏就更好啦！！！
 *能力有限，希望有帮到你！
 **/
