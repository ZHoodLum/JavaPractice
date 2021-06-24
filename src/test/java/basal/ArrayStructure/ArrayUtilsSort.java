package basal.ArrayStructure;

import java.util.Arrays;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:
 */


public class ArrayUtilsSort {
    public static void main(String[] args) {
        //由小到大进行排序
        int[] a = {23, 13, 45, 6, 78, 12, 4, 1};
        //arrays.sort排序
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
