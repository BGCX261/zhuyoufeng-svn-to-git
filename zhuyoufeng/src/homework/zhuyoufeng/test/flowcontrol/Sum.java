package homework.zhuyoufeng.test.flowcontrol;

/**
 * 编写从0-100之间的偶数的和
 * @author zhuyoufeng
 *
 */
public class Sum {

	/**
	 * for循环
	 */
	public void method1() {
		int sum = 0;
		for(int i=0; i<=100; i+=2){
			sum += i;
		}
		System.out.println("方法1：1-100之间偶数的和为：" + sum);
	}
	
	/**
	 * while循环
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
		System.out.println("方法2：1-100之间偶数的和为：" + sum);
	}
	
	/**
	 * do-while循环
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
		System.out.println("方法3：1-100之间偶数的和为：" + sum);
	}
	
	public static void main(String[] args) {
		Sum sum = new Sum();
		sum.method1();
		sum.method2();
		sum.method3();
	}

}
