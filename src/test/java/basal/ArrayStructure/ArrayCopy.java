package basal.ArrayStructure;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:数组拷贝
 */


public class ArrayCopy {

    public static void main(String[] args) {
            int A[] =  new int[]{1,2,3,4,5,6,7,8,9};
            int B[] =  new int[]{11,22,33,44,55,66,77,88};
            System.arraycopy(A,4,B,2,3);
        }
}
