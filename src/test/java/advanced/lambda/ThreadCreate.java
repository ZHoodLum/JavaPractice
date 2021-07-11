package advanced.lambda;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/1 8:02
 * @Description:创建线程
 */
public class ThreadCreate {
    public static void main(String[] args) {
        //普通写法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程1开始运行....");
            }
        };
        new Thread(runnable).start();

        //lambda表达式写法1
        Runnable runnable1 = () -> {
            System.out.println("子线程2开始运行....");
        };
        new Thread(runnable1).start();

        //lambda表达式写法2
        Runnable runnable2 = () -> System.out.println("子线程2开始运行....");
        new Thread(runnable2).start();

        //lambda表达式写法3
        new Thread(() -> System.out.println("子线程3开始运行....")).start();
    }
}
