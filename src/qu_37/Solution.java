package qu_37;

public class Solution {
	    int[][] hCounts;
	    int[][] vCounts;
	    int[][][] sqCounts;
	    public void solveSudoku(char[][] board) {
	    	//数据结构+算法=程序，此处数据结构很关键。
	        hCounts = new int[9][9];//9行
	        vCounts = new int[9][9];//9列
	        sqCounts = new int[3][3][9];//3*3个九宫格
	        for (int row=0;row<9;row++) {
	            for (int col=0;col<9;col++) if (board[row][col] != '.') set(board, row, col, board[row][col]);
	        }
	        solve(board, 0, 0);
	    }
	    //算法采用递归的思想！模拟一步一步往下走。
	    private boolean solve(char[][] board, int row, int col) {//处理row行col列
	        if (row == board.length) return true;//最后一行处理完结束
	        if (col == board[0].length) return solve(board, row+1, 0);//当前行处理完转为下一行继续
	        if (board[row][col] != '.') return solve(board, row, col+1);//当前行为数字则下一个继续
	        //前三行是从左往右，从上往下，一行一行的走，知道出现第一个为空的'.'，则进行如下判断：
	        for (int i=1;i<10;i++) {
	            char n = (char)('0' + i);//1-9一个一个尝试
	            if (canAdd(row, col, n)) {//如果当前数字n可以添加
	                set(board, row, col, n);//则添加
	                if (solve(board, row, col+1)) return true;//如果以当前为n继续可以成功（已知解唯一），则解决！
	                unset(board, row, col, n);//否则清空，继续尝试其他数字。
	            }
	        }
	        return false;//整个求解过程是一个递归的过程。
	    }
	    private boolean canAdd(int row, int col, char c) {//行，列，九宫格都没有出现过才可以增加。
	        int n = c-'0'-1;
	        return hCounts[row][n] == 0 && vCounts[col][n] == 0 && sqCounts[row/3][col/3][n] == 0;
	    }
	    private void set(char[][] board, int row, int col, char c) {//设置字符c
	        board[row][col] = c;
	        int n = c-'0'-1;
	        hCounts[row][n]++;//每一行有9个数
	        vCounts[col][n]++;//每一列有9个数
	        sqCounts[row/3][col/3][n]++;//每个9宫格有9个数，除法限定位于哪一个九宫格很巧妙！
	    }
	    private void unset(char[][] board, int row, int col, char c) {//清空当前字符c
	        board[row][col] = '.';
	        int n = c-'0'-1;
	        hCounts[row][n]--;
	        vCounts[col][n]--;
	        sqCounts[row/3][col/3][n]--;
	    }
	public static void main(String args[]) {
		Solution s = new Solution();
		int result=0;
		System.out.println(result);
	}
}
