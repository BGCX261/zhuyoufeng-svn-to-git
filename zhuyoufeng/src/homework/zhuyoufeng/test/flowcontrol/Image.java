package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;

/**
 * 在屏幕上打印出n行的金字塔图案
 * @author zhuyoufeng
 *
 */
public class Image {

	private void draw(int n) {
		for (int i=1; i<=n; i++) {
			for (int j=n-i; j>=0; j--) {
				System.out.print(" ");
			}
			for (int k=1; k<=(i * 2 - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public boolean game() {
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("请输入您要画的金字塔的高度,输入-1退出此题：");
				String str = scanner.next();
				int num = Integer.parseInt(str);
				if (num != -1) {
					this.draw(num);
				} else {
					break;
				}
			}
			return true;
		} catch (NumberFormatException e) {
			System.out.println("请输入一个合法的成绩！");
			return false;
		}
	}
	
	public static void main(String[] args) {
	}

}
