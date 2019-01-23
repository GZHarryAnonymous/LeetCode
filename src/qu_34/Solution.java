package qu_34;

public class Solution {
	public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        int[] result=new int[2];
        if(len==0) {
        	result[0]=-1;
        	result[1]=-1;
        	return result;
        }
        int value=searchValue(nums,target,0,len-1);
        //System.out.println(value);
        result=rangeValue(nums,target,value);
        return result;
    }
	private int searchValue(int[] nums,int target,int start,int end) {
		if(start==end) {
			if(nums[start]==target) {
				return start;
			}else {
				return -1;
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
	private int[] rangeValue(int[] nums,int target,int value) {
		int[] result=new int[2];
		if(value==-1) {
			result[0]=-1;
			result[1]=-1;
			return result;
		}
		int start=value,end=value;
		while(start>0&&nums[start-1]==target) {
			start--;
		}
		int len=nums.length-1;
		while(end<len&&nums[end+1]==target) {
			end++;
		}
		result[0]=start;
		result[1]=end;
		return result;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums = {5,7,7,8,8,10};
		int target=6;
		int[] result = new int[2];
		result=s.searchRange(nums,target);
		for(int t:result) {
			System.out.println(t);
		}
	}
}
