package qu_30;

import java.util.ArrayList;
import java.util.List;
/**
 * String的声明问题？什么时候是常量池创建，什么时候是使用已有的或者新创建的？
 * 运行时常量池String类的intern()方法。
 * 常量池是为了避免频繁的创建和销毁对象而影响系统性能，其实现了对象的共享。
 */	
public class TestTest {
	public static void main(String args[]) {
		String s="a";
		System.out.println("".hashCode());
		System.out.println(s.hashCode());
		
		String s0=new String("a");
		System.out.println(s0.hashCode());
		System.out.println(s==s0);
		
		String s1 = "Hello";//直接放入常量池
		String s2 = "Hello";//
		String s3 = "Hel" + "lo";//编译器拼接优化，等同于"Hello"
		String s4 = "Hel" + new String("lo");//new String("balabala")内容不确定，编译器无法优化。
		String s5 = new String("Hello");//同理编译器不会优化。
		String s6 = s5.intern();//运行时优化，放入常量池
		String s7 = "H";
		String s8 = "ello";
		String s9 = s7 + s8;//编译器理解为两个变量，不可预料，无法优化。          
		System.out.println(s1 == s2);  // true
		System.out.println(s1 == s3);  // true
		System.out.println(s1 == s4);  // false
		System.out.println(s1 == s9);  // false
		System.out.println(s4 == s5);  // false
		System.out.println(s1 == s6);  // true
	}
}
