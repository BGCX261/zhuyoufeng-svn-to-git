package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;


/**
 * ��Ϸ����ʱ����һ��0��100֮������������
 * Ҫ���û��ӿ���̨�������֣�
 * ����������ֱȲ���������С��
 * ���������̫С�ˣ��ٴ�һ�㣡����
 * ����������ֱȲ��������ִ�
 * ���������̫���ˣ���Сһ�㣡����
 * ����������ֺͲ�����������ȣ�
 * �����������ϲ��¶��ˣ�����
 * ���û�����10�λ�δ�¶ԣ�
 * �����������̫���ˣ��´������ɣ���
 * Ȼ���˳�����
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
			System.out.println("̫���ˣ���Сһ�㣡");
			return false;
		} else if (num < randNum) {
			System.out.println("̫С�ˣ��ٴ�һ�㣡");
			return false;
		} else {
			System.out.println("��ϲ��¶��ˣ�");
			System.out.println("��Ϸ������");
			return true;
		}
	}
	
	public boolean game() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ӭ������������Ϸ���磡");
		System.out.println("������0-100֮���������");
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
					System.out.println("��̫���ˣ��´������ɣ�");
					return false;
				}
			} catch (NumberFormatException e) {
				System.out.println("���������֣�");
				return false;
			}
		}
	}

	public static void main(String[] args) {
		GuessNumber guessNumber = new GuessNumber();
		guessNumber.game();
	}

}
