package basal.ArrayStructure;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:
 */


public class ArrayTest1 {
    public static void main(String[] args) {
        int data[][] = new int[][]
                {
                        {1, 2, 3},
                        {2, 3, 4, 5},
                        {9, 4, 7, 8}
                };
        //外层循环控制数组的数据行内容
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data[x].length; y++) {
                System.out.print(data[x][y] + "    ");
            }
            System.out.println();
        }
    }
}
