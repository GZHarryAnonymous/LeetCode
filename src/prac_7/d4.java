package prac_7;
import java.util.Arrays;
import java.util.Scanner;
public class d4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] a = new int[N+1];
        a[0]=-1;
        int maxValue=Integer.MAX_VALUE;
        int best_index = 0;
        for(int i = 1;i<=N;i++){
            a[i]=sc.nextInt();
            if(Math.abs(N-a[i])<maxValue){
                best_index=i;
            }
        }
        int result = 1;
        for(int i=1;i<=N;i++){
            if(a[i]>1&&a[i]-1==best_index){
                result+=B;
                break;
            }
            if(a[i]<N&&a[i]+1==best_index){
                result+=C;
                break;
            }
            result+=A;
        }
        System.out.println(result);
    }
}
