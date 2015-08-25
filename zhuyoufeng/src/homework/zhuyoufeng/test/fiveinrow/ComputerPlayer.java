package homework.zhuyoufeng.test.fiveinrow;

/**
 * 
 * @author zhuyoufeng
 *
 */
public class ComputerPlayer {

	private ChessBoard chessBoard;
	
	public ComputerPlayer() {}
	
	public ComputerPlayer(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	/**
	 * ���ŵ�һ������
	 */
	public void putFirstChess() {
		char[][] board = chessBoard.getBoard();
		int x = board.length/2;
		int y = board[x].length/2;
		if (chessBoard.hasChess(x, y)) {
			board[x][y] = '@';
		} else {
			board[x + 1][y] = '@';
		}
		chessBoard.printChessBoard();
	}
	
	public void putChess(int x, int y) {
		
	}
}
