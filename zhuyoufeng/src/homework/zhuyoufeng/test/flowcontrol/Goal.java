package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;

/**
 * ����ѧԱ�Ŀ��Գɼ��������ѧԱ���Գɼ��ļ���
 * 100      A��
 * 90~100   A��
 * 80~89    B��
 * 70~79    C��
 * 60~69    D��
 * < 60     ���ϸ�
 * @author zhuyoufeng
 *
 */
public class Goal{
	
	public void getGrade(float g) {
		if (g >= 90 && g <= 100) {
			System.out.println("A��");
		} else if (g >= 80 && g <= 89) {
			System.out.println("B��");
		} else if (g >= 70 && g <= 79) {
			System.out.println("C��");
		}  else if (g >= 60 && g <= 69) {
			System.out.println("D��");
		}  else if (g < 60) {
			System.out.println("���ϸ�");
		} else {
			System.out.println("������ĳɼ����Ϸ���");
		}
	}
	
	public void game() {
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("������һ���ɼ�,����-1�˳����⣺");
				String str = scanner.next();
				float num = Float.valueOf(str);
				if (num != -1) {
					new Goal().getGrade(num);
				} else {
					break;
				}
			}			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("������һ���Ϸ��ĳɼ���");
		}
	}
	
	public static void main(String[] args) {
		
	}
}