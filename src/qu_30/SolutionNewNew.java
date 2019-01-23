package qu_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class SolutionNewNew {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();//声明结果集！
		int wordsNum=words.length;//words单词个数。
		if(wordsNum==0)return result;
		int word_len=words[0].length(),words_len=word_len*wordsNum,str_len=s.length();
		HashMap<String,Integer>allWords=new HashMap<>();
		for(int i=0;i<wordsNum;i++) {
			allWords.put(words[i],allWords.getOrDefault(words[i], 0)+1);//计算不同单词各自出现次数。
		}
		for(int i=0;i<word_len;i++){
			HashMap<String,Integer>records=new HashMap<>();//记录当前窗口已有单词情况。
			int count=0;
			System.out.println("i================================="+i);/////////////
			for(int start=i;start<=str_len-words_len;start+=word_len){
				int end=start;
				//while(end<=str_len-word_len) {
				while(true) {
					if(count==wordsNum) {
						System.out.println("count================================="+count);/////////////
						result.add(start);
						String head_word=s.substring(start,start+word_len);
						System.out.println("start="+start);
						System.out.println("head_word="+head_word);/////////////
						System.out.println(s.substring(start,start+words_len));/////////////
						records.put(head_word,records.get(head_word)-1);
						start+=word_len;
						count--;
					}
					if(end+word_len>str_len)break;
					String curWord=s.substring(end,end+word_len);
					int curWordValue=allWords.getOrDefault(curWord, 0);
					if(curWordValue>0) {
						
						System.out.println("curWordValue>0");/////////////
						System.out.println("curWord="+curWord+" "+"curWordValue="+curWordValue);/////////////
						int recordsValue=records.getOrDefault(curWord, 0);
						if(recordsValue<curWordValue) {
							System.out.println("recordsValue<curWordValue");/////////////
							System.out.println("recordsValue="+recordsValue);/////////////
							
							records.put(curWord, recordsValue+1);
							count++;
							
						}else {
							System.out.println("recordsValue<curWordValue:else");/////////////
							
							do{	System.out.println("do");/////////////
								String head_word=s.substring(start,start+word_len);
								start+=word_len;
								System.out.println("head_word="+head_word);/////////////
								System.out.println("start="+start);/////////////
								if(head_word.equals(curWord))break;
								records.put(head_word, records.get(head_word)-1);
								count--;
							}while(true);
							//records.put(curWord, curWordValue);
							
						}
						end+=word_len;
						System.out.println("end_=word_len");
						System.out.println("end="+end);
					}else{
						System.out.println("curWordValue>0:else");/////////////
						records.clear();
						count=0;
						start=end;
						System.out.println("start="+start);/////////////
						break;
						
					}
				
				}
			}
		}
		
		return result;
		
		
	}

	public static void main(String[] args) {
		SolutionNewNew solution = new SolutionNewNew();
		String s = "wordgoodgoodgoodbestword";
		String[] words = { "word","good","best","good" };
		List<Integer> result = solution.findSubstring(s, words);
		System.out.println(result);
	}
}