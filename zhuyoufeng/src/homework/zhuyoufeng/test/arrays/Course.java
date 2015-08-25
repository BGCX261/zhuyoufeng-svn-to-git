package homework.zhuyoufeng.test.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ������ѧ���Ŀγ̳ɼ�������һ����ά�����У�
 * ÿһ�д���һ��ѧ���ĳɼ���ÿһ�д���һ�ſγ̵ĳɼ���
 * ��ÿ�ſγ̵����Ʊ�����һ��һά������
 * ���γ̵��±�������ά������к�ƥ�䣩��
 * ��ÿ��ѧ��������������һ��һά�����У�
 * ѧ�����±�������ά������к�ƥ�䣩��
 * Ҫ���д����ʵ�ֳɼ��Ĳ�ѯ��
 * Ҫ���������ʱ������������ͳ�����������
 * �����������������磺
 * AVGCOU corejava��ͳ�ƿγ�corejava��ƽ���֡�
 * AVGSTU ������ͳ��ѧ��������ƽ���֡�
 * SORT sum���г�ÿ��ѧ�����пγ��ֵܷ�������
 * SORT corejava���г�corejava�γ̵ĳɼ���������
 * GET ���� sum��ͳ��ѧ���������ܷ֡�
 * GET ���� corejava��ͳ��������corejava�γ̵ĳɼ���
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
	 * ͳ�ƿγ̵�ƽ����
	 */
	public void avgCourse(String course) {
		int index = Arrays.binarySearch(courists, course);
		int sum = 0;
		for (int i=0;i<result.length; i++) {
			sum += result[i][index];
		}
		System.out.println("�γ�" + course + "��ƽ����Ϊ��" + sum + "/" + result.length + "=" + sum/result.length);
	}
	
	/**
	 * ͳ��ѧ����ƽ����
	 */
	public void avgStu(String student) {
		int index = Arrays.binarySearch(students, student);
		int sum = 0;
		for (int i=0;i<result[index].length; i++) {
			sum += result[index][i];
		}
		System.out.println("ѧ��" + student + "��ƽ����Ϊ��" + sum + "/" + courists.length + "="  + sum/courists.length);
	}
	
	/**
	 * �г�ÿ��ѧ�����пγ��ֵܷ�����
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
	 * �г��γ̵ĳɼ���������
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
	 * ���ڳɼ���������,�Ӵ�С
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
			System.out.println("��" + mc + "��Ϊ��" + objs[i][0] + ", �ɼ�Ϊ��" + objs[i][1]);
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
			System.out.println("ѧ��" + student + "���ܳɼ�Ϊ��" + sum);
		} else {
			int indexCourse = Arrays.binarySearch(courists, type);
			System.out.println("ѧ��" + student + "��" + type + "�ɼ�Ϊ��" + result[index][indexCourse]);
		}
	}
	
	public void game() {
		System.out.println("�ɼ���");
		System.out.println("�γ̰�����" + Arrays.toString(courists));
		System.out.println("ѧ��������" + Arrays.toString(students));
		System.out.println("���磺");
		System.out.println("AVGCOU corejava��ͳ�ƿγ�corejava��ƽ���֡�");
		System.out.println("AVGSTU ������ͳ��ѧ��������ƽ���֡���");
		System.out.println("SORT sum���г�ÿ��ѧ�����пγ��ֵܷ�������");
		System.out.println("SORT corejava���г�corejava�γ̵ĳɼ���������");
		System.out.println("GET ���� sum��ͳ��ѧ���������ܷ֡�");
		System.out.println("GET ���� corejava��ͳ��������corejava�γ̵ĳɼ���");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("��������Ӧ�Ĳ���(AVGCOU/AVGSTU/SORT/GET/EXIT)��");
			String str = scanner.next();
			if ("AVGCOU".equalsIgnoreCase(str)) {
				System.out.println("������γ����ƣ�");
				String s = scanner.next();
				this.avgCourse(s);
			} else if ("AVGSTU".equalsIgnoreCase(str)) {
				System.out.println("������ѧ�����ƣ�");
				String s = scanner.next();
				this.avgStu(s);
			} else if ("SORT".equalsIgnoreCase(str)) {
				System.out.println("������γ����ƣ�����sum�����г����пγ��ֵܷ���������");
				String s = scanner.next();
				if ("sum".equalsIgnoreCase(s)) {
					this.sortSum();
				} else {
					this.sortCourse(s);
				}
			} else if ("GET".equalsIgnoreCase(str)) {
				System.out.println("������ѧ�����ƣ�");
				String s = scanner.next();
				System.out.println("������γ����ƣ�����sum�����г���ѧ�����пγ��ܷ֣���");
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
