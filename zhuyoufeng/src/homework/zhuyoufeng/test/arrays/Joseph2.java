package homework.zhuyoufeng.test.arrays;

import java.util.Arrays;


/**
 * 用数组实现约瑟夫出圈问题。 
 * n个人排成一圈，从第一个人开始报数，
 * 从1开始报，报到m的人出圈，
 * 剩下的人继续开始从1报数，直到所有的人都出圈为止。
 * 对于给定的n,m，求出所有人的出圈顺序。
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
	 * 出圈的顺序
	 * @param p 需要出圈的数组
	 * @param length 数组的长度
	 * @param start	首先报数的人，不是数组下标，代表第start个人开始
	 * @param call 报到哪个数出圈
	 */
	public void out(int p[], int length, int start, int call) {
		int index = (start - 2 + call) % length;
		System.out.print(p[index] + "出圈" + " ");
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
