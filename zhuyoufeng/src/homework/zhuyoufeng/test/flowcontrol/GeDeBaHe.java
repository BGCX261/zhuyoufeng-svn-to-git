package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * 验证歌德巴赫猜想: 
 * 对任何一个不小于6的偶数，
 * 总可以表示成两个奇素数的和
 * @author zhuyoufeng
 *
 */
public class GeDeBaHe {

	/**
	 * 验证是否为不小于6的偶数
	 */
	private boolean checkOuShu(int num) {
		if (num >= 6 && num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证是否为奇素数
	 */
	private boolean checkJiSuShu(int num) {
		boolean flag = false;
		if (num % 2 != 0) {
			for (int i=2; i<num; i++) {
				if (num % i == 0) {
					flag = true;
					break;
				}
			}
			if (flag) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public void checkNum(int num) {
		List<Integer> jsses = new ArrayList<Integer>();
		if (this.checkOuShu(num)) {
			for (int i=0; i<num; i++) {
				if (this.checkJiSuShu(i)) {
					jsses.add(i);
				}
			}
			for (int k=0; k<jsses.size()/2; k++) {
				int another = num - jsses.get(k);
				if (jsses.contains(another)) {
					System.out.println(num + "=" + jsses.get(k) + "+" + another);
				}
			}
		} else {
			System.out.println("请输入一个不小于6的偶数！");
		}
	}
	
	public void game() {
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("请输入一个不小于6的偶数,输入-1退出此题：");
				String str = scanner.next();
				int num = Integer.parseInt(str);
				if (num != -1) {
					new GeDeBaHe().checkNum(num);
				} else {
					break;
				}
			}			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("请输入一个不小于6的偶数！");
		}
	}
	
	public static void main(String[] args) {
		
	}

}
