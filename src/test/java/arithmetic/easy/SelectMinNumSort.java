package arithmetic.easy;

/**
 * @author：ZDY
 * @Date：Created on 2021/4/26 9:30
 * @Description: 选择排序法
 */
public class SelectMinNumSort {
    private static final double[] arr = {86.5, 77.5, 87, 68.9, 89.6, 77.2, 79.7, 71};

    public static void main(String[] args) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (i != min) {
                double tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }

        for (double n : arr) {
            System.out.print(n + " ");
        }
    }
}
