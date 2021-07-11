package advanced.lambda;

import advanced.lambda.entity.MessageEntity;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/6 8:08
 * @Description: 流的终止操作
 */
public class StreamStop {
    public static void main(String[] args) {
        ArrayList<MessageEntity> arrayList = new ArrayList<>();
        arrayList.add(new MessageEntity("男", "周总",123.01));
        arrayList.add(new MessageEntity("男", "周总",1232.00));
        arrayList.add(new MessageEntity("中", "二哈",1232.03));
        arrayList.add(new MessageEntity("女", "张总",1233.50));
        arrayList.add(new MessageEntity("女", "王总",1234.60));

        //所有操纵延迟执行
        System.out.println("---------------终止操作 forEach ---------------");
        arrayList.stream()
                .filter(s -> {
                    System.out.println("执行过滤条件");
                    return s.getSex().equals("男");
                })
                .forEach(System.out::println);

        System.out.println("---------------终止操作 min 工资最低---------------");
        Optional<MessageEntity> optionalMin = arrayList.stream()
                .min((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
        System.out.println(optionalMin.get());

        System.out.println("---------------终止操作 max 工资最高---------------");
        Optional<MessageEntity> optionalMax = arrayList.stream()
                .max((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
        System.out.println(optionalMax.get());

        System.out.println("---------------终止操作 count 员工个数---------------");
        long count = arrayList.stream().count();
        System.out.println(count);



    }
}
