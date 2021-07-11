package advanced.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/6 7:23
 * @Description:流的创建方式
 */
public class StreamCreate {
    public static void main(String[] args) {

        System.out.println("//* 通过Collection对象的stream()或parallelStream()方法");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("world");
        Stream<String> stream = arrayList.stream();
//        stream.forEach(s -> System.out.println(s));
        stream.forEach(System.out::println);



        System.out.println("//* 通过Arrays类的stream方法");
        String[] arr = {"aaa", "bbb"};
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::println);


        System.out.println("//* 通过Stream接口的of()、iterate()、generate()方法");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 55, 646);
        integerStream.forEach(s -> System.out.println(s));

        System.out.println("迭代流");
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        System.out.println("生成流");
        Stream<Object> generate = Stream.generate(() -> new Random().nextInt(20));
        generate.limit(11).forEach(System.out::println);


        System.out.println("* IntStream、LongStream、DoubleStream接口中的of、range、rangeClosed 方法\n");
        IntStream intStream = IntStream.of(123, 123, 565);
        intStream.forEach(System.out::println);

        //0到122的值  开口
        IntStream range = IntStream.range(0, 123);
        range.forEach(System.out::println);

        //表示0到123的值 闭口
        IntStream intStream1 = IntStream.rangeClosed(0, 123);
        intStream1.forEach(System.out::println);
    }
}
