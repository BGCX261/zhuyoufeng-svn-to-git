package homework.zhuyoufeng.test.arrays.main;

import homework.zhuyoufeng.test.arrays.Course;
import homework.zhuyoufeng.test.arrays.FiveInRow;
import homework.zhuyoufeng.test.arrays.HitGoldenFlower;
import homework.zhuyoufeng.test.arrays.InputNumber;
import homework.zhuyoufeng.test.arrays.Joseph;
import homework.zhuyoufeng.test.arrays.NineSpace;
import homework.zhuyoufeng.test.arrays.TangShi;

import java.util.Scanner;

/**
 * �����½ڵ�������
 * @author zhuyoufeng
 *
 */
public class AppMain {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Home work");
			System.out.println("1��	�Ӽ�������ʮ���������������");
			System.out.println("2���ö�ά�ַ����鱣��һ����ʫ�����Ի����ԣ���ÿһ�д���һ�䣬Ҫ��������ʫ���չ��ĵķ�ʽ�������");
			System.out.println("3���ſո�");
			System.out.println("4��������ʵ��Լɪ���Ȧ����");
			System.out.println("5����ѧ���ĳɼ�");
			System.out.println("6��������");
			System.out.println("7���ҽ�");
			while (true) {
				System.out.println("��������Ӧ����Ŀ���⣬����-1�˳�����");
				String str = scanner.next();
				int num = Integer.parseInt(str);
				if (num != -1) {
					switch (num) {
					case 1: 
						new InputNumber().game();
						break;
					case 2: 
						new TangShi().game();
						break;
					case 3: 
						new NineSpace().game();
						break;
					case 4: 
						new Joseph().game();
						break;
					case 5: 
						new Course().game();
						break;
					case 6: 
						new FiveInRow().game();
						break;
					case 7: 
						new HitGoldenFlower().game();
						break;
					default : 
						System.out.println("���������Ų��Ϸ���");
						break;
					}
				} else {
					System.out.println("��ʾ������ף����죡");
					break;
				}
			}			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("���������Ų��Ϸ���");
		}
	}

}
