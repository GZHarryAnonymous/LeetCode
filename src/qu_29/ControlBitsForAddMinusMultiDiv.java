package qu_29;
import java.util.Collection;
import java.util.List;
import java.util.Set;
class ControlBitsForAddMinusMultiDiv {
	public int add(int a,int b) {
        int res=a;
        int xor=a^b;//得到原位和，按位相加后没有进位的和
        int forward=(a&b)<<1;//得到进位和
        if(forward!=0){//若进位和不为0，则递归求"原位和"加上"进位和"
            res=add(xor, forward);
        }else{
            res=xor;//若进位和为0，则此时原位和为所求和
        }
        return res;
    }
	public int minus(int a,int b) {//默认b大于0
        int B=~(b-1);//由~n=-(n+1)将减法转换为加法，此处相当于求的是正数b的补码，也就是-b
        return add(a, B);        
    }
	public int multi(int a,int b){
        int i=0,res=0;
        while(b!=0){//乘数为0则结束
            //处理乘数当前位
            if((b&1)==1){
                res+=(a<<i);
                b=b>>1;
                ++i;//i记录当前位是第几位
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
            res=sub(minus(a, b), b)+1;//除法是递归的减法！
        }
        return res;
    }
	private static void binaryToDecimal(int n) {//将十进制数转为对应的二进制数
		for(int i=31;i>=0;i--) {
			System.out.print(n>>>i&1);
		}
		System.out.println();
	}
	//上述方法会爆栈，当被除数远大于除数的时候！
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
					res+=1l<<i;//此处注意类型！
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
		 * 在c语言中，有符号字符型(signed char)，占一个字节，长度范围为-128 ~ 127
		 * 而无符号字符型(signed char)，也占一个字节，长度范围为0 ~ 255
		 * 
		 * 在java中没有无符号类型，但可以通过位运算得到对应的无符号类型。
		 * 例如：
		 * byte b=-1;对应的补码为：1111 1111
		 * 则：b&0x0FF则为其对应的无符号值！即255.
		 */
		byte b = -1;
		System.out.println(b&0x0FF);
	}
}
/* 
 * 
在Java中一共有8种基本数据类型（1byte=8bits）
4种整型:
byte 1字节 -128~127(-2^7 ~ 2^7-1) 一共8bits，第一位是符号位，则1000 0000(-128) ~ 0111 1111(127)
short 2字节 -32768～32767
int 4字节 -2147483648～2147483647
long 8字节 -9223372036854775808 ~ 9223372036854775807(-2^31 ~ 2^31-1)
2种浮点类型:
float 4字节 -3.4E38～3.4E38
double 8字节 -1.7E308～1.7E308
1种用于表示Unicode编码的字符单元的字符类型:
char 2字节 从字符型对应的整型数来划分，其表示范围是0～65535
1种用于表示真值的boolean类型:
boolean 1 true或false
 * >>>   逻辑移位符，如：num>>>n 则表示向右移动n位，高位补0
 * >>    算数移位符，不同的是正数高位补0，负数高位补1
 * <<    移位符，像左移动n位，低位补0
 * 说明：！逻辑取反是把非零变为零，把零变为一。~表示按位取反，把1变为0，把0变为1.
 * 
 * 计算机中存储数的形式是二进制补码，其包括符号位与数值位，其中符号位为0表示正数，符号位为1表示负数。
 * 并且正数的原码、反码和补码都相同。而负数是符号位为1的二进制字符串，且：补码=原码取反+1（符号位不变）
 * 
 * 例如：3二进制表示0000 0011，若取反有1111 1100.由于第一位是1，将3取反后理解为一个负数的补码，
 * 反过来考虑，则该补码减去1为1111 1011再取反为0000 0100，其原码表示的是4，则说明该补码表示-4.
 * 更通用的，假设n是一个正数，那么~n=-(n+1).我们也可以从补码的定义去理解这个等式，原码n，取反为~n，加1为~n+1为补码，即表示-(n+1)
 * 相应的获取正数n的二进制串最后一个1:
 * ~(n-1)&n=-n&n
 * 去掉整数n的二进制串中最后一个1:
 * n&(n-1)
 * 
 * reference:
 * 位操作实现四则运算:	
 * https://www.cnblogs.com/ygj0930/p/6412875.html
 * 补码的意义？	为了用加法操作表示减法运算，减去一个正数相当于加上这个数的对应的补码。
 * https://www.cnblogs.com/myseries/p/5204878.html
 */