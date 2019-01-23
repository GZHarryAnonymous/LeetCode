package q_1;

import java.util.HashMap;
import java.util.Map;

public class HashMap_test {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		//正常情况
		map.put(1,10);
		System.out.println(map.containsKey(1));
		System.out.println(map.get(1));
		System.out.println();
		//当value为null
		map.put(2, null);
		System.out.println(map.containsKey(2));
		System.out.println(map.get(2));
		System.out.println();
		//当key不存在
		System.out.println(map.containsKey(3));
		System.out.println(map.get(3));
		System.out.println();
	}
}
