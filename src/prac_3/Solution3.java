package prac_3;

import java.util.Scanner;
class B{
    int test(int n,int[] s){
        for(int i=1;i<=n;i++){
            //if(s[0]>s[i]){
                //s[0]+=(s[0]-s[i]);
            //}else{
                //s[0]-=(s[i]-s[0]);
            //}
            s[0]=2*s[0]-s[i];
            if(s[0]<0)return -1;
        }
        return 1;
    }
}
public class Solution3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n+1];
        s[0] = 0;
        for(int i=1;i<=n;i++){
            s[i]=sc.nextInt();
        }
        B b = new B();
        int i=-1;
        do{
            i++;
            s[0]=i;
            b.test(n,s);
        }while(b.test(n,s)<0);
        System.out.println(i);
    }
}
