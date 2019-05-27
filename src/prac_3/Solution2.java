package prac_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class A{
    int[] analysis_content(String key){
        int[] result = new int[3];
        int i = 0;
        for(String s:key.split("/*")){
            result[i] = Integer.parseInt(s);
            i++;
        }
        return result;
    }
    int cal_feature(Scanner sc){
        Map<String,Integer> map = new HashMap<>();
        //Scanner sc = new Scanner(System.in);
        int count_frame = sc.nextInt();
        for(int i=0;i<count_frame;i++){
            int feature_count_per_frame = sc.nextInt();
            for(int ii=0;ii<feature_count_per_frame;ii++){
                int first_num = sc.nextInt();
                int second_num = sc.nextInt();
                int next_frame = i+1;
                String put_key = ""+next_frame + "*" + first_num + "*" + second_num;
                String cur_key = ""+i+"*"+first_num+"*"+second_num;
                if(map.containsKey(cur_key)){
                    //int[] result = analysis_content(cur_key);
                    int value = map.get(cur_key);
                    map.put(put_key,value+1);
                }else{
                    //int value = 1;
                    map.put(put_key,1);
                }

            }
        }
        int result = 0;
        for(int v:map.values()){
            if(v>result)result = v;
        }
        return result;
    }
}
public class Solution2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n_test = sc.nextInt();
        int[] result = new int[n_test];
        //System.out.println(n_test);
        A a = new A();
        for(int i=0;i<n_test;i++){
            result[i]=a.cal_feature(sc);
            System.out.println(result[i]);
        }
    }
}
