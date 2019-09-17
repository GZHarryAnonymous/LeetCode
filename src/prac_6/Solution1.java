package prac_6;

import qu_139.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//second
class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] mark = new int[s.length()+1];
        mark[0]=1;
        List<Integer>wordsLenDict=new ArrayList<Integer>();
        for(String per_word:wordDict){
            if(wordsLenDict.contains(per_word.length())==false){
                wordsLenDict.add(per_word.length());
            }
        }
        for (int l = 1; l <=s.length(); l++) {
            for(int w_len:wordsLenDict){
                int r=l-1+w_len;
                if (mark[l-1]==1&&r<=s.length()&&wordDict.contains(s.substring(l-1,r)))
                    mark[l-1+w_len] = 1;
            }
        }
        return mark[s.length()] == 1;
    }
    public static void main(String args[]){
        Solution1 solve = new Solution1();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String words = sc.nextLine();
        List<String> wordDict = new ArrayList<String>();
        //System.out.println(str);
        for(String word:words.split(" ")){
            wordDict.add(word);
        }
        //System.out.println(wordDict);
        boolean tag=solve.wordBreak(str,wordDict);
        if(tag){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
