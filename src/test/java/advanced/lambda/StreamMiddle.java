package advanced.lambda;

import advanced.lambda.entity.MessageEntity;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/6 7:41
 * @Description:流的中间操作
 */
public class StreamMiddle {
    public static void main(String[] args) {
        ArrayList<MessageEntity> arrayList = new ArrayList<>();
        arrayList.add(new MessageEntity("男", "周总",123.01));
        arrayList.add(new MessageEntity("男", "周总",1232.00));
        arrayList.add(new MessageEntity("中", "二哈",1232.03));
        arrayList.add(new MessageEntity("女", "张总",1233.50));
        arrayList.add(new MessageEntity("女", "王总",1234.60));

        //中间操作 filter 过滤、limit 限制、skip 跳过、distinct 去重、sorted 排序
        System.out.println("---------filter 过滤----------");
        arrayList.stream()
                .filter(s -> s.getSex().equals("男"))
                .forEach(System.out::println);

        System.out.println("---------limit 限制----------");
        arrayList.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("---------skip 跳过----------");
        arrayList.stream()
                .skip(1)
                .forEach(System.out::println);

        System.out.println("---------distinct 去重 需要在对象MessageEntity中重写HashCode和equals方法啊才可以----------");
        arrayList.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("---------sorted 排序----------");
        arrayList.stream()
                .sorted((q1, q2) -> Double.compare(q1.getMoney(), q1.getMoney()))
                .forEach(System.out::println);

        System.out.println("---------map----------");
        arrayList.stream()
                .map(e -> e.getName())
                .forEach(System.out::println);

        System.out.println("---------parallel 采用的是多线程 效率高----------");
        arrayList.parallelStream()
                .forEach(System.out::println);

        System.out.println("*****************************串行流和并行流*****************************");
        ArrayList<String> arrayList1 = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            arrayList1.add(UUID.randomUUID().toString());
        }

        //串行 用时 4毫秒
        long startTime = System.currentTimeMillis();
        long count = arrayList1.stream().count();
        System.out.println(count);
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - startTime));


        //并行  用时1毫秒
        long startTime1 = System.currentTimeMillis();
        long count1 = arrayList1.parallelStream().count();
        System.out.println(count1);
        long endTime1 = System.currentTimeMillis();
        System.out.println("用时：" + (endTime1 - startTime1));

    }
}
