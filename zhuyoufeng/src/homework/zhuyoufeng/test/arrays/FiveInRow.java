package homework.zhuyoufeng.test.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��������Ϸ
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
	 * ��ӡ����
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
	 * ��������
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
					System.out.println("�ڷ�ʤ����");
				} else {
					System.out.println("�׷�ʤ����");
				}
				System.exit(0);
			}
			return true;
		}
	}

	private boolean checkSuccess(int x, int y, char chess) {
		int timer = 0;
		//1�������ƶ�
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
		//2�������ƶ�
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
		
		//3���������ƶ�
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
		
		//4���������ƶ�
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
			System.out.println("������");
			this.printChessBoard();
			System.out.println("��Ϸ��ʽ��������Ҫ�������ӵ���Ӧλ��,�Կո���������磺a f");
			boolean flag = false;
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				if (flag) {
					flag = false;
					System.out.println("�ڷ���");
					if (!this.putChess(br.readLine(), 0)) {
						System.out.println("��λ���Ѱ������ӣ�������ѡ��");
						this.printChessBoard();
						flag = true;
						continue;
					}
					this.printChessBoard();
				} else {
					flag = true;
					System.out.println("�׷���");
					if (!this.putChess(br.readLine(), 1)) {
						System.out.println("��λ���Ѱ������ӣ�������ѡ��");
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
