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

class SolutionNew {
	public List<Integer> findSubstring(String s, String[] words) {
		int wordNum = words.length;
		List<Integer> list = new ArrayList<Integer>();
		if (wordNum == 0)
			return list;
		int word_len = words[0].length(), words_len = word_len * words.length;
		if (word_len == 0 || words_len == 0)
			return list;
		HashMap<String, Integer> map = new HashMap<>();// �˴�map������û��ʹ��Map������ʹ��HashMap��Ŀ���Ǻ���ʹ��clone()������
		for (String str : words) {// ��¼ÿ��word���ֵĴ�����ͨ��hashMap������key���ַ���word��ֵ������ֵĴ�����
			/***
			 * ����Ĵ���Ƭ�ο��Խ�һ����Ϊmap.put(str, map.getOrDefault(str, 0));
			 * if(map.containsKey(str)) { map.put(str,
			 * map.get(str)+1);//keyֵ��ͬ��֮ǰ�ı����ǣ��൱�ڸ���valueֵ�� }else { map.put(str, 1); }
			 */
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		/*
		 * int s_len=s.length(),i_len=s_len-words_len; for(int i=0;i<=i_len;i++)
		 * {//iΪ��ʼ�Ƚϵ��ַ��±꣬i����βӦ���㹻����words. Map<String,Integer>
		 * records=(HashMap)map.clone();//clone��ǳ���������˴���Ӱ��ʹ�ã� int start=i;
		 * while(start<=i+words_len-word_len) { String word=s.substring(start,
		 * start+word_len);//ѡȡ��һ��word. int value=records.getOrDefault(word,
		 * 0);//�����������valueֵ��
		 * if(value!=0){//ע��substring(start,end)�Ǵ�start��ʼ��end-1������������end�ַ�����
		 * records.put(word, value-1); if(start==i+words_len-word_len)
		 * {//��ǰƥ��wordΪ���һ���Ӵ����ɹ��� list.add(i); break; } }else { break;//i~i+words_len
		 * ����words������ַ��� } start+=word_len; } }
		 */
		// ���������Ĵ�������Ż���������iһ����word_len������ѭ��word_len�Ρ�
		int s_len = s.length(), i_len = s_len - word_len;// �����i_len�Ѿ�����������
		for (int k = 0; k < word_len; k++) {
			Map<String, Integer> records = (HashMap) map.clone();
			int start = k, count = 0;
			for (int i = k; i <= i_len; i += word_len) {
				String word = s.substring(i, i + word_len);
				int value = records.getOrDefault(word, 0);
				if (value > 0) {
					records.put(word, value - 1);// β����//////////////////////////////ע�⣡����
					count++;// ��¼����������ƥ������ַ���word�ĸ�����
					if (count == wordNum) {				
						list.add(start);
						String head = s.substring(start, start + word_len);
						records.put(head, records.getOrDefault(word, 0) + 1);//////////// ע�⣡�����˴�value��Ҫ������ȡ��
						start += word_len;
						count--;// ͷȥ��
					}
				} else {
					if (!map.containsKey(word)) {// words����ĵ��ʣ�����������������㣡
						count = 0;
						records = (HashMap) map.clone();
						start = i + word_len;
					} else {// words�еĵ��ʣ����Ǵ������ˣ�������Ҫ�ƶ�������һ�γ��ָ�wordʱ�Ժ󴰿ڲſɼ������䣡
						while (!s.substring(start, start + word_len).equals(word)) {
							String head = s.substring(start, start + word_len);
							records.put(head, value + 1);// ͷȥ��
							start += word_len;
							count--;// �����ڼ�С��
						}
						start += word_len;// ͷȥβ����
						if (count == wordNum) {// ��ֹβͷword��ȣ��Ҽ�β֮ǰ�иպóɹ��������
							list.add(start);
							String head = s.substring(start, start + word_len);// ͷȥ��
							records.put(head, value + 1);
							start += word_len;
							count--;
						}
					}
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		SolutionNew solution = new SolutionNew();
		String s = "abaababbaba";
		String[] words = { "ba", "ab", "ab" };
		List<Integer> result = solution.findSubstring(s, words);
		System.out.println(result);
	}
}