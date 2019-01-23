package qu_36;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<9;i++) {
			if(panRow(board,i)&&panCol(board,i)) {
				if(i%3==0) {
					for(int j=0;j<9;j+=3) {
						if(!panTable(board,i,j))return false;
					}
				}
			}else {
				return false;
			}
		}
        return true;
    }
	private boolean panRow(char[][] board,int row) {
		boolean[] tag=new boolean[9];
		int index;
		for(int i=0;i<9;i++) {
			if(".".equals(""+board[row][i]))continue;
			index=Integer.parseInt(String.valueOf(board[row][i]))-1;
			if(tag[index]==false) {
				tag[index]=true;
			}else {
				return false;
			}
		}
		return true;
	}
	private boolean panCol(char[][] board,int col) {
		boolean[] tag=new boolean[9];
		int index;
		for(int i=0;i<9;i++) {
			if(".".equals(""+board[i][col]))continue;
			index=Integer.parseInt(String.valueOf(board[i][col]))-1;
			if(tag[index]==false) {
				tag[index]=true;
			}else {
				return false;
			}
		}
		return true;
	}
	private boolean panTable(char[][] board,int row,int col) {
		boolean[] tag=new boolean[9];
		int index,row_max=row+3,col_max=col+3;
		for(int i=row;i<row_max;i++) {
			for(int j=col;j<col_max;j++) {
				if(".".equals(""+board[i][j]))continue;
				index=Integer.parseInt(String.valueOf(board[i][j]))-1;
				if(tag[index]==false) {
					tag[index]=true;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		char[][] board=new char[9][9];
		int result=0;
		System.out.println(result);
	}
}
