package homework.zhuyoufeng.test.flowcontrol;

/**
 * ��д��0-100֮���ż���ĺ�
 * @author zhuyoufeng
 *
 */
public class Sum {

	/**
	 * forѭ��
	 */
	public void method1() {
		int sum = 0;
		for(int i=0; i<=100; i+=2){
			sum += i;
		}
		System.out.println("����1��1-100֮��ż���ĺ�Ϊ��" + sum);
	}
	
	/**
	 * whileѭ��
	 */
	public void method2() {
		int sum = 0;
		int i = 0;
		while(i<=100){
			if(i%2 == 0) {
				sum+=i;
			}
			i++;
		}
		System.out.println("����2��1-100֮��ż���ĺ�Ϊ��" + sum);
	}
	
	/**
	 * do-whileѭ��
	 */
	public void method3(){
		int sum = 0;
		int i = 0;
		do{
			if(i%2 == 0) {
				sum+=i;
			}
			i++;
		}while(i<=100);
		System.out.println("����3��1-100֮��ż���ĺ�Ϊ��" + sum);
	}
	
	public static void main(String[] args) {
		Sum sum = new Sum();
		sum.method1();
		sum.method2();
		sum.method3();
	}

}
