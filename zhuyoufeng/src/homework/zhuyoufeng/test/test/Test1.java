package homework.zhuyoufeng.test.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = new String[4];
		for (int i=0; i<4; i++) {
			strs[i] = scanner.next();
		}
		char[][] ts = new char[4][];
		for (int i=0; i<ts.length; i++) {
			ts[i] = strs[i].toCharArray();
		}
		System.out.println(Arrays.deepToString(ts));
	}

}
