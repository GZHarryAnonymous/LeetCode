package qu_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(3);
		l.add(2);
		System.out.println(l);

		HashMap<String,Integer> map= new HashMap<>();
		map.put("aaa", 1);
		map.put("bbb", 1);
		String s = new String("ddd");
		map.put(s,4);
		
		HashMap<String,Integer> mapCopy = (HashMap)map.clone();//浅拷贝，引用类型变量包括String，ArrayList只是拷贝的引用。
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
				System.out.println(mapCopyObject==mapObject);//浅拷贝
			}
		}
		
		System.out.println("this is map:");
		output(map);
		System.out.println("this is mapCopy:");
		output(mapCopy);
		/*
		 * 下面对List类型变量进行测试：
		 */
		HashMap<List<Integer>,Integer> mapList= new HashMap<>();
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		mapList.put(list, 1);
		
		HashMap<List<Integer>,Integer> mapListCopy = (HashMap)mapList.clone();
		System.out.println(mapList==mapListCopy);//false
		mapListCopy.put(list, 2);
		
		list.add(4);//浅拷贝会影响list类型变量,因为简单的拷贝引用绝非真正意义上的复制。
		list.remove(1);//list的add和remove会变换原list引用？应该不会。
		List<Integer> lc=list;
		lc.add(9);
		System.out.println(list);
		System.out.println(lc);
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
