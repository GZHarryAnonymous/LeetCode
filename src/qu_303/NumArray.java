package qu_303;
public class NumArray {
	private int[] dp;
	public NumArray(int[] nums) {
		int len=nums.length;
		dp = new int[len];
		for(int i=0;i<len;i++){
			if(i==0){
				dp[i]=nums[i];
			}else{
				dp[i]=dp[i-1]+nums[i];
			}
		}
	}

    public int sumRange(int i, int j) {
        if(i==0)return dp[j];
        return this.dp[j]-this.dp[i-1];
    }
	public static void main(String args[]) {
		int nums[] = {-2, 0, 3, -5, 2, -1};
		NumArray s = new NumArray(nums);
		int result=s.sumRange(1,2);
		System.out.println(result);
	}
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/