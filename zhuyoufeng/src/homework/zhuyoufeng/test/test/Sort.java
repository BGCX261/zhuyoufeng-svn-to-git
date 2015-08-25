package homework.zhuyoufeng.test.test;

import java.util.Arrays;

/**
 * Java≈≈–Ú
 * @author zhuyoufeng
 * 
 */
public class Sort {

	/**
	 * √∞≈›≈≈–Ú
	 * 
	 * @param array
	 */
	public void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * —°‘Ò≈≈–Ú
	 * 
	 * @param array
	 */
	public void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int s = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[s] > array[j]) {
					s = j;
				}
			}
			if (s != i) {
				int temp = array[i];
				array[i] = array[s];
				array[s] = temp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n[] = new int[] { 2, 5, 8, 3, 6, 4, 5, 15 };
//		new Sort().bubbleSort(n);
		new Sort().selectSort(n);
		System.out.println(Arrays.toString(n));
	}

}
