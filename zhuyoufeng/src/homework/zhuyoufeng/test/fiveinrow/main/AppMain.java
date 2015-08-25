package homework.zhuyoufeng.test.fiveinrow.main;

import homework.zhuyoufeng.test.fiveinrow.ChessBoard;

public class AppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard(15, 15);
		chessBoard.printChessBoard();
//		ComputerPlayer computerPlayer = new ComputerPlayer(chessBoard);
//		computerPlayer.putChess();
	}

}
