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
	 * �ж�Ȧ�����Ƿ�����
	 * @return  true û���� 
	 * 			flase ������
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
