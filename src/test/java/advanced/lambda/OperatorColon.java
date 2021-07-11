package advanced.lambda;

import advanced.lambda.entity.MessageEntity;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/5 8:08
 * @Description:方法引用的操作符号的使用 ::
 * * 对象::实例方法
 * * 类::静态方法
 * * 类::实例方法
 * * 类::new
 */
public class OperatorColon {
    public static void main(String[] args) {
        //对象::实例方法
        //如果接口的方法只调用一个方法，并且这个方法的特点和接口的特征一样，就可以使用::操作符
        Consumer<String> consumer = money -> System.out.println("上网" + money);
        consumer.accept("对象::实例方法1  hello");

        //优化
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("对象::实例方法2  world");

        //类::静态方法 不常用
        //比较两个数
        Comparator<Integer> comparable = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println("类::静态方法1" + comparable);

        Comparator<Integer> comparable2 = Integer::compare;
        System.out.println("类::静态方法2" + comparable2);

        //类::实例方法
        Function<MessageEntity, String> function = e -> e.getName();
        System.out.println("类::实例方法1" + function.apply(new MessageEntity("男", "职业选手小明",123.01)));

        Function<MessageEntity, String> function1 = MessageEntity::getName;
        System.out.println("类::实例方法1" + function1.apply(new MessageEntity("男", "职业选手小明2",123.3)));


        //类::new
        Supplier<MessageEntity> supplier = () -> new MessageEntity();
        Supplier<MessageEntity> supplier1 = MessageEntity::new;
    }
}
