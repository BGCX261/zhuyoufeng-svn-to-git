package homework.zhuyoufeng.test.flowcontrol;

import java.util.Scanner;

/**
 * 输入学员的考试成绩，输出这学员考试成绩的级别。
 * 100      A级
 * 90~100   A级
 * 80~89    B级
 * 70~79    C级
 * 60~69    D级
 * < 60     不合格
 * @author zhuyoufeng
 *
 */
public class Goal{
	
	public void getGrade(float g) {
		if (g >= 90 && g <= 100) {
			System.out.println("A级");
		} else if (g >= 80 && g <= 89) {
			System.out.println("B级");
		} else if (g >= 70 && g <= 79) {
			System.out.println("C级");
		}  else if (g >= 60 && g <= 69) {
			System.out.println("D级");
		}  else if (g < 60) {
			System.out.println("不合格");
		} else {
			System.out.println("您输入的成绩不合法！");
		}
	}
	
	public void game() {
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("请输入一个成绩,输入-1退出此题：");
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
			System.out.println("请输入一个合法的成绩！");
		}
	}
	
	public static void main(String[] args) {
		
	}
}