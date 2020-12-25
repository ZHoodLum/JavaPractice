package basal.LoopStructure;
/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:主要是使用一下JAVA的循环结构
 * abcd 设置为a-b c-d
 */

public class FormatUn {

	public static void main(String[] args) {
		System.out.print("第1种方法：");
		testString1();

		System.out.print("第2种方法：");
		testString2();

		System.out.print("第3种方法：");
		testString3();

		System.out.print("第4种方法：");
		testString4();

		System.out.print("第5种方法：");
		testString5();
	}

	/**
	 * 第1种方法
	 */
	public static void testString1 () {
		for (int i = 0; i < 7; i++) {
			if (i == 0) {
				System.out.print("a");
			}
			if (i == 1) {
				System.out.print("-");
			}
			if (i == 2) {
				System.out.print("b");
			}
			if (i == 3) {
				System.out.print(" ");
			}
			if (i == 4) {
				System.out.print("c");
			}
			if (i == 5) {
				System.out.print("-");
			}
			if (i == 6) {
				System.out.println("d");
			}
		}
	}

	/**
	 * 第2种方法
	 */
	public static void testString2 () {
		String str = "a,b,c,d";
		String[] strings = str.split(",");
		String newString = strings[0] + "-" + strings[1] + " " + strings[2] + "-" + strings[3];
		System.out.println( newString);
	}

	/**
	 * 第3种方法
	 */
	public static void testString3 () {
		int x = 3;
		while ( x > 0) {
			if (x > 2 ) {
				System.out.print("a");
			}
			if (x == 2 ) {
				System.out.print("b c");
			}
			x = x - 1;
			System.out.print("-");
			if (x == 1 ) {
				System.out.println("d");
				x = x- 1;
			}
		}
	}

	/**
	 * 第4种方法
	 * 循环次数控制在两次  保证-号输出
	 */
	public static void testString4 () {
		int x = 3;
		while ( x > 0) {
			if (x == 3 ) {
				System.out.print("a");
			}
			if (x == 2 ) {
				System.out.print("b c");
				x = x - 1;
			}
			System.out.print("-");
			if (x == 1 ) {
				System.out.println("d");
			}
			x--;
		}
	}

	/**
	 * 第5种方法
	 * 循环次数控制在两次  保证-号输出
	 */
	public static void testString5 () {
		int x = 3;
		do {
			if (x == 3 ) {
				System.out.print("a");
			}
			if (x == 2 ) {
				System.out.print("b c");
				x = x - 1;
			}
			System.out.print("-");
			if (x == 1 ) {
				System.out.println("d");
			}
			x--;
		} while (x > 0);
	}

}
