package homework.zhuyoufeng.test.arrays;

import homework.zhuyoufeng.test.arrays.beans.Poker;
import homework.zhuyoufeng.test.util.PokerUtil;

import java.util.Arrays;
import java.util.Scanner;


/**
 * �ҽ���Ϸ
 * @author zhuyoufeng
 *
 */
public class HitGoldenFlower2 {

	private int player1 = 1000;
	private int player2 = 1000;
	private int money1 = 0;
	private int money2 = 0;
	
	public int getValue(int[] poke) {
		int[] color = new int[3];
		int[] point = new int[3];
		int value = 0;
		
		color[0] = poke[0] / 100;
		color[1] = poke[1] / 100;
		color[2] = poke[2] / 100;
		
		point[0] = poke[0] % 100;
		point[1] = poke[1] % 100;
		point[2] = poke[2] % 100;
		
		//����
		Arrays.sort(point);
		
		//����
		value = cal(PokerUtil.DAN_ZHANG, point);
		
		//����
		if (point[0] == point[1]) {
			value = cal(PokerUtil.DUI_ZI, point);
		}
		if (point[1] == point[2]) {
			point[2] = point[0];
			point[0] = point[1];
			value = cal(PokerUtil.DUI_ZI, point);
		}
		if (point[0] == point[2]) {
			point[2] = point[1];
			point[1] = point[0];
			value = cal(PokerUtil.DUI_ZI, point);
		}
		
		//˳��
		if (point[0] + 1 == point[1] && point[1] + 1 == point[2]) {
			value = cal(PokerUtil.SHUN_ZI, point);
		}
		
		//ͬ��
		if (color[0] == color[1] && color[1] == color[2] && color[0] == color[2]) {
			value = cal(PokerUtil.TONG_HUA, point);
		}
		
		//ͬ��˳
		if (point[0] + 1 == point[1] && point[1] + 1 == point[2] &&
				color[0] == color[1] && color[1] == color[2] && color[0] == color[2]) {
			value = cal(PokerUtil.TONG_HUA_SHUN, point);
		}
		
		//����
		if (point[0] == point[1] && point[1] == point[2]) {
			value = cal(PokerUtil.SAN_TIAO, point);
		}
		
		return value;
	}
	
	private void checkSuccess(int[] playerPoker1, int[] playerPoker2) {
		if (this.getValue(playerPoker1) > this.getValue(playerPoker2)) {
			System.out.println("���1��ʤ��");
			player1 += money2;
			player2 -= money2;
		} else {
			System.out.println("���2��ʤ��");
			player1 -= money1;
			player2 += money1;
		}
	}

	private int cal(int head, int[] point) {
		int sum = 0;
		int j = 1;
		for (int i = 0; i < point.length; i++, j *= 10) {
			sum += point[i] * j;
		}
		sum += head *j ;
		return sum;
	}

	public void game() {
		Poker poker = new Poker();
		System.out.println("�ҽ�");
		System.out.println("ÿλ���ӵ��1000����Ϸ��!");
		while (true) {
			if (player1 > 0 && player2 > 0) {
				//��Ӷ�ע
				System.out.println("��˫����Ӷ�ע��");
				Scanner scanner = new Scanner(System.in);
				System.out.println("���1��");
				money1 = Integer.parseInt(scanner.next());
				System.out.println("���2��");
				money2 = Integer.parseInt(scanner.next());
				System.out.println("���ڷ��ƣ�");
				System.out.println("���1�Ķ�עΪ��" + money1);
				System.out.println("���2�Ķ�עΪ��" + money2);
				
				//����
				int[] poke = poker.licensing(6);
				int[] playerPoker1 = new int[3];
				int[] playerPoker2 = new int[3];
				System.arraycopy(poke, 0, playerPoker1, 0, 3);
				System.arraycopy(poke, 3, playerPoker2, 0, 3);
				System.out.println("������ϣ����ƣ�");
				System.out.println(poker.showPoke(playerPoker1));
				System.out.println(poker.showPoke(playerPoker2));				
				
				//�Ա��Ƶ����
				this.checkSuccess(playerPoker1, playerPoker2);
				System.out.println("���1����Ϸ��Ϊ��" + player1);
				System.out.println("���2����Ϸ��Ϊ��" + player2);
				System.out.println("������Ϸ�밴1���Ƴ��밴0��");
				int temp = Integer.parseInt(scanner.next());
				if (temp == 0) {
					System.out.println("лл��");
					break;
				} else {
					continue;
				}
			} else {
				System.out.println("һ�����㣬��Ϸ�Զ��Ƴ���");
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		new HitGoldenFlower2().game();
	}
	
}
