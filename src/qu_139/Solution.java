package qu_139;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int[] mark = new int[s.length()+1];
		mark[0]=1;
		List<Integer>wordsLenDict=new ArrayList<Integer>();
		for(String per_word:wordDict){
			if(wordsLenDict.contains(per_word.length())==false){
				wordsLenDict.add(per_word.length());
			}
		}
		for (int l = 1; l <=s.length(); l++) {
			for(int w_len:wordsLenDict){
				int r=l-1+w_len;
				if (mark[l-1]==1&&r<=s.length()&&wordDict.contains(s.substring(l-1,r)))
					mark[l-1+w_len] = 1;
			}
		}
		return mark[s.length()] == 1;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		String str = "leetcodee";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		boolean result=s.wordBreak(str,wordDict);
		System.out.println(result);
	}
}

