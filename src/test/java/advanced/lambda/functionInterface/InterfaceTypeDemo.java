package advanced.lambda.functionInterface;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/5 7:44
 * @Description:函数式接口的使用
 */
public class InterfaceTypeDemo {

    public static void main(String[] args) {
        /**************************消費型接口consumer****************************/
        //消费型接口
        //匿名内部类的方式
        Consumer<Double> consumer = new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("上网" + money);
            }
        };
        happy(consumer, 100);

        //优化lambda表达式的方法 因为只有一个参数  直接去掉方法和参数即可
        Consumer<Double> consumer1 = money -> {
            System.out.println("上网" + money);
        };
        happy(consumer1, 100);

        //优化2  直接通过方法调用
        happy(money -> System.out.println("消费" + money), 200);

        /**************************supplier 攻击型接口****************************/
        int[] arr = getNum(() -> new Random().nextInt(110), 5);
        System.out.println("110以内随机数5个是：" + Arrays.toString(arr));

    }
    //消費i型接口consumer
    public static void happy(Consumer<Double> consumer, double money) {
        consumer.accept(money);
    }


    //supplier 攻击型接口
    public static int[] getNum(Supplier<Integer> supplier, int count) {
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = supplier.get();
        }
        return arr;
    }


}
