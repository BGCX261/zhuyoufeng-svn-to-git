package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;

/**
 * 
 * ��д���򣬽�һ���������Ź���
 * @author zhuyoufeng
 *
 */
public class Invert {

	private void doInvert(String num) {
		try {
			Integer.parseInt(num);
			System.out.println("�����������Ϊ��" + num);
			StringBuilder newStr = new StringBuilder();
			char[] c = num.toCharArray();
			for (int i=c.length-1; i >= 0; i--) {
				newStr.append(c[i]);
			}
			int newNum = Integer.parseInt(newStr.toString());
			System.out.println("���������Ϊ��" + newNum);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("���������֣�");
		}
	}
	
	public void game() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ�����֣�");
		doInvert(scanner.next());
	}

}
