package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * ��֤��°ͺղ���: 
 * ���κ�һ����С��6��ż����
 * �ܿ��Ա�ʾ�������������ĺ�
 * @author zhuyoufeng
 *
 */
public class GeDeBaHe {

	/**
	 * ��֤�Ƿ�Ϊ��С��6��ż��
	 */
	private boolean checkOuShu(int num) {
		if (num >= 6 && num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��֤�Ƿ�Ϊ������
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
			System.out.println("������һ����С��6��ż����");
		}
	}
	
	public void game() {
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("������һ����С��6��ż��,����-1�˳����⣺");
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
			System.out.println("������һ����С��6��ż����");
		}
	}
	
	public static void main(String[] args) {
		
	}

}
