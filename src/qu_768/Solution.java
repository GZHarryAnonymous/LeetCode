package qu_768;
// current num can divided into a isolated area only if it is smaller than right area.
// 左边最大的小于等于右边最小的。
public class Solution {
	public int maxChunksToSorted(int[] arr) {
		int len = arr.length;
		int count = 1;
		if(len==0)return 0;
		if(len==1)return 1;
		int[] leftMax = new int[len];
		leftMax[0] = arr[0];
		for(int i=1;i<len-1;i++){
			leftMax[i]=Math.max(leftMax[i-1],arr[i]);
		}
		int rightMin = arr[len-1];
		for(int i=len-2;i>=0;i--){
			if(leftMax[i]<=rightMin){
				count++;
			}
			rightMin=Math.min(rightMin,arr[i]);
		}
		return count;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] arr = {2,1,3,4,4};
		int result=s.maxChunksToSorted(arr);
		System.out.println(result);
	}
}

