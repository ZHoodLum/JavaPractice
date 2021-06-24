package basal.ArrayStructure;

import javax.sound.midi.Soundbank;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:数组转置
 * 定义一个新的数组，将原始数组按照倒序的方式插入新的数组之中，虽有改变原始数组的引用。
 *
 */


public class ArrayTranspose {
    public static void main (String args[]){
        int data[] = new int[]{1,2,3,4,5,6,7,8};
        //定义一个新的数组,数组长度与原始数组相同
        int temp[] = new int[data.length];

        //对于新的数组按照索引由小到大的顺序循环输出
        for(int x=0;x<temp.length;x++){
            temp[x] = data[temp.length - x - 1];
        }
        print(temp);
    }

    //专门定义一个输出的功能方法
    public static void print(int temp[]){
        for(int x=0;x<temp.length;x++){
//            System.out.print(temp[x]+",");

            /**
             * 强制转换
             * double > float > long > int > short > byte > char
             *
             * 隐式转换   JAVA自动转换
             * char  >  byte  > short >  int >  long  > float  > double
             *
             *
             * 注意：这里如果拼接的引号是单引号时： Java会把+号看成加法的加号，单引号里包裹的是一个char类型的字符
             * 自动触发隐式转换，所以会输出下面的内容格式
             * 52 51 50 49 48 47 46 45
             */
            System.out.print(temp[x]+',');
        }
    }
}
