package qu_64;
// ��ά���飬����С·�������ϵ����£��ɱ���
public class Solution {
	public int minPathSum(int[][] grid) {
		// �����������
		int row_number = grid.length;
		if(row_number==0)return 0;
		int column_number = grid[0].length;
		if(column_number==0)return 0;
		int dp[][] = new int[row_number][column_number];
		// ���ϸ�ֵ
		dp[0][0]=grid[0][0];
		// ���һ�и�ֵ
		for(int i=1;i<row_number;i++){
			dp[i][0]=grid[i][0]+dp[i-1][0];
		}
		// �ϵ�һ�и�ֵ
		for(int j=1;j<column_number;j++){
			dp[0][j]=grid[0][j]+dp[0][j-1];
		}
		// ״̬ת�Ʒ������
		for(int i=1;i<row_number;i++){
			for(int j=1;j<column_number;j++){
				dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
			}
		}
		return dp[row_number-1][column_number-1];
	}
	public static void main(String args[]) {
		Solution solve = new Solution();
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int result=solve.minPathSum(grid);
		System.out.println(result);
	}
}

