package qu_37;

public class Solution {
	    int[][] hCounts;
	    int[][] vCounts;
	    int[][][] sqCounts;
	    public void solveSudoku(char[][] board) {
	    	//���ݽṹ+�㷨=���򣬴˴����ݽṹ�ܹؼ���
	        hCounts = new int[9][9];//9��
	        vCounts = new int[9][9];//9��
	        sqCounts = new int[3][3][9];//3*3���Ź���
	        for (int row=0;row<9;row++) {
	            for (int col=0;col<9;col++) if (board[row][col] != '.') set(board, row, col, board[row][col]);
	        }
	        solve(board, 0, 0);
	    }
	    //�㷨���õݹ��˼�룡ģ��һ��һ�������ߡ�
	    private boolean solve(char[][] board, int row, int col) {//����row��col��
	        if (row == board.length) return true;//���һ�д��������
	        if (col == board[0].length) return solve(board, row+1, 0);//��ǰ�д�����תΪ��һ�м���
	        if (board[row][col] != '.') return solve(board, row, col+1);//��ǰ��Ϊ��������һ������
	        //ǰ�����Ǵ������ң��������£�һ��һ�е��ߣ�֪�����ֵ�һ��Ϊ�յ�'.'������������жϣ�
	        for (int i=1;i<10;i++) {
	            char n = (char)('0' + i);//1-9һ��һ������
	            if (canAdd(row, col, n)) {//�����ǰ����n�������
	                set(board, row, col, n);//�����
	                if (solve(board, row, col+1)) return true;//����Ե�ǰΪn�������Գɹ�����֪��Ψһ����������
	                unset(board, row, col, n);//������գ����������������֡�
	            }
	        }
	        return false;//������������һ���ݹ�Ĺ��̡�
	    }
	    private boolean canAdd(int row, int col, char c) {//�У��У��Ź���û�г��ֹ��ſ������ӡ�
	        int n = c-'0'-1;
	        return hCounts[row][n] == 0 && vCounts[col][n] == 0 && sqCounts[row/3][col/3][n] == 0;
	    }
	    private void set(char[][] board, int row, int col, char c) {//�����ַ�c
	        board[row][col] = c;
	        int n = c-'0'-1;
	        hCounts[row][n]++;//ÿһ����9����
	        vCounts[col][n]++;//ÿһ����9����
	        sqCounts[row/3][col/3][n]++;//ÿ��9������9�����������޶�λ����һ���Ź�������
	    }
	    private void unset(char[][] board, int row, int col, char c) {//��յ�ǰ�ַ�c
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
