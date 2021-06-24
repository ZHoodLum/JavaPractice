package basal.ArrayStructure;

import java.util.Arrays;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:冒泡排序
 * 使用冒牌排序，对A数组内数字进行由小到大排序
 *  思想：冒泡排序，主要使用双重for循环，
 *  第一层for循环，为了控制循环次数,j<a.length循环次数小于数组长度，否则会出现数组越界情况；
 *  for循环，为了比较数组内数组的大小，共对数组内数字比较a.length-1-j次。
 *  if语句循环，a[i]a[i+1]两两数进行比较，并互换位置。
 */


public class BubbleSort {
    public static void main(String[] args) {
        //由小到大进行排序
        int[] a = {23,13,45,6,78,12,4,1};
        //冒泡排序
        //循环a.length次
        //循环次数 可以控制时间
        for(int j=0;j<a.length;j++){
            //1\最大值放在提取出来13 23 6 45 12 4 1 78
            //1\第二大放在提取出来13 6 23 12 4 1 45 78
            //每次排序进行比较 加j与不加j区别  需要优化
            for(int i=0;i<a.length-1-j;i++){
                if(a[i]>a[i+1]){
                    int temp = 0;
                    //a[i]  a[i+1] 进行位置互换
                    temp =a[i+1];
                    a[i+1]=a[i];
                    a[i]=temp;
                }
            }
        }
        //输出
        for(int n:a){
            System.out.print(n+"  ");
        }
    }
}
