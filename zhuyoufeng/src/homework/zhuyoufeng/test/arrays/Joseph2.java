package homework.zhuyoufeng.test.arrays;

import java.util.Arrays;


/**
 * ������ʵ��Լɪ���Ȧ���⡣ 
 * n�����ų�һȦ���ӵ�һ���˿�ʼ������
 * ��1��ʼ��������m���˳�Ȧ��
 * ʣ�µ��˼�����ʼ��1������ֱ�����е��˶���ȦΪֹ��
 * ���ڸ�����n,m����������˵ĳ�Ȧ˳��
 * @author zhuyoufeng
 *
 */
public class Joseph2 {
	
	private int[] persons;
	
	public Joseph2 () {
		persons = new int[8];
		for (int i=0; i < 8;i++) {
			persons[i] = i + 1;
		}
	}
	
	/**
	 * ��Ȧ��˳��
	 * @param p ��Ҫ��Ȧ������
	 * @param length ����ĳ���
	 * @param start	���ȱ������ˣ����������±꣬�����start���˿�ʼ
	 * @param call �����ĸ�����Ȧ
	 */
	public void out(int p[], int length, int start, int call) {
		int index = (start - 2 + call) % length;
		System.out.print(p[index] + "��Ȧ" + " ");
		for (int i = index + 1; i < p.length; i++) {
			p[i-1] = p[i];
		}
		if (length > 1) {
			out(p, length-1, index + 1, call);
		}
	}
	
	public void game() {
		System.out.println(Arrays.toString(persons));
		out(persons, persons.length, 1, 3);
	}
	
	public static void main(String[] args) {
		new Joseph2().game();
	}
}
