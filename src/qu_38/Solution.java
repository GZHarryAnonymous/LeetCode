package qu_38;

public class Solution {
	public String countAndSay(int n) {
		if(n==0)return "";
		String s="1";
	    while(--n!=0) {
	    	s=process(s);
	    	//System.out.println(s);
	    }
	    return s;
    }
	private String process(String s) {
		System.out.println(s);
		int count=1,len=s.length();
		StringBuffer result=new StringBuffer("");
		for(int i=0;i<len-1;i++) {
			while(i+1<len&&s.charAt(i)==s.charAt(i+1)) {
				count++;
				i++;
			}
			result.append(count);
			result.append(s.charAt(i));
			count=1;
		}
		if((len-2>=0&&s.charAt(len-2)!=s.charAt(len-1))||len==1) {
			result.append(1);
			result.append(s.charAt(len-1));
		}
		return result.toString();
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		String result = s.countAndSay(9);
		System.out.println(result);
	}
}
