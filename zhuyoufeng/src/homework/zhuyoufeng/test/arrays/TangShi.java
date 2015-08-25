package homework.zhuyoufeng.test.arrays;

/**
 * 用二维字符数组保存一首唐诗（五言或七言），
 * 每一行代表一句，要求将这首唐诗按照古文的方式输出出来
 * @author zhuyoufeng
 *
 */
public class TangShi {

	public void game() {
//		String tangshi1 = "美人卷珠帘";
//		String tangshi2 = "深坐颦蛾眉";
//		String tangshi3 = "但见泪痕湿";
//		String tangshi4 = "不知心恨谁";
		
		String tangshi1 = "孤山寺北贾亭西，水面初平云脚低。";
		String tangshi2 = "几处早莺争暖树，谁家新燕啄春泥。";
		String tangshi3 = "乱花渐欲迷人眼，浅草才能没马蹄。";
		String tangshi4 = "最爱湖东行不足，绿杨阴里白沙堤。";
		
		char[][] tangshi = new char[4][];
		tangshi[0] = tangshi1.toCharArray();
		tangshi[1] = tangshi2.toCharArray();
		tangshi[2] = tangshi3.toCharArray();
		tangshi[3] = tangshi4.toCharArray();
		int len = tangshi.length-1;
		for (int j=0; j < tangshi[len].length; j++) {
			for (int i=tangshi.length-1; i >= 0; i--) {
				System.out.print(tangshi[i][j]);
			}
			if (len > 0) {
				len--;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new TangShi().game();
	}

}
