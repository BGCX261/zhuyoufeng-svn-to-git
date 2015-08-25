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
public class Joseph {

	private int n = 7;
	private int call = 3;
	private int[] persons;
	private int[] another;
	
	public Joseph () {
		persons = new int[n];
		another = new int[n];
		for (int i=0; i<n;i++) {
			persons[i] = 0;
		}
	}
	
	/**
	 * 判断圈里面是否还有人
	 * @return  true 没有人 
	 * 			flase 还有人
	 */
	public boolean hasSomeoneInCircle() {
		for (int i=0; i<n;i++) {
			if (persons[i] != call) {
				return false;
			}
		}
		return true;
	}
	
	public void game() {
		int i = 0;
		int j = 1;
		int k = 0;
		boolean flag = false;
		do {
			flag = this.hasSomeoneInCircle();
			if (i >= persons.length) {
				i = 0;
			}
			if (j > call) {
				j = 1;
			}
			if (persons[i] != call) {
				if (j == call) {
					another[k++] = i + 1;
				}
				persons[i++] = j++;
			} else {
				i++;
			}
		} while (!flag);
		System.out.println(Arrays.toString(another));
	}
	
	
	public static void main(String[] args) {
		new Joseph().game();
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}

	public int getCall() {
		return call;
	}

	public void setCall(int call) {
		this.call = call;
	}

}
