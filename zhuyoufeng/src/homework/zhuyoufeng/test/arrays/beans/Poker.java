package homework.zhuyoufeng.test.arrays.beans;

import java.util.Random;

public class Poker {

	private int color;
	private int point;

	/**
	 * ����
	 * @param n ��Ҫ��������
	 * @return ���õ���
	 */
	public int[] licensing(int n) {
		int poke[] = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			poke[i] = (random.nextInt(4) + 1) * 100 + (random.nextInt(13) + 2);
		}
		loop:for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (poke[i] == poke[j]) {
					poke[j] = (random.nextInt(4) + 1) * 100 + (random.nextInt(13) + 2);
					continue loop;
				}
			}
		}
		return poke;
	}
	
	/**
	 * ��ʾ�Ƶ�����
	 * @param poke ��Ҫ��ʾ��
	 * @return �Ƶ�����
	 */
	public String showPoke(int[] poke) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < poke.length; i++) {
//			System.out.println(poke[i]);
			sb.append(this.showPokeColor(poke[i]/100));
			sb.append(" ");
			sb.append(this.showPokePoint(poke[i]%100));
			if (i+1<poke.length) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	private String showPokeColor(int num) {
		switch (num) {
		case 1:
			return "����";
		case 2:
			return "����";
		case 3:
			return "����";
		default:
			return "�ݻ�";
		}
	}
	
	private String showPokePoint(int num) {
		switch (num) {
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		case 14:
			return "A";
		default:
			return String.valueOf(num);	
		}
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
