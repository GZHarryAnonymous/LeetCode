package qu_695;
public class Solution2 {
	public int dfs(int[][] grid,int row,int column,boolean[][] dp){
		int result=0;
		if(grid[row][column]==1 && !dp[row][column]){
			dp[row][column] = true;
			result = 1;
			// 下右左上，性能较优。
			if(row<grid.length-1)result += dfs(grid,row+1,column,dp);
			if(column<grid[0].length-1)result += dfs(grid,row,column+1,dp);
			if(column>0 && grid[row][column-1] == 1)result += dfs(grid,row,column-1,dp);
			if(row>0 && grid[row-1][column] == 1)result += dfs(grid,row-1,column,dp);
		}
		return result;
	}
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null)return 0;
		if(grid.length == 0)return 0;
		if(grid[0].length == 0)return 0;
		boolean[][] dp = new boolean[grid.length][grid[0].length];
		int result = 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				result = Math.max(result,dfs(grid,i,j,dp));
			}
		}
		return result;
	}
	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[][] grid = {{1,0,1},{1,1,1}};
		int result=s.maxAreaOfIsland(grid) ;
		System.out.println(result);
	}
}

