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
 * 数组章节的主函数
 * @author zhuyoufeng
 *
 */
public class AppMain {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Home work");
			System.out.println("1、	从键盘输入十个整数，升序输出");
			System.out.println("2、用二维字符数组保存一首唐诗（五言或七言），每一行代表一句，要求将这首唐诗按照古文的方式输出出来");
			System.out.println("3、九空格；");
			System.out.println("4、用数组实现约瑟夫出圈问题");
			System.out.println("5、求学生的成绩");
			System.out.println("6、五子棋");
			System.out.println("7、砸金花");
			while (true) {
				System.out.println("请输入相应的题目标题，输入-1退出程序：");
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
						System.out.println("您输入的序号不合法！");
						break;
					}
				} else {
					System.out.println("演示结束，祝您愉快！");
					break;
				}
			}			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("您输入的序号不合法！");
		}
	}

}
