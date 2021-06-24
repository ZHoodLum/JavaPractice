package arithmetic.easy;

/**
 * @author：ZDY
 * @Date：Created on 2021/4/26 9:13
 * @Description: 冒泡排序法
 */
public class InsertSort {
    private static final int[] numberArray = {3, 2, 5, 6, 1, 4};

    public static void main(String[] args) {

        for (int i = 0; i < numberArray.length; i++) {
            for (int j = 0; j < numberArray.length - 1; j++) {
                if (numberArray[j] > numberArray[j + 1]) {
                    int temp = 0;
                    temp = numberArray[j];
                    numberArray[j] = numberArray[j + 1];
                    numberArray[j + 1] = temp;
                }
            }
        }

        for (int n : numberArray) {
            System.out.print(n + " ");
        }
    }

}
