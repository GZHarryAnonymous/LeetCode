package qu_695;
// 1直接清零，表示访问过。
public class Solution4 {
	public int dfs(int[][] grid,int row,int column,int count){
		if(grid[row][column]==1){
			grid[row][column] = 0;
			count++;
			// 下右左上，性能较优。
			if(row<grid.length-1)count = dfs(grid,row+1,column,count);
			if(column<grid[0].length-1)count = dfs(grid,row,column+1,count);
			if(column>0 && grid[row][column-1] == 1)count = dfs(grid,row,column-1,count);
			if(row>0 && grid[row-1][column] == 1)count = dfs(grid,row-1,column,count);
		}
		return count;
	}
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null)return 0;
		int row = grid.length;
		int column = row == 0 ? 0 : grid[0].length;
		int result = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				if(grid[i][j]==1){
					result = Math.max(result,dfs(grid,i,j,0));
				}
			}
		}
		return result;
	}
	public static void main(String args[]) {
		Solution4 s = new Solution4();
		int[][] grid = {{1,0,1},{1,1,1}};
		int result=s.maxAreaOfIsland(grid) ;
		System.out.println(result);
	}
}

