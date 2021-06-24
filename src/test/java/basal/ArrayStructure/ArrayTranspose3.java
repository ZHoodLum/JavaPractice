package basal.ArrayStructure;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:数组转置优化升级
 *实现二维数组的转置
 *
 * 要求：
 * 经过转换需要得到数组：（需求）
 * 1 4 7
 * 2 5 `8`
 * 3 `6` 9
 */


public class ArrayTranspose3 {
    public static void main (String args[]){
        int data[][] = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        reverse(data);
        print(data);
    }
    //专门实现数组的转置操作
    public static void reverse(int arr[][]){
        for(int x=0;x<arr.length;x++){
            for(int y=x;y<arr[x].length;y++){
                //行和列相同，进行交换
                if(x != y ){
                    int temp = arr[x][y];
                    arr[x][y] = arr[y][x];
                    arr[y][x] = temp;
                }
            }
        }
    }
    //专门定义一个输出的功能方法
    public static void print(int temp[][]){
        for(int x=0;x<temp.length;x++){
            for(int y=0;y<temp[x].length;y++){
                System.out.print(temp[x][y]+'、');
            }
        }
        System.out.println();
    }
}
