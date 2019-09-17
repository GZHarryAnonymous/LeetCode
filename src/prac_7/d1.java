package prac_7;

import java.util.Scanner;

// 1-n count the number of 1.
public class d1 {
    // method_1 transform into char for compare and calculate.
    // O(nlogn)
    public static int count_method_one(int n){
        if(n<1)return 0;
        int count = 0;
        for(int i=1;i<=n;i++){
            char[] a = String.valueOf(i).toCharArray();
            //System.out.println(a);
            for(char j:a){
                if(j == '1'){
                    count++;
                }
            }
        }
        return count;
    }
    // https://www.cnblogs.com/smile233/p/8338361.html
    // 若weight为0，则1出现次数为round*base
    // 若weight为1，则1出现次数为round*base+former+1
    // 若weight大于1，则1出现次数为rount*base+base
    // o(logn)
    public static int count_method_two(int n){
        if(n<1)return 0;
        int count = 0;
        int round = n;
        int base = 1;
        while (round>0){
            int weight = round%10;
            round/=10;
            count += round*base;
            if(weight==1){
                count += ((n%base)+1);//int former = 0;
            }else if(weight>1){
                count += base;
            }
            base *= 10;
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = count_method_one(n);
        System.out.println(result);
        int result2 = count_method_two(n);
        System.out.println(result2);
    }
}
