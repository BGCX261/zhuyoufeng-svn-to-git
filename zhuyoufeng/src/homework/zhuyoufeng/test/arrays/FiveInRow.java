package homework.zhuyoufeng.test.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 五子棋游戏
 * 
 * @author zhuyoufeng
 * 
 */
public class FiveInRow {

	public static final int N = 17;

	private char[][] chessBoard;

	public FiveInRow() {
		chessBoard = new char[N][N];
		int c1 = 97;
		int c2 = 97;
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				if (i == 0 && j != 0) {
					chessBoard[i][j] = (char) c1++;
				} else if (j == 0 && i != 0) {
					chessBoard[i][j] = (char) c2++;
				} else if (j == 0 && i == 0) {
					chessBoard[i][j] = ' ';
				} else {
					chessBoard[i][j] = '*';
				}
			}
		}
	}

	/**
	 * 打印棋盘
	 */
	private void printChessBoard() {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				System.out.print(chessBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 安放棋子
	 * @param place
	 * @param type
	 * @return
	 */
	public boolean putChess(String place, int type) {
		char chess = ' ';
		switch (type) {
		case 0:
			chess = '@';
			break;

		default:
			chess = 'O';
			break;
		}
		String[] places = place.split(" ");
		if (chessBoard[places[0].charAt(0) - 96][places[1].charAt(0) - 96] == '@' ||
				chessBoard[places[0].charAt(0) - 96][places[1].charAt(0) - 96] == 'O') {
			return false;
		} else {
			chessBoard[places[0].charAt(0) - 96][places[1].charAt(0) - 96] = chess;
			if (this.checkSuccess(places[0].charAt(0) - 96, places[1].charAt(0) - 96, chess)) {
				this.printChessBoard();
				if (chess == '@') {
					System.out.println("黑方胜利！");
				} else {
					System.out.println("白方胜利！");
				}
				System.exit(0);
			}
			return true;
		}
	}

	private boolean checkSuccess(int x, int y, char chess) {
		int timer = 0;
		//1、向左移动
		while (x >= 0 && chessBoard[x][y] == chess) {
			x--;
		}
		while (x < N-1 && chessBoard[++x][y] == chess) {
			timer++;
		}
		if (timer >= 5) {
			return true;
		} else {
			timer = 0;
			x--;
		}
		//2、向下移动
		while (y >= 0 && chessBoard[x][y] == chess) {
			y--;
		}
		while (y < N-1 && chessBoard[x][++y] == chess) {
			timer++;
		}
		if (timer >= 5) {
			return true;
		} else {
			timer = 0;
			y--;
		}
		
		//3、向右上移动
		while ( x >= 0 && y < N-1 && chessBoard[x][y] == chess) {
			x--;
			y++;
		}
		while (x < N-1 && y >= 0 && chessBoard[++x][--y] == chess) {
			timer++;
		}
		if (timer >= 5) {
			return true;
		} else {
			timer = 0;
			x--;
			y++;
		}
		
		//4、向左下移动
		while (x < N-1 && y < N-1 && chessBoard[x][y] == chess) {
			x++;
			y++;
		}
		while (x >= 0 && y >= 0 && chessBoard[--x][--y] == chess) {
			timer++;
		}
		if (timer >= 5) {
			return true;
		} else {
			return false;
		}
	}

	public void game() {
		try {
			System.out.println("五子棋");
			this.printChessBoard();
			System.out.println("游戏方式：输入您要安放棋子的相应位置,以空格隔开，例如：a f");
			boolean flag = false;
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				if (flag) {
					flag = false;
					System.out.println("黑方：");
					if (!this.putChess(br.readLine(), 0)) {
						System.out.println("该位置已安放棋子！请重新选择！");
						this.printChessBoard();
						flag = true;
						continue;
					}
					this.printChessBoard();
				} else {
					flag = true;
					System.out.println("白方：");
					if (!this.putChess(br.readLine(), 1)) {
						System.out.println("该位置已安放棋子！请重新选择！");
						this.printChessBoard();
						flag = false;
						continue;
					}
					this.printChessBoard();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FiveInRow().game();
	}

}
