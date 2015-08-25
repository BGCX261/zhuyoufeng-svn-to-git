package homework.zhuyoufeng.test.arrays;

/**
 * ¾Å¿Õ¸ñ
 * @author zhuyoufeng
 *
 */
public class NineSpace {

	public static final int N = 5;
	private int[][] space = new int[N][N];
	
	private int checkNum(int num) {
		if (num==-1) {
			num = space.length-1;
		}
		if (num == N) {
			num = 0;
		}
		return num;
	}
	
	public void game() {
		for (int i = space.length/2, j = 0, k = 1; k<=N*N; ) {
			i = this.checkNum(i);
			j = this.checkNum(j);
			if (space[j][i] != 0) {
				i = this.checkNum(--i);
				j = this.checkNum(++j);
				space[++j][i] = k++;
				j--;
				i++;
			} else {
				space[j--][i++] = k++;
			}
		}
		for (int i=0; i<space.length; i++) {
			for (int j=0; j<space[i].length; j++) {
				System.out.print(space[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new NineSpace().game();
	}

}
