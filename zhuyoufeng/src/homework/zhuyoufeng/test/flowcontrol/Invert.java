package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;

/**
 * 
 * 编写程序，将一个整数倒排过来
 * @author zhuyoufeng
 *
 */
public class Invert {

	private void doInvert(String num) {
		try {
			Integer.parseInt(num);
			System.out.println("您输入的数字为：" + num);
			StringBuilder newStr = new StringBuilder();
			char[] c = num.toCharArray();
			for (int i=c.length-1; i >= 0; i--) {
				newStr.append(c[i]);
			}
			int newNum = Integer.parseInt(newStr.toString());
			System.out.println("倒序的数字为：" + newNum);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("请输入数字！");
		}
	}
	
	public void game() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数字：");
		doInvert(scanner.next());
	}

}
