package qu_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Final_submission {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		int wordsNum = words.length;
		if (wordsNum == 0)
			return result;
		int word_len = words[0].length(), words_len = word_len * wordsNum, str_len = s.length();
		HashMap<String, Integer> allWords = new HashMap<>();
		for (int i = 0; i < wordsNum; i++) {
			allWords.put(words[i], allWords.getOrDefault(words[i], 0) + 1);
		}
		for (int i = 0; i < word_len; i++) {
			HashMap<String, Integer> records = new HashMap<>();
			int count = 0;
			for (int start = i; start <= str_len - words_len; start += word_len) {
				int end = start;
				while (true) {
					if (count == wordsNum) {
						result.add(start);
						String head_word = s.substring(start, start + word_len);
						records.put(head_word, records.get(head_word) - 1);
						start += word_len;
						count--;
					}
					if (end + word_len > str_len)
						break;
					String curWord = s.substring(end, end + word_len);
					int curWordValue = allWords.getOrDefault(curWord, 0);
					if (curWordValue > 0) {
						int recordsValue = records.getOrDefault(curWord, 0);
						if (recordsValue < curWordValue) {
							records.put(curWord, recordsValue + 1);
							count++;
						} else {
							do {
								String head_word = s.substring(start, start + word_len);
								start += word_len;
								if (head_word.equals(curWord))
									break;
								records.put(head_word, records.get(head_word) - 1);
								count--;
							} while (true);
						}
						end += word_len;
					} else {
						records.clear();
						count = 0;
						start = end;
						break;
					}
				}
			}
		}
		return result;
	}
}
