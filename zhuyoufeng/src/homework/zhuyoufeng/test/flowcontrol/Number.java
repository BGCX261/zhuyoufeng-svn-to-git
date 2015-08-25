package homework.zhuyoufeng.test.flowcontrol;

/**
 * 1 1 2 3 5 8 13 21 34 55 ...
 * @author zhuyoufeng
 *
 */
public class Number{
	
	public void getSum(int n) {
		int sum = 0;
		System.out.print(1 + " ");
		for (int i=1, j=1;i<n; j=i, i=sum) {
			sum = i + j;
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
	}
	
}