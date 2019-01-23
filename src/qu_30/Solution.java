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
class Solution {
public List<Integer> findSubstring(String s, String[] words) {
		int wordNum=words.length;
		List<Integer>list=new ArrayList<Integer>();
		if(wordNum==0)return list;
        int word_len=words[0].length(),words_len=word_len*words.length;
        if(word_len==0||words_len==0)return list;
        HashMap<String,Integer>map=new HashMap<>();//此处map的声明没有使用Map，而是使用HashMap，目的是后面使用clone()方法。
        for(String str:words) {//记录每个word出现的次数，通过hashMap，其中key是字符串word，值是其出现的次数。
        	/***下面的代码片段可以进一步简化为map.put(str, map.getOrDefault(str, 0));
        	 * if(map.containsKey(str)) {
        			map.put(str, map.get(str)+1);//key值相同，之前的被覆盖，相当于更新value值。
        		}else {
        			map.put(str, 1);
        		}
        	 */
        	map.put(str, map.getOrDefault(str, 0)+1);
        }
        int s_len=s.length(),i_len=s_len-words_len;
        for(int i=0;i<=i_len;i++) {//i为开始比较的字符下标，i到结尾应该足够包含words.
        	Map<String,Integer> records=(HashMap)map.clone();//clone是浅拷贝，但此处不影响使用！
        	int start=i;
        	while(start<=i+words_len-word_len) {
        		String word=s.substring(start, start+word_len);//选取第一个word.
            	int value=records.getOrDefault(word, 0);//接下来获得其value值。
            	if(value!=0){//注意substring(start,end)是从start开始，end-1结束，不包括end字符本身。
            		records.put(word, value-1);
            		if(start==i+words_len-word_len) {//当前匹配word为最后一个子串，成功！
            			list.add(i);
            			break;
            		}
            	}else {
            		break;//i~i+words_len  存在words以外的字符串
            	}
            	start+=word_len;
        	}
        }
        return list;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s="barfoothefoobarman";
		String[] words = {"foo","bar"};
		List<Integer> result=solution.findSubstring(s, words);
		System.out.println(result);
	}
}