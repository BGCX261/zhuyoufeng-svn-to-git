package homework.zhuyoufeng.test.flowcontrol;

/**
 * Çó3.1415926...=(1-1/3+1/5-1/7+1/9¡£¡£¡£)*4
 * @author zhuyoufeng
 *
 */
public class PI {

	public float getPI(int n) {
		float sum = 1.0f;
		float chushu = 1.0f;
		StringBuilder sb = new StringBuilder("(1");
		for (int i=3; i<n; i+=2) {
			chushu *= -1;
			sum += chushu / i;
			if (chushu < 0) {
				sb.append((int)chushu + "/" + i);
			} else {
				sb.append("+" + (int)chushu + "/" + i);
			}
		}
		sb.append(")*4");
		System.out.println(sb.toString());
		return sum * 4;
	}
	
	public void game() {
		System.out.println(getPI(1000));
	}
	
	public static void main(String[] args) {
		new PI().game();
	}

}
