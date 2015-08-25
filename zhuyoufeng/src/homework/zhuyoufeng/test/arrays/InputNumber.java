package homework.zhuyoufeng.test.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 从键盘输入十个整数，升序输出
 * @author zhuyoufeng
 *
 */
public class InputNumber {

	public void game() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入10个数字，以回车隔开:");
		int num[] = new int[10];
		for (int i=0; i<10; i++) {
			String str = scanner.next();
			int n = Integer.parseInt(str);
			num[i] = n;
		}
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		
	}
	
	public static void main(String[] args) {
		new InputNumber().game();
	}

}
