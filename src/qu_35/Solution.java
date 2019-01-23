package qu_35;
public class Solution {
	public int searchInsert(int[] nums, int target) {
        int len=nums.length;
        if(len==0) {
        	return 0;
        }
        int value=searchValue(nums,target,0,len-1);
        //System.out.println(value);
        return value;
    }
	private int searchValue(int[] nums,int target,int start,int end) {
		if(start==end) {
			if(nums[start]==target) {
				return start;
			}else if(nums[start]>target){
				return start;
			}else {
				return start+1;
			}
		}
		int middle=(start+end)/2;
		if(nums[middle]==target) {
			return middle;
		}else if(nums[middle]>target){
			//System.out.println(middle);
			return searchValue(nums,target,start,middle);
		}else {
			return searchValue(nums,target,middle+1,end);
		}
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums = {5,7,7,8,8,10};
		int target=9;
		int result=s.searchInsert(nums,target);
		System.out.println(result);
		
	}
}
