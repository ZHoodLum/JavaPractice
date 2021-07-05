package advanced.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/1 8:07
 * @Description:标记接口
 */
public class CreateComparator {
    public static void main(String[] args) {
        //普通写法
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        TreeSet<String> tree = new TreeSet<>(comparator);

        //lambda表达式写法1
        Comparator<String> comparator1 = (String o1, String o2) -> {
            return o1.length() - o2.length();
        };
        TreeSet<String> tree1= new TreeSet<>(comparator1);


        //lambda表达式写法2
        Comparator<String> comparator2 = (o1, o2) -> o1.length() - o2.length();
        TreeSet<String> tree2= new TreeSet<>(comparator2);

    }
}
