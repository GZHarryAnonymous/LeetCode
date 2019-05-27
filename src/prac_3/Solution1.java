package prac_3;

import java.util.Scanner;
import java.util.Vector;

class Solution1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v = new Vector<Integer>();
        int row = 1;
        int col = 0;
        String s=null;
        Scanner scan = new Scanner(System.in);
        //while(scan.hasNextLine()){//可以一直输入
            //String out = scan.nextLine();
            //System.out.println(out);
        //}
        do{
            s=sc.nextLine();
            if(s.length()==0)break;
            System.out.println(s);
            for(String value:s.split(" ")){
               if(row==1)col++;
               System.out.println(value.getClass());
               System.out.println(value instanceof String);
               System.out.println("length"+value.length());
               String tmp = value.trim();
               int num = Integer.parseInt(tmp);
               System.out.println(num);
               v.add(num);
           }
           row++;
        }while (s.length()!=0);//sc.hasNextLine()
        row++;
        System.out.println("row"+row);
        System.out.println("col"+col);
        System.out.println(v.capacity());
    }
}
