package qu_42;

import java.util.*;
import java.util.stream.Collectors;
// https://leetcode.com/problems/trapping-rain-water/solution/
// һ��һ���,��ʱ��
public class Solution {
	// ��ӡ�߶�����
	public void print_height(int[] height){
		for(int i=0;i<height.length;i++){
			System.out.print(height[i]+" ");
		}
		System.out.println();
	}
	// �õ���һ���߶Ȳ�Ϊ����±�
	public int get_start_index(int[] height,int len){
		int start = 0;
		while(start<len&&height[start]==0){
			start++;
		}
		return start;
	}
	// �߶ȼ�һ�����б��Ƿ����
	public boolean height_minus_value(int[] height,int start,int len,int value){
		int num=0;
		for(int i=start;i<len;i++){
			if(height[i]>0){
				height[i]-=value;
				if(height[i]>0)num++;
			}
		}
		if(num>1)return true;
		else return false;
	}
	// ͳ�Ƶ�ǰ��߶ȣ�һ��һ��ͳ�Ƶķ�ʽ
	public int height_cal(int[] height,int len,int value){
		int start = get_start_index(height,len);
		int head_index=start;
		int result=0;
		for(int i=start+1;i<len;i++){
			if(height[i]>=value){
				result+=(i-1-head_index)*value;
				head_index=i;
			}
		}
		return result;
	}
	public void process_value(Integer[] values){
		int index = 0;
		while (values[index]==0){
			index++;
			if(index==values.length)return;
		}
		int num = values[index];
		for(int i = index;i<values.length;i++){
			values[i]-=num;
		}
	}
	// ������
	public int trap(int[] height) {
		int len = height.length;
		if(len<=2)return 0;
		int start = get_start_index(height,len);
		int result=0;
		int[] values = height.clone();
		List<Integer> lists = Arrays.stream(values).boxed().collect(Collectors.toList());
		Set<Integer> sets = new HashSet<Integer>(lists);
		Object[] values_one = sets.toArray();
		Integer[] values_Integer = new Integer[values_one.length];
		for(int i=0;i<values_one.length;i++){
			values_Integer[i]=(Integer) values_one[i];
		}
		Arrays.sort(values_Integer);
		int values_index=0;
		if(values_Integer[values_index]==0)values_index++;
		int value = 0;
		do{
			value = values_Integer[values_index++];
			result += height_cal(height,len,value);
			process_value(values_Integer);
		}while(height_minus_value(height,start,len,value));
		return result;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = s.trap(height);
		System.out.println(result);
	}
}

