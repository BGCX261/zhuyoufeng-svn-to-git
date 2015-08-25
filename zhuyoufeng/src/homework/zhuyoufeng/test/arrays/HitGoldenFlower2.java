package homework.zhuyoufeng.test.arrays;

import homework.zhuyoufeng.test.arrays.beans.Poker;
import homework.zhuyoufeng.test.util.PokerUtil;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 砸金花游戏
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
		
		//排序
		Arrays.sort(point);
		
		//单张
		value = cal(PokerUtil.DAN_ZHANG, point);
		
		//对子
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
		
		//顺子
		if (point[0] + 1 == point[1] && point[1] + 1 == point[2]) {
			value = cal(PokerUtil.SHUN_ZI, point);
		}
		
		//同花
		if (color[0] == color[1] && color[1] == color[2] && color[0] == color[2]) {
			value = cal(PokerUtil.TONG_HUA, point);
		}
		
		//同花顺
		if (point[0] + 1 == point[1] && point[1] + 1 == point[2] &&
				color[0] == color[1] && color[1] == color[2] && color[0] == color[2]) {
			value = cal(PokerUtil.TONG_HUA_SHUN, point);
		}
		
		//三条
		if (point[0] == point[1] && point[1] == point[2]) {
			value = cal(PokerUtil.SAN_TIAO, point);
		}
		
		return value;
	}
	
	private void checkSuccess(int[] playerPoker1, int[] playerPoker2) {
		if (this.getValue(playerPoker1) > this.getValue(playerPoker2)) {
			System.out.println("玩家1获胜！");
			player1 += money2;
			player2 -= money2;
		} else {
			System.out.println("玩家2获胜！");
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
		System.out.println("砸金花");
		System.out.println("每位玩家拥有1000个游戏币!");
		while (true) {
			if (player1 > 0 && player2 > 0) {
				//添加赌注
				System.out.println("请双方添加赌注：");
				Scanner scanner = new Scanner(System.in);
				System.out.println("玩家1：");
				money1 = Integer.parseInt(scanner.next());
				System.out.println("玩家2：");
				money2 = Integer.parseInt(scanner.next());
				System.out.println("现在发牌！");
				System.out.println("玩家1的赌注为：" + money1);
				System.out.println("玩家2的赌注为：" + money2);
				
				//发牌
				int[] poke = poker.licensing(6);
				int[] playerPoker1 = new int[3];
				int[] playerPoker2 = new int[3];
				System.arraycopy(poke, 0, playerPoker1, 0, 3);
				System.arraycopy(poke, 3, playerPoker2, 0, 3);
				System.out.println("发牌完毕！开牌：");
				System.out.println(poker.showPoke(playerPoker1));
				System.out.println(poker.showPoke(playerPoker2));				
				
				//对比牌的情况
				this.checkSuccess(playerPoker1, playerPoker2);
				System.out.println("玩家1的游戏币为：" + player1);
				System.out.println("玩家2的游戏币为：" + player2);
				System.out.println("继续游戏请按1，推出请按0！");
				int temp = Integer.parseInt(scanner.next());
				if (temp == 0) {
					System.out.println("谢谢！");
					break;
				} else {
					continue;
				}
			} else {
				System.out.println("一方金额不足，游戏自动推出！");
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		new HitGoldenFlower2().game();
	}
	
}
