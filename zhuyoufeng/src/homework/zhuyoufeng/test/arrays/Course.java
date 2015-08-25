package homework.zhuyoufeng.test.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将所有学生的课程成绩保留在一个二维数组中，
 * 每一行代表一个学生的成绩，每一列代表一门课程的成绩；
 * 将每门课程的名称保留在一个一维数组中
 * （课程的下标序号与二维数组的列号匹配）；
 * 将每个学生的姓名保留在一个一维数组中（
 * 学生的下标序号与二维数组的行号匹配）；
 * 要求编写程序实现成绩的查询，
 * 要求程序运行时从命令行输入统计命令及参数，
 * 程序则输出结果，例如：
 * AVGCOU corejava：统计课程corejava的平均分。
 * AVGSTU 张三：统计学生张三的平均分。
 * SORT sum：列出每个学生所有课程总分的排名。
 * SORT corejava：列出corejava课程的成绩的排名。
 * GET 张三 sum：统计学生张三的总分。
 * GET 张三 corejava：统计张三的corejava课程的成绩。
 * 
 * @author zhuyoufeng
 *
 */
public class Course {

	private String[] courists;
	private String[] students;
	private int[][] result;
	
	public static final String AVGCOU = "AVGCOU";
	public static final String AVGSTU = "AVGSTU";
	public static final String SORT = "SORT";
	public static final String GET = "GET";
	
	public Course() {
		courists = new String[]{"Java", "JDBC", "Servlet", "Struts", "Spring", "Hibernate"};
		students = new String[]{"Aakarshan", "Aaron", "Abbott", "Abdel", "Abdiel"};
		result = new int[][]{
				{80, 70, 60, 70, 65, 95}, 
				{75, 85, 65, 55, 95, 58}, 
				{68, 78, 95, 35, 42, 59}, 
				{86, 95, 74, 47, 38, 83}, 
				{99, 76, 97, 79, 28, 61}
				};
	}
	
	/**
	 * 统计课程的平均分
	 */
	public void avgCourse(String course) {
		int index = Arrays.binarySearch(courists, course);
		int sum = 0;
		for (int i=0;i<result.length; i++) {
			sum += result[i][index];
		}
		System.out.println("课程" + course + "的平均分为：" + sum + "/" + result.length + "=" + sum/result.length);
	}
	
	/**
	 * 统计学生的平均分
	 */
	public void avgStu(String student) {
		int index = Arrays.binarySearch(students, student);
		int sum = 0;
		for (int i=0;i<result[index].length; i++) {
			sum += result[index][i];
		}
		System.out.println("学生" + student + "的平均分为：" + sum + "/" + courists.length + "="  + sum/courists.length);
	}
	
	/**
	 * 列出每个学生所有课程总分的排名
	 */
	public void sortSum() {
		Object[][] obj = new Object[result.length][2];
		for (int i=0; i<result.length; i++) {
			obj[i][0] = students[i];
			obj[i][1] = 0;
			for (int j=0; j<result[i].length; j++) {
				obj[i][1] = (Integer)obj[i][1] + result[i][j];
			}
		}
		this.paiXu(obj);
	}
	
	/**
	 * 列出课程的成绩的排名。
	 */
	public void sortCourse(String course) {
		int index = Arrays.binarySearch(courists, course);
		Object[][] obj = new Object[result.length][2];
		for (int i=0; i<result.length; i++) {
			obj[i][0] = students[i];
			obj[i][1] = result[i][index];
		}
		this.paiXu(obj);
	}
	
	/**
	 * 对于成绩进行排序,从大到小
	 * @param objs
	 */
	public void paiXu(Object[][] objs) {
		int temp = 0;
		String tmempName = "";
		for (int i = 0; i < objs.length; i++) {
			for (int j = 0; j < objs.length - i - 1; j++) {
				if(((Integer)objs[j][1]) < ((Integer)objs[j + 1][1])){
					temp = (Integer)objs[j][1];
					objs[j][1] = objs[j+1][1];
					objs[j+1][1] = temp;
					
					tmempName = (String)objs[j][0];
					objs[j][0] = objs[j+1][0];
					objs[j+1][0] = tmempName;
				}
			}
		}
		int mc = 1;
		for (int i = 0; i < objs.length; i++) {
			System.out.println("第" + mc + "名为：" + objs[i][0] + ", 成绩为：" + objs[i][1]);
			if (i+1 < objs.length && (Integer)objs[i][1] - (Integer)objs[i+1][1] != 0) {
				mc++;
			}
		}
	}
	
	public void get(String student, String type) {
		int index = Arrays.binarySearch(students, student);
		if ("sum".equalsIgnoreCase(type.trim())) {
			int sum = 0;
			for (int i = 0; i < result[index].length; i++) {
				sum += result[index][i];
			}
			System.out.println("学生" + student + "的总成绩为：" + sum);
		} else {
			int indexCourse = Arrays.binarySearch(courists, type);
			System.out.println("学生" + student + "的" + type + "成绩为：" + result[index][indexCourse]);
		}
	}
	
	public void game() {
		System.out.println("成绩表");
		System.out.println("课程包括：" + Arrays.toString(courists));
		System.out.println("学生包括：" + Arrays.toString(students));
		System.out.println("例如：");
		System.out.println("AVGCOU corejava：统计课程corejava的平均分。");
		System.out.println("AVGSTU 张三：统计学生张三的平均分。。");
		System.out.println("SORT sum：列出每个学生所有课程总分的排名。");
		System.out.println("SORT corejava：列出corejava课程的成绩的排名。");
		System.out.println("GET 张三 sum：统计学生张三的总分。");
		System.out.println("GET 张三 corejava：统计张三的corejava课程的成绩。");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("请输入相应的操作(AVGCOU/AVGSTU/SORT/GET/EXIT)：");
			String str = scanner.next();
			if ("AVGCOU".equalsIgnoreCase(str)) {
				System.out.println("请输入课程名称：");
				String s = scanner.next();
				this.avgCourse(s);
			} else if ("AVGSTU".equalsIgnoreCase(str)) {
				System.out.println("请输入学生名称：");
				String s = scanner.next();
				this.avgStu(s);
			} else if ("SORT".equalsIgnoreCase(str)) {
				System.out.println("请输入课程名称（输入sum代表列出所有课程总分的排名）：");
				String s = scanner.next();
				if ("sum".equalsIgnoreCase(s)) {
					this.sortSum();
				} else {
					this.sortCourse(s);
				}
			} else if ("GET".equalsIgnoreCase(str)) {
				System.out.println("请输入学生名称：");
				String s = scanner.next();
				System.out.println("请输入课程名称（输入sum代表列出该学生所有课程总分）：");
				String t = scanner.next();
				this.get(s, t);
			} else if ("exit".equalsIgnoreCase(str)) {
				break;
			} 
		}
	}
	
	public static void main(String[] args) {
		new Course().game();
	}
}
