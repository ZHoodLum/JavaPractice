package advanced.JVM;

import java.util.concurrent.TimeUnit;

/**
 * @author：ZDY
 * @Date：Created on 2021/6/19 19:20
 * @Description:
 */
public class ShutDownHook {
    public static void main(String[] args) {
        new ShutDownHook().start();
        System.out.println("The Application is doing something");

        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Execute Hook.....");
            }
        }));
    }
}
