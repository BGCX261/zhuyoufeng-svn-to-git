package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;


/**
 * 游戏运行时产生一个0－100之间的随机整数，
 * 要求用户从控制台输入数字，
 * 若输入的数字比产生的数字小，
 * 则输出：“太小了，再大一点！”；
 * 若输入的数字比产生的数字大，
 * 则输出：“太大了，再小一点！”，
 * 若输入的数字和产生的数字相等，
 * 则输出：“恭喜你猜对了！”，
 * 若用户猜了10次还未猜对，
 * 则输出：“你太笨了，下次再来吧！”
 * 然后退出程序。
 * @author zhuyoufeng
 *
 */
public class GuessNumber {

	private int randNum;
	private int timer;
	
	public GuessNumber() {
		randNum = (int)(Math.random() * 100 + 1);
		timer = 1;
	}
	
	public boolean guess(int num) {
		if (num > randNum) {
			System.out.println("太大了，再小一点！");
			return false;
		} else if (num < randNum) {
			System.out.println("太小了，再大一点！");
			return false;
		} else {
			System.out.println("恭喜你猜对了！");
			System.out.println("游戏结束！");
			return true;
		}
	}
	
	public boolean game() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("欢迎来到猜数字游戏世界！");
		System.out.println("请输入0-100之间的整数：");
		while(true) {
			String str = scanner.next();
			try {
				int n = Integer.parseInt(str);
				if (timer < 10) {
					if (this.guess(n)) {
						return true;
					}
					timer++;
				} else {
					System.out.println("你太笨了，下次再来吧！");
					return false;
				}
			} catch (NumberFormatException e) {
				System.out.println("请输入数字！");
				return false;
			}
		}
	}

	public static void main(String[] args) {
		GuessNumber guessNumber = new GuessNumber();
		guessNumber.game();
	}

}
