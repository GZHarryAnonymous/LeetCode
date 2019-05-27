package qu_53;
//ʹ�÷���˼��
public class Solution2 {
    //������������������
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0)return 0;
        int result = maxCalcuLeftToRight(nums,0,len-1);
        return result;
    }
    //������������������
    public int maxCalcuLeftToRight(int[] nums,int l,int r){
        if(l == r)return nums[l];
        int mid = (l + r)/2;
        //<=mid���� >mid����  cross mid��������������������
        return compareThree(maxCalcuLeftToRight(nums,l,mid),maxCalcuLeftToRight(nums,mid+1,r),maxCrossMid(nums,l,mid,r));
    }
    //mid����������Ӵ����е����
    public int maxCrossMid(int[] nums,int l,int mid,int r){
        //mid������������Ӵ���
        int l_max=Integer.MIN_VALUE,part=0;
        for(int i=mid;i>=0;i--){
            part+=nums[i];
            if(part>l_max)l_max=part;
        }
        //mid+1������������Ӵ���
        part=0;
        int r_max=Integer.MIN_VALUE;
        for(int i=mid+1;i<=r;i++){
            part+=nums[i];
            if(part>r_max)r_max=part;
        }
        return l_max+r_max;
    }
    //����3���������е����ֵ
    public int compareThree(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
    public static void main(String args[]){
        Solution solve = new Solution();
        int[] nums = {-2,-1};
        int result = solve.maxSubArray(nums);
        System.out.println(result);
        //System.out.println(Integer.MAX_VALUE);
        //2147483647=Integer.MAX_VALUE
    }
}
