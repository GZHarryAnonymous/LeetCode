package qu_30;

import java.util.ArrayList;
import java.util.List;
/**
 * String���������⣿ʲôʱ���ǳ����ش�����ʲôʱ����ʹ�����еĻ����´����ģ�
 * ����ʱ������String���intern()������
 * ��������Ϊ�˱���Ƶ���Ĵ��������ٶ����Ӱ��ϵͳ���ܣ���ʵ���˶���Ĺ���
 */	
public class TestTest {
	public static void main(String args[]) {
		String s="a";
		System.out.println("".hashCode());
		System.out.println(s.hashCode());
		
		String s0=new String("a");
		System.out.println(s0.hashCode());
		System.out.println(s==s0);
		
		String s1 = "Hello";//ֱ�ӷ��볣����
		String s2 = "Hello";//
		String s3 = "Hel" + "lo";//������ƴ���Ż�����ͬ��"Hello"
		String s4 = "Hel" + new String("lo");//new String("balabala")���ݲ�ȷ�����������޷��Ż���
		String s5 = new String("Hello");//ͬ������������Ż���
		String s6 = s5.intern();//����ʱ�Ż������볣����
		String s7 = "H";
		String s8 = "ello";
		String s9 = s7 + s8;//���������Ϊ��������������Ԥ�ϣ��޷��Ż���          
		System.out.println(s1 == s2);  // true
		System.out.println(s1 == s3);  // true
		System.out.println(s1 == s4);  // false
		System.out.println(s1 == s9);  // false
		System.out.println(s4 == s5);  // false
		System.out.println(s1 == s6);  // true
	}
}
