package prac_6;

import java.math.BigInteger;
import java.util.Scanner;
//first
class Solution4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int b = sc.nextInt();
        int min=w,max=b;
        int h=0,c=0;
        BigInteger M=new BigInteger("1000000007");
        if(w>b){
            min=b;
            max=w;
        }
        int i=1;
        int t=0;
        for(;i<=100000;i++){
            if(min>i){
                min-=i;
            }else{
                t=i-1;
                break;
            }
        }
        for(;i<=100000;i++){
            if(max>i){
                max-=i;
            }else{
                break;
            }
        }
        h=--i;
        c=2^t%(10^9+7);

        System.out.println(h+" "+c);
    }
}
