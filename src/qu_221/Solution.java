package qu_221;

import java.util.Scanner;
import java.util.Vector;

class A{

}
public class Solution {
    void print_matrix(int[][] dp){
        int len = dp[0].length;
        //System.out.println(len);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<len;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String row_per = null;
        Vector<Vector<Integer>> vector_2D = new Vector<Vector<Integer>>();
        while(sc.hasNextLine()){
            row_per = sc.nextLine();
            if(row_per.length()==0){
                //System.out.println("break");
                break;
            }
            //System.out.println();
            Vector<Integer> v = new Vector<>();
            for(String element:row_per.split(" ")){
                int ele = Integer.parseInt(element.trim());
                v.add(ele);
                //System.out.print(ele+" ");
            }
            vector_2D.add(v);
        }
        //System.out.println(vector_2D.get(0).get(0));
        //System.out.println(vector_2D.size());//size()是当下所拥有的元素
        //vector_2D.capacity();//是目前被分配的空间大小
        int row_len = vector_2D.size();
        if(row_len==0)System.out.println(0);
        int col_len = vector_2D.get(0).size();
        if(col_len==0)System.out.println(0);
        int[][] dp = new int[row_len][col_len];
        for(int i=0;i<row_len;i++){
            dp[i][0]=vector_2D.get(i).get(0);
        }
        for(int j=0;j<col_len;j++){
            dp[0][j]=vector_2D.get(0).get(j);
        }
        int result = 0;
        Solution solve = new Solution();
        for(int i=1;i<row_len;i++){
            //solve.print_matrix(dp);
            //System.out.println();
            for(int j=1;j<col_len;j++){
                if(vector_2D.get(i).get(j)==1){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>result)result=dp[i][j];
            }
        }
        System.out.println(result*result);
    }
}
