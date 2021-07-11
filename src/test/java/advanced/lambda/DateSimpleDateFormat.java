package advanced.lambda;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/11 23:14
 * @Description:时间的线程安全问题
 */
public class DateSimpleDateFormat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyMMdd");

        //创建线程池
        ExecutorService pools = Executors.newFixedThreadPool(9);
        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                //Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.NumberFormatException: For input string: ""
                //	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
                //	at java.util.concurrent.FutureTask.get(FutureTask.java:192)
                //	at advanced.lambda.DateSimpleDateFormat.main(DateSimpleDateFormat.java:35)
                //Caused by: java.lang.NumberFormatException: For input string: ""
                //会报错  线程安全问题除非加入synchronized上锁  才不会发生上面的问题
                synchronized (simpleDateFormat) {
                    return simpleDateFormat.parse("20210712");
                }
            }
        };

        //将时间存放在List集合中
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Date> funcTrue = pools.submit(callable);
            list.add(funcTrue);
        }

        for (Future<Date> funcTrue : list) {
            System.out.println(funcTrue.get());
        }

        //==========================JDK1.8特性==================================================//
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> callable1 = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20210713", dateTimeFormatter);
            }
        };

        //将时间存放在List集合中
        List<Future<Date>> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Date> funcTrue = pools.submit(callable);
            list.add(funcTrue);
        }

        for (Future<Date> funcTrue : list1) {
            System.out.println(funcTrue.get());
        }

        //关闭线程池
        pools.shutdown();



        //==============================本地化日期时间API=======================================//
        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime localDateTime2 = LocalDateTime.of(year,month,dayOfMonth,hour,mintue);
        System.out.println(localDateTime);
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());

        //当前时间加2天
        LocalDateTime localDateTime1 = localDateTime.plusDays(2);
        //减少两天
        LocalDateTime localDateTime2 = localDateTime.minusDays(1);


        //==============================本时间戳与时区======================================//

        //Instant 时间戳
        Instant instant = Instant.now();
        System.out.println("现在打印的时间与实际时间应该差8个小时，与格林尼治的时间就是差8个小时的："+instant.toString());

        //加十秒
        Instant instant1 = instant.plusSeconds(10);
        //减十秒
        Instant instant2 = instant.minusSeconds(10);

        //ZoneID 时区
        Set<String> strings = ZoneId.getAvailableZoneIds();
        for (String str : strings) {
            System.out.println("所有时区：" + str);
        }

        System.out.println("中国时区" + ZoneId.systemDefault().toString());



        //==============================Date、Instant、LocalDateTime 的转换======================================//
        //1 Date --> Instant
        Date date = new Date();
        Instant instant3 = date.toInstant();
        System.out.println("Date转换为Instant：" + instant3);

        //Instant --> localDateTime
        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(instant3, ZoneId.systemDefault());
        System.out.println("Instant --> localDateTime 当前时间"+localDateTime3);

        //localDateTime  -->  Instant 先获取时区在转换为instatn
        Instant instant4 = localDateTime3.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant4);

        //Instant -->  Date
        Date date1 = Date.from(instant4);
        System.out.println("Instant -->  Date 当前的时间是：" + date1);


        //============================== DateTimeFormatter 时间格式化======================================//
        //时间格式化字符串
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //当前时间格式化
        String format = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println("时间格式化字符串" + format);


        //把字符转解析城市间
        LocalDateTime parse = LocalDateTime.parse("2021/07/12 23:54:12", dateTimeFormatter1);
        System.out.println("把字符转解析城市间" + parse);

    }
}
