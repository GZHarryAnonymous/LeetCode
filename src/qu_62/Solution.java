package qu_62;
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1)return 1;
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
    public static void main(String args[]){
        Solution solve = new Solution();
        int result = solve.uniquePaths(7,3);
        System.out.println(result);
    }
}
