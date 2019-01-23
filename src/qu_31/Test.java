package qu_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int[] a= {3,2,1};
		Arrays.sort(a,0,3);
		for(int i:a) {
			System.out.println(i);
		}
		
		///
		HashMap<String,Integer> map= new HashMap<>();
		map.put("aaa", 1);
		map.put("bbb", 1);
		String s = new String("ddd");
		map.put(s,4);
		
		HashMap<String,Integer> mapCopy = (HashMap)map.clone();//ǳ�������������ͱ�������String��ArrayListֻ�ǿ��������á�
		mapCopy.put("ccc", 1);
		mapCopy.put("aaa", 2);
		mapCopy.put(s,5);
		
		System.out.println("this is map:");
		output(map);
		System.out.println(map.get("aaa"));
		
		System.out.println("this is mapCopy:");
		output(mapCopy);
		System.out.println(mapCopy.get("aaa"));
		for(Object mapCopyObject:mapCopy.keySet()) {
			for(Object mapObject:map.keySet()) {
				System.out.println(mapCopyObject==mapObject);//ǳ����
			}
		}
		
		System.out.println("this is map:");
		output(map);
		System.out.println("this is mapCopy:");
		output(mapCopy);
		/*
		 * �����List���ͱ������в��ԣ�
		 */
		HashMap<List<Integer>,Integer> mapList= new HashMap<>();
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		mapList.put(list, 1);
		
		HashMap<List<Integer>,Integer> mapListCopy = (HashMap)mapList.clone();
		mapListCopy.put(list, 2);
		
		list.add(4);//ǳ������Ӱ��list���ͱ���,��Ϊ�򵥵Ŀ������þ������������ϵĸ��ơ�
		list.remove(1);//list��add��remove��任ԭlist���ã�
		
		System.out.println("this is mapList:");
		output(mapList);
		System.out.println("this is mapListCopy:");
		output(mapListCopy);
	}
	private static void output(HashMap map) {
		for(Object str:map.keySet()) {
			System.out.println(str+" "+map.get(str));
		}
	}
}
