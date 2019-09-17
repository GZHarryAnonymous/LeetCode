package qu_695;

public class Solution {
	public int dfs_right_bottom(int[][] grid,int row_index,int column_index,boolean[][] dp){
		int result=0;
		if(row_index<grid.length && column_index<grid[0].length && grid[row_index][column_index]==1 && !dp[row_index][column_index]){
			dp[row_index][column_index]=true;
			result = 1+dfs_right_bottom(grid,row_index,column_index+1,dp)+dfs_right_bottom(grid,row_index+1,column_index,dp);
			if(column_index>0 && grid[row_index][column_index-1] == 1)result+=dfs_right_bottom(grid,row_index,column_index-1,dp);
			if(row_index>0 && grid[row_index-1][column_index] == 1)result+=dfs_right_bottom(grid,row_index-1,column_index,dp);
			return result;
		}
		return 0;
	}
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null)return 0;
		int row = grid.length;
		if(row == 0)return 0;
		int column = grid[0].length;
		if(column == 0)return 0;
		boolean[][] dp = new boolean[row][column];
		int result = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				result = Math.max(result,dfs_right_bottom(grid,i,j,dp));
			}
		}
		return result;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[][] grid = {{1,0,1},{1,1,1}};
		int result=s.maxAreaOfIsland(grid) ;
		System.out.println(result);
	}
}

