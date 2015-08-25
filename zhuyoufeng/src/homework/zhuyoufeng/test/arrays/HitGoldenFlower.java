package homework.zhuyoufeng.test.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �ҽ���Ϸ
 * @author zhuyoufeng
 *
 */
public class HitGoldenFlower {

	private String[] spades;
	private String[] hearts;
	private String[] square;
	private String[] flowers;
	private String[][] poker;
	private int player1 = 1000;
	private int player2 = 1000;
	private int money1 = 0;
	private int money2 = 0;
	
	public HitGoldenFlower() {
		spades = new String[]{"AR", "2R", "3R", "4R", "5R", "6R", "7R", "8R", "9R", "0R", "JR", "QR", "KR"};
		hearts = new String[]{"AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "0H", "JH", "QH", "KH"};
		square = new String[]{"AF", "2F", "3F", "4F", "5F", "6F", "7F", "8F", "9F", "0F", "JF", "QF", "KF"};
		flowers = new String[]{"AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "0C", "JC", "QC", "KC"};
		poker = new String[4][];
		poker[0] = spades;
		poker[1] = hearts;
		poker[2] = square;
		poker[3] = flowers;
	}
	
	public int getRandNumber(int size) {
		return (int)(Math.random() * size);
	}
	
	/**
	 * ����
	 * @return
	 */
	public String[] licensing() {
		String[] poke = new String[3];
		for (int i = 0; i < poke.length; i++) {
			poke[i] = poker[this.getRandNumber(4)][this.getRandNumber(12)];
		}
		//��֤���Ƿ����ظ�
		start:for (int i = 0; i < poke.length; i++) {
			for (int j = 1; j < poke.length; j++) {
				if (poke[i].equals(poke[j])) {
					poke[j] = poker[this.getRandNumber(4)][this.getRandNumber(12)];
					continue start;
				}
			}
		}
		return poke;
	}
	
	//�ж��Ƿ���ͬ��
	public boolean sameFlower(String[] poke) {
		if (poke[0].charAt(1) == poke[1].charAt(1) && 
				poke[0].charAt(1) == poke[2].charAt(1) &&
				poke[1].charAt(1) == poke[2].charAt(1)) {
			return true;
		} else {
			return false;
		}
	}
	
	//�ж��Ƿ���˳��
	public boolean junko(String[] poke) {
		int num1 = Integer.parseInt(this.change1(String.valueOf(poke[0].charAt(0))));
		int num2 = Integer.parseInt(this.change1(String.valueOf(poke[1].charAt(0))));
		int num3 = Integer.parseInt(this.change1(String.valueOf(poke[2].charAt(0))));
		if (num1 + num2 == num3 || 
				num1 + num3 == num2 || 
				num3 + num2 == num1) {
			return true;
		} else {
			return false;
		}
	}
	
	//�ж��Ƿ���ͬ��˳
	public boolean sameFlowerAndJunko(String[] poke) {
		if (sameFlower(poke) && junko(poke)) {
			return true;
		} else {
			return false;
		}
	}
	
	//��������Ʊ�ɼ򵥵�����--����˳��
	private String change1(String c1) {
		if ("A".equals(c1)) {
			c1 = "1";
		} else if ("0".equals(c1)) {
			c1 = "10";
		} else if ("J".equals(c1)) {
			c1 = "11";
		} else if ("Q".equals(c1)) {
			c1 = "12";
		} else if ("K".equals(c1)) {
			c1 = "13";
		}
		return c1;
	}
	
	//��������Ʊ�ɼ򵥵�����--���ڵ���
	private String change2(String c1) {
		if ("A".equals(c1)) {
			c1 = "13";
		} else if ("0".equals(c1)) {
			c1 = "10";
		} else if ("J".equals(c1)) {
			c1 = "11";
		} else if ("Q".equals(c1)) {
			c1 = "12";
		} else if ("K".equals(c1)) {
			c1 = "13";
		}
		return c1;
	}
	
	//�ж��Ƿ�������
	public boolean triple(String[] poke) {
		if (poke[0].charAt(0) == poke[1].charAt(0) && 
				poke[0].charAt(0) == poke[2].charAt(0) &&
				poke[1].charAt(0) == poke[2].charAt(0)) {
			return true;
		} else {
			return false;
		}
	}
	
	//�ж��Ƿ��Ƕ���
	public boolean dobule(String[] poke) {
		if (poke[0].charAt(0) == poke[1].charAt(0) || 
				poke[0].charAt(0) == poke[2].charAt(0) ||
				poke[1].charAt(0) == poke[2].charAt(0)) {
			return true;
		} else {
			return false;
		}
	}
	
	//���űȽ�
	public void leaflets(String[] poke1, String[] poke2) {
		int num1[] = new int[3];
		int num2[] = new int[3];
		num1[0] = Integer.parseInt(this.change2(String.valueOf(poke1[0].charAt(0))));
		num1[1] = Integer.parseInt(this.change2(String.valueOf(poke1[1].charAt(0))));
		num1[2] = Integer.parseInt(this.change2(String.valueOf(poke1[2].charAt(0))));
		
		num2[0] = Integer.parseInt(this.change2(String.valueOf(poke2[0].charAt(0))));
		num2[1] = Integer.parseInt(this.change2(String.valueOf(poke2[1].charAt(0))));
		num2[2] = Integer.parseInt(this.change2(String.valueOf(poke2[2].charAt(0))));
		
		Arrays.sort(num1);
		Arrays.sort(num2);
		if (num1[2] > num2[2]) {
			//���1��ʤ
			this.addMoney(0);
			System.out.println("���1��ʤ");
		} else if (num1[2] < num2[2]) {
			//���2��ʤ
			this.addMoney(1);
			System.out.println("���2��ʤ");
		} else {
			if (num1[1] > num2[1]) {
				//���1��ʤ
				this.addMoney(0);
				System.out.println("���1��ʤ");
			} else if (num1[1] < num2[1]) {
				//���2��ʤ
				this.addMoney(1);
				System.out.println("���2��ʤ");
			} else {
				if (num1[0] > num2[0]) {
					//���1��ʤ
					this.addMoney(0);
					System.out.println("���1��ʤ");
				} else if (num1[0] < num2[0]) {
					//���2��ʤ
					this.addMoney(1);
					System.out.println("���2��ʤ");
				} else {
					//ͬ��
					this.addMoney(2);
					System.out.println("ׯ��Ӯ��ʤ��");
				}
			}
		}
	}
	
	public void addMoney(int type) {
		switch (type) {
		case 0:
			player1 += money2;
			player2 -= money2;
			break;
		case 1:
			player1 -= money1;
			player2 += money1;
			break;
		default:
			player1 -= money1;
			player2 -= money1;
			break;
		}
	}
	
	public void checkSuccess(String[] poke1, String[] poke2) {
		if (this.triple(poke1) && !this.triple(poke2)) {
			//���1��ʤ
			this.addMoney(0);
			System.out.println("���1��ʤ");
		} else if (!this.triple(poke1) && this.triple(poke2)) {
			//���2��ʤ
			this.addMoney(1);
			System.out.println("���2��ʤ");
		}
		if (!this.triple(poke1) && !this.triple(poke2)) {
			if (this.sameFlowerAndJunko(poke1) && !this.sameFlowerAndJunko(poke2)) {
				//���1��ʤ
				this.addMoney(0);
				System.out.println("���1��ʤ");
			} else if (!this.sameFlowerAndJunko(poke1) && this.sameFlowerAndJunko(poke2)) {
				//���2��ʤ
				this.addMoney(1);
				System.out.println("���2��ʤ");
			}
		}
		if (!this.triple(poke1) && !this.triple(poke2) && 
				!this.sameFlowerAndJunko(poke1) && !this.sameFlowerAndJunko(poke2)) {
			if (this.sameFlower(poke1) && !this.sameFlower(poke2)) {
				//���1��ʤ
				this.addMoney(0);
				System.out.println("���1��ʤ");
			} else if (!this.sameFlower(poke1) && this.sameFlower(poke2)) {
				//���2��ʤ
				this.addMoney(1);
				System.out.println("���2��ʤ");
			}
		}
		if (!this.triple(poke1) && !this.triple(poke2) && 
				!this.sameFlowerAndJunko(poke1) && !this.sameFlowerAndJunko(poke2) &&
				!this.sameFlower(poke1) && !this.sameFlower(poke2)) {
			if (this.junko(poke1) && !this.junko(poke2)) {
				//���1��ʤ
				this.addMoney(0);
				System.out.println("���1��ʤ");
			} else if (!this.junko(poke1) && this.junko(poke2)) {
				//���2��ʤ
				this.addMoney(1);
				System.out.println("���2��ʤ");
			}
		}
		if (!this.triple(poke1) && !this.triple(poke2) && 
				!this.sameFlowerAndJunko(poke1) && !this.sameFlowerAndJunko(poke2) &&
				!this.sameFlower(poke1) && !this.sameFlower(poke2) &&
				!this.junko(poke1) && !this.junko(poke2) ) {
			if (this.dobule(poke1) && !this.dobule(poke2)) {
				//���1��ʤ
				this.addMoney(0);
				System.out.println("���1��ʤ");
			} else if (!this.dobule(poke1) && this.dobule(poke2)) {
				//���2��ʤ
				this.addMoney(1);
				System.out.println("���2��ʤ");
			}
		}
		if (!this.triple(poke1) && !this.triple(poke2) && 
				!this.sameFlowerAndJunko(poke1) && !this.sameFlowerAndJunko(poke2) &&
				!this.sameFlower(poke1) && !this.sameFlower(poke2) &&
				!this.junko(poke1) && !this.junko(poke2) &&
				!this.dobule(poke1) && !this.dobule(poke2)) {
			this.leaflets(poke1, poke2);
		}
	}
	
	public void game() {
		System.out.println("�ҽ�");
		System.out.println("ÿλ���ӵ��1000����Ϸ��!");
		while (true) {
			if (player1 > 0 && player2 > 0) {
				System.out.println("��˫����Ӷ�ע��");
				Scanner scanner = new Scanner(System.in);
				System.out.println("���1��");
				money1 = Integer.parseInt(scanner.next());
				System.out.println("���2��");
				money2 = Integer.parseInt(scanner.next());
				System.out.println("���ڷ��ƣ�");
				System.out.println("���1�Ķ�עΪ��" + money1);
				System.out.println("���2�Ķ�עΪ��" + money2);
				String[] playerPoker1 = this.licensing();
				String[] playerPoker2 = this.licensing();
				System.out.println("������ϣ����ƣ�");
				System.out.println(Arrays.toString(playerPoker1));
				System.out.println(Arrays.toString(playerPoker2));
				this.checkSuccess(playerPoker1, playerPoker2);
				System.out.println("���1����Ϸ��Ϊ��" + player1);
				System.out.println("���2����Ϸ��Ϊ��" + player2);
				System.out.println("������Ϸ�밴1���Ƴ��밴0��");
				int temp = Integer.parseInt(scanner.next());
				if (temp == 0) {
					break;
				} else {
					continue;
				}
			} else {
				System.out.println("һ�����㣬��Ϸ�Զ��Ƴ���");
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new HitGoldenFlower().game();
	}
	
}
