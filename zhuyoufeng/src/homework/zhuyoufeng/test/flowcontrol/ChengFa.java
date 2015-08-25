package homework.zhuyoufeng.test.flowcontrol;

/**
 * ³Ë·¨¿Ú¾÷±í
 * @author zhuyoufeng
 *
 */
public class ChengFa{
	
	public void draw() {
		for (int i=1,j=1; i<=9;) {
			System.out.print(i + " * " + j + " = " + i * j + " ");
			if (i == j) {
				j = 1;
				i++;
				System.out.println();
			} else {
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		new ChengFa().draw();
	}
	
}