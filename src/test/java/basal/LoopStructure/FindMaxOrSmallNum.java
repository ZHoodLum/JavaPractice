package basal.LoopStructure;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:
 *
 */

public class FindMaxOrSmallNum {

	public static void main(String[] args) {
		//找出最大的数字
		testMax();
		//找出最小的数字
		testSmall();
	}

	/**
	 * 找出最大的数字
	 */
	public static void testMax() {
		int x1 =  1;
		while ( x1 < 10 ) {
			if( x1 > 8) {
				System.out.println("big x:"+ x1);
			}
			x1 = x1 + 1;
		}
	}

	/**
	 * 找出最小的数字
	 */
	public static void testSmall() {
		int x = 5;
		while (x > 1) {
			if(x < 3) {
				System.out.println("small x:"+x);
			}
			x = x - 1;
		}
	}

}
