package prac_6;

import java.util.Scanner;
//third
class Solution2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] s = new int[N];
        for(int i=0;i<N;i++){
            s[i]=sc.nextInt();
        }
        String c="",pre_c="";
        int n1=0,n2,n3,n4,n5;
        for(int i=0;i<N-1;i++){
            int a1=sc.nextInt();
            int a2=sc.nextInt();
            c=sc.next();
            if(c.equals(pre_c)){
                n1+=a2;
            }
            pre_c=c;
        }
        int[] q = new int[N];
        for(int i=0;i<Q;i++){
            q[i]=sc.nextInt();
            System.out.println(q[i]);
        }
    }
}
