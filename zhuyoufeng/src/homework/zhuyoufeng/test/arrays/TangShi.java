package homework.zhuyoufeng.test.arrays;

/**
 * �ö�ά�ַ����鱣��һ����ʫ�����Ի����ԣ���
 * ÿһ�д���һ�䣬Ҫ��������ʫ���չ��ĵķ�ʽ�������
 * @author zhuyoufeng
 *
 */
public class TangShi {

	public void game() {
//		String tangshi1 = "���˾�����";
//		String tangshi2 = "������ü";
//		String tangshi3 = "�������ʪ";
//		String tangshi4 = "��֪�ĺ�˭";
		
		String tangshi1 = "��ɽ�±���ͤ����ˮ���ƽ�ƽŵ͡�";
		String tangshi2 = "������ݺ��ů����˭�������Ĵ��ࡣ";
		String tangshi3 = "�һ����������ۣ�ǳ�ݲ���û���㡣";
		String tangshi4 = "������в��㣬���������ɳ�̡�";
		
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
