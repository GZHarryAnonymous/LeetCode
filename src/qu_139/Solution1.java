package qu_139;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public void pan(String s,List<String>wordDict,List<Integer> wordsLenDict,int[] mark,int l){
		if(l>s.length())return;
		for(int w_len:wordsLenDict){
			int r=l-1+w_len;
			if (mark[l-1]==1&&r<=s.length()&&wordDict.contains(s.substring(l-1,r)))
				mark[l-1+w_len] = 1;
				pan(s,wordDict,wordsLenDict,mark,r+1);
		}
	}
	public boolean wordBreak(String s, List<String> wordDict) {
		int[] mark = new int[s.length()+1];
		mark[0]=1;
		List<Integer>wordsLenDict=new ArrayList<Integer>();
		for(String per_word:wordDict){
			if(wordsLenDict.contains(per_word.length())==false){
				wordsLenDict.add(per_word.length());
			}
		}
		pan(s,wordDict,wordsLenDict,mark,1);
		return mark[s.length()] == 1;
	}
	public static void main(String args[]) {
		Solution1 s = new Solution1();
		String str = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		boolean result=s.wordBreak(str,wordDict);
		System.out.println(result);
	}
}

