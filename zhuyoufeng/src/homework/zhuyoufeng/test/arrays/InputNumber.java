package homework.zhuyoufeng.test.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �Ӽ�������ʮ���������������
 * @author zhuyoufeng
 *
 */
public class InputNumber {

	public void game() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������10�����֣��Իس�����:");
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
