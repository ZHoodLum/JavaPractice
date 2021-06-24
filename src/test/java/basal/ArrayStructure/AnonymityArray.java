package basal.ArrayStructure;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:匿名数组
 */


public class AnonymityArray {
    public static void main (String args[]){
        int data[] = init();
        print(data);
    }
    //匿名数组
    public static int[] init(){
        //重点关注方法的返回内容
        return new int[]{1,2,3,4,5};
    }
    public static void print(int temp[]){
        for(int x=0;x<temp.length;x++){
            System.out.print(temp[x]+",");
        }
        System.out.println();
    }
}
