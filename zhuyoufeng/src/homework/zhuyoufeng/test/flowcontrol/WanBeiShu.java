package homework.zhuyoufeng.test.flowcontrol;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ��500���ڵ��걸��
 * @author zhuyoufeng
 *
 */
public class WanBeiShu {

	/**
	 * ���һ������Լ��
	 * @param num
	 */
	private List<Integer> getYueShu(int num) {
		List<Integer> yueShu = new ArrayList<Integer>();
		for (int i=1; i<num; i++) {
			if (num%i==0) {
				yueShu.add(i);
			}
		}
		return yueShu;
	}
	
	public int checkNum(int num) {
		List<Integer> yueShu = this.getYueShu(num);
		int sum = 0;
		for (Integer i : yueShu) {
			sum += i;
		}
		if (sum == num) {
			return num;
		} else {
			return 0;
		}
	}
	
	public void game() {
		WanBeiShu wBeiShu = new WanBeiShu();
		List<Integer> wanBeiShuList = new ArrayList<Integer>();
		for (int i=0; i<500; i++) {
			int num = wBeiShu.checkNum(i);
			if (num != 0) {
				wanBeiShuList.add(num);
			}
		}
		System.out.println("500���ڵ��걶���У�");
		for (Integer i : wanBeiShuList) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
	}

}
