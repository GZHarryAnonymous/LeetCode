package qu_29;
import java.util.Collection;
import java.util.List;
import java.util.Set;
class ControlBitsForAddMinusMultiDiv {
	public int add(int a,int b) {
        int res=a;
        int xor=a^b;//�õ�ԭλ�ͣ���λ��Ӻ�û�н�λ�ĺ�
        int forward=(a&b)<<1;//�õ���λ��
        if(forward!=0){//����λ�Ͳ�Ϊ0����ݹ���"ԭλ��"����"��λ��"
            res=add(xor, forward);
        }else{
            res=xor;//����λ��Ϊ0�����ʱԭλ��Ϊ�����
        }
        return res;
    }
	public int minus(int a,int b) {//Ĭ��b����0
        int B=~(b-1);//��~n=-(n+1)������ת��Ϊ�ӷ����˴��൱�����������b�Ĳ��룬Ҳ����-b
        return add(a, B);        
    }
	public int multi(int a,int b){
        int i=0,res=0;
        while(b!=0){//����Ϊ0�����
            //���������ǰλ
            if((b&1)==1){
                res+=(a<<i);
                b=b>>1;
                ++i;//i��¼��ǰλ�ǵڼ�λ
            }else{
                b=b>>1;
                ++i;
            }
        }
        return res;
    }
	public int sub(int a,int b) {
        int res=-1;
        if(a<b){
            return 0;
        }else{
            res=sub(minus(a, b), b)+1;//�����ǵݹ�ļ�����
        }
        return res;
    }
	private static void binaryToDecimal(int n) {//��ʮ������תΪ��Ӧ�Ķ�������
		for(int i=31;i>=0;i--) {
			System.out.print(n>>>i&1);
		}
		System.out.println();
	}
	//���������ᱬջ����������Զ���ڳ�����ʱ��
		//Exception in thread "main" java.lang.StackOverflowError
		public int divide(int dividend, int divisor) {
			//if(dividend>2>>31-1||dividend<-2<<31||divisor>2>>31-1||divisor<-2<<31) {
				//return 2>>31-1;
			//}
			//if(dividend>Integer.MAX_VALUE||dividend<Integer.MIN_VALUE||divisor>Integer.MAX_VALUE||divisor<Integer.MIN_VALUE) {
				//return Integer.MAX_VALUE;
			//}
			boolean symbol=true;
			long d=dividend,b=divisor,count=1,result=0;
			if(dividend<0){d=-d;symbol=!symbol;}
			if(divisor<0){b=-b;symbol=!symbol;}
			long tmp=b;
			while(d-b>=0) {
				while(d-tmp>=0) {
					tmp=tmp<<1;
					count=count<<1;
				}
				tmp=tmp>>1;
				count=count>>1;
				d-=tmp;
				result+=count;
				tmp=b;
				count=1;
			}
	        if(!symbol) {
	        	if(-result<Integer.MIN_VALUE)return Integer.MAX_VALUE;
	        	return (int) -result;
	        }
	        if(result>Integer.MAX_VALUE)return Integer.MAX_VALUE;
	        return (int) result;
	    }
		public int divideNew(int dividend, int divisor) {
			long a=(long)dividend,b=(long)divisor,res=0;
			if(a<0)a=-a;
			if(b<0)b=-b;
			for(int i=32;i>=0;i--) {
				if(a>>i>=b) {
					res+=1l<<i;//�˴�ע�����ͣ�
					a-=b<<i;
				}
			}
			res=(dividend>0)==(divisor>0)?res:-res;
			if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)return Integer.MAX_VALUE;
			return (int)res;
		}
	public static void main(String[] args){
		System.out.println(~3);
		binaryToDecimal(3);
		binaryToDecimal(-4);
		binaryToDecimal(127);
		binaryToDecimal(-128);
		
		ControlBitsForAddMinusMultiDiv t = new ControlBitsForAddMinusMultiDiv();
		System.out.println(t.add(1, 2));
		System.out.println(t.minus(1, 2));
		System.out.println(t.multi(1, 2));
		System.out.println(t.sub(3, 2));
		System.out.println(t.divide(2147483647, -1));
		System.out.println(t.divideNew(2147483647, -1));
		/*
		 * ��c�����У��з����ַ���(signed char)��ռһ���ֽڣ����ȷ�ΧΪ-128 ~ 127
		 * ���޷����ַ���(signed char)��Ҳռһ���ֽڣ����ȷ�ΧΪ0 ~ 255
		 * 
		 * ��java��û���޷������ͣ�������ͨ��λ����õ���Ӧ���޷������͡�
		 * ���磺
		 * byte b=-1;��Ӧ�Ĳ���Ϊ��1111 1111
		 * ��b&0x0FF��Ϊ���Ӧ���޷���ֵ����255.
		 */
		byte b = -1;
		System.out.println(b&0x0FF);
	}
}
/* 
 * 
��Java��һ����8�ֻ����������ͣ�1byte=8bits��
4������:
byte 1�ֽ� -128~127(-2^7 ~ 2^7-1) һ��8bits����һλ�Ƿ���λ����1000 0000(-128) ~ 0111 1111(127)
short 2�ֽ� -32768��32767
int 4�ֽ� -2147483648��2147483647
long 8�ֽ� -9223372036854775808 ~ 9223372036854775807(-2^31 ~ 2^31-1)
2�ָ�������:
float 4�ֽ� -3.4E38��3.4E38
double 8�ֽ� -1.7E308��1.7E308
1�����ڱ�ʾUnicode������ַ���Ԫ���ַ�����:
char 2�ֽ� ���ַ��Ͷ�Ӧ�������������֣����ʾ��Χ��0��65535
1�����ڱ�ʾ��ֵ��boolean����:
boolean 1 true��false
 * >>>   �߼���λ�����磺num>>>n ���ʾ�����ƶ�nλ����λ��0
 * >>    ������λ������ͬ����������λ��0��������λ��1
 * <<    ��λ���������ƶ�nλ����λ��0
 * ˵�������߼�ȡ���ǰѷ����Ϊ�㣬�����Ϊһ��~��ʾ��λȡ������1��Ϊ0����0��Ϊ1.
 * 
 * ������д洢������ʽ�Ƕ����Ʋ��룬���������λ����ֵλ�����з���λΪ0��ʾ����������λΪ1��ʾ������
 * ����������ԭ�롢����Ͳ��붼��ͬ���������Ƿ���λΪ1�Ķ������ַ������ң�����=ԭ��ȡ��+1������λ���䣩
 * 
 * ���磺3�����Ʊ�ʾ0000 0011����ȡ����1111 1100.���ڵ�һλ��1����3ȡ�������Ϊһ�������Ĳ��룬
 * ���������ǣ���ò����ȥ1Ϊ1111 1011��ȡ��Ϊ0000 0100����ԭ���ʾ����4����˵���ò����ʾ-4.
 * ��ͨ�õģ�����n��һ����������ô~n=-(n+1).����Ҳ���ԴӲ���Ķ���ȥ��������ʽ��ԭ��n��ȡ��Ϊ~n����1Ϊ~n+1Ϊ���룬����ʾ-(n+1)
 * ��Ӧ�Ļ�ȡ����n�Ķ����ƴ����һ��1:
 * ~(n-1)&n=-n&n
 * ȥ������n�Ķ����ƴ������һ��1:
 * n&(n-1)
 * 
 * reference:
 * λ����ʵ����������:	
 * https://www.cnblogs.com/ygj0930/p/6412875.html
 * ��������壿	Ϊ���üӷ�������ʾ�������㣬��ȥһ�������൱�ڼ���������Ķ�Ӧ�Ĳ��롣
 * https://www.cnblogs.com/myseries/p/5204878.html
 */