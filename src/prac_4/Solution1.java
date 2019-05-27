package prac_4;

import java.util.Scanner;

class Solution1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        System.out.println(n);
    }
}
