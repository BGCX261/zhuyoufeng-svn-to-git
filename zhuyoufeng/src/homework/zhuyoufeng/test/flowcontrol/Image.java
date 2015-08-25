package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;

/**
 * ����Ļ�ϴ�ӡ��n�еĽ�����ͼ��
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
				System.out.println("��������Ҫ���Ľ������ĸ߶�,����-1�˳����⣺");
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
			System.out.println("������һ���Ϸ��ĳɼ���");
			return false;
		}
	}
	
	public static void main(String[] args) {
	}

}
