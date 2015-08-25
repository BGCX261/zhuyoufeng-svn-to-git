package homework.zhuyoufeng.test.fiveinrow;

public class ChessBoard {

	//纵坐标
	private int x;
	//横坐标
	private int y;
	//坐标轴
	private char[] hengzuobiao;
	private char[] zongzuobiao;
	private char[][] board;
	
	public ChessBoard() {}
	
	public ChessBoard(int x, int y) {
		this.x = x;
		this.y = y;
		hengzuobiao = new char[y];
		zongzuobiao = new char[x];
		board = new char[x][y];
		for (int i = 0; i < x; i++) {
			zongzuobiao[i] = (char)(97 + i);
		}
		
		for (int i = 0; i < y; i++) {
			hengzuobiao[i] = (char)(97 + i);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = '*';
			}
		}
	}
	
	public void printChessBoard() {
		System.out.print("   ");
		for (int i = 0; i < y; i++) {
			System.out.print(hengzuobiao[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			System.out.print(zongzuobiao[i] + "  ");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 判断该位置有没有棋子
	 * @param x
	 * @param y
	 * @return true 没有棋子  false 有棋子
	 */
	public boolean hasChess(int x, int y) {
		if (board[x][y] != '@' && board[x][y] != 'O') {
			return true;
		} else {
			return false;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

}
