package qu_43;

public class Solution {
	public String multiply(String num1, String num2) {
		String result="";
		int num1_len=num1.length();
		int num2_len=num2.length();
		String num_min=num1,num_max=num2;
		int num_len_min=num1_len,num_len_max=num2_len;
		if(num1_len>num2_len){
			num_min=num2;
			num_max=num1;
			num_len_min=num2_len;
			num_len_max=num1_len;
		}
		if(num_min.equals("0"))return "0";
		//result=add_per(result,multiply_per(num_max,""+num_min.charAt(num_len_min-1)));
		//System.out.println(result);
		String zero_num="";
		for(int j=num_len_min-1;j>=0;j--){
			//System.out.println(num_min.charAt(j));
			result=add_per(result,multiply_per(num_max,""+num_min.charAt(j))+zero_num);
			zero_num+="0";
			//System.out.println(result);
		}
		return result;
	}
	public String add_per(String num1,String num2){
		int num1_len=num1.length();
		int num2_len=num2.length();
		String result="";
		int accumulate=0;
		String num_min=num1,num_max=num2;
		int num_len_min=num1_len,num_len_max=num2_len;
		if(num1_len>num2_len){
			num_min=num2;
			num_max=num1;
			num_len_min=num2_len;
			num_len_max=num1_len;
		}
		for(int i=0;i<num_len_min;i++){
			int n1=num_min.charAt(num_len_min-1-i)-'0';
			int n2=num_max.charAt(num_len_max-1-i)-'0';
			int cur=n1+n2+accumulate;
			result=cur%10+result;
			accumulate=cur/10;
		}
		if(accumulate>0){
			if(num_len_min==num_len_max){
				result=accumulate+result;
			}
			for(int j=num_len_min;j<num_len_max;j++){
				int n=num_max.charAt(num_len_max-1-j)-'0';
				int cur=n+accumulate;
				result=cur%10+result;
				accumulate=cur/10;
				if(accumulate==0){
					result=num_max.substring(0,num_len_max-1-j)+result;
					break;
				}
				if(j==num_len_max-1&&accumulate>0){
					result=accumulate+result;
				}
			}
		}else{
			result=num_max.substring(0,num_len_max-num_len_min)+result;
		}
		return result;
	}
	public String multiply_per(String num1, String num2) {
		int num1_len=num1.length();
		int num=num2.charAt(0)-'0';
		if(num==0)return "0";
		int accumulate_bit=0;
		String result="";
		for(int i=0;i<num1_len;i++){
			int num1_i=num1.charAt(num1_len-i-1)-'0';
			int cur=num1_i*num+accumulate_bit;
			result=cur%10+result;
			accumulate_bit=cur/10;
		}
		//System.out.println(result);
		if(accumulate_bit>0){
			result=accumulate_bit+result;
		}
		return result;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
        //直接用字符串计算，如果采用整形数组存储结果，之后再统一转化为String也可以，且节省了字符到整形的转化。
		System.out.println(s.multiply_per("123","6"));
		System.out.println(s.add_per("123","456"));

		String result=s.multiply("123","456");
		System.out.println(result);
	}
}

