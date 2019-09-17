package qu_695;
public class Solution3 {
	public int dfs(int i, int j, int[][] visit, int count) {
		if (i >= visit.length || j >= visit[0].length || i < 0 || j < 0 || visit[i][j] == 0)
			return count;
		visit[i][j] = 0;
		count++;
		count = dfs(i + 1, j, visit, count);
		count = dfs(i - 1, j, visit, count);
		count = dfs(i, j + 1, visit, count);
		count = dfs(i, j - 1, visit, count);
		return count;
	}
	public int maxAreaOfIsland(int[][] grid) {
			int max = 0;
			int m = grid.length;
			int n = m > 0 ? grid[0].length : 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 1) {
						max = Math.max(dfs(i, j, grid, 0), max);
					}
				}
			}
			return max;
		}
	public static void main(String args[]) {
		Solution3 s = new Solution3();
		int[][] grid = {{1,0,1},{1,1,1}};
		int result=s.maxAreaOfIsland(grid) ;
		System.out.println(result);
	}
}

