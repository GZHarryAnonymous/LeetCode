package prac_2;

public class test {
    public static void main(String[] args){
        System.out.println(-1>>1);
        System.out.println(-1>>1==Integer.MAX_VALUE);
        System.out.println(5/2==2.5);
        System.out.println(0.1*6==0.6);
        System.out.println(Integer.MAX_VALUE-Integer.MIN_VALUE==-1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("a"+"b"=="ab");
        System.out.println("ab"==new String("ab"));
        System.out.println(("a"+"b").intern()=="ab".intern());
        System.out.println("ab"==new String("ab").intern());

        String a="";
        System.out.println(a.hashCode());
        String b=a;
        a+="b";
        System.out.println(a.hashCode());
        System.out.print(a==b);


    }
}
