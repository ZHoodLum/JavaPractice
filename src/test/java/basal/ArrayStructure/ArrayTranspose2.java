package basal.ArrayStructure;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:数组转置优化升级
 *
 * 定义一个新的数组，将原始数组按照倒序的方式插入新的数组之中，虽有改变原始数组的引用。
 *
 */


public class ArrayTranspose2 {
    public static void main (String args[]){
        int data[] = new int[]{1,2,3,4,5,6,7,8};
        reverse(data);
        System.out.println("-----------------------");
        /**
         * 注意：下面print(data)方法操作是排过序之后的数组
         * 原因：除了基本类型boolean char  byte short int long  float double之外的数据类型都属于引用类型
         * 对象 数组都是引用类型
         *
         * 即Java中传递任何东西都是传值。
         * 如果传入方法的是基本类型的东西，你就得到此基本类型的一份拷贝。
         * 如果是传递引用，就得到引用的拷贝.
         */
        print(data);
    }
    //专门实现数组的转置操作
    public static void reverse(int arr[]){
        //转置次数
        int len = arr.length/2;
        //头部索引
        int head = 0;
        //尾部索引
        int tail = arr.length-1;
        for(int x=0;x<len;x++){
            int temp = arr[head];
            arr[head] = arr[tail];
            arr[tail] = temp;
            head++;
            tail--;
            print(arr);
        }
    }
    //专门定义一个输出的功能方法
    public static void print(int temp[]){
        for(int x=0;x<temp.length;x++){
            System.out.print(temp[x]+",");
        }
        System.out.println();
    }
}
