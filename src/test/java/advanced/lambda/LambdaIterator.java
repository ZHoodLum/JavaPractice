package advanced.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：ZDY
 * @Date：Created on 2021/4/17 11:43
 * @Description:
 */
public class LambdaIterator {
    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap();
        map.put("b", "2222");
        map.put("a", "aaaa");
        map.put("c", "ffff");
        map.put("d", "gggg");

        list.add(map);

        list.forEach(n -> {
            n.forEach((key, value) -> {
                System.out.println(key + "----" + value);
            });
        });

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("asd,dd,a22,123");

        String[] strings = stringBuffer.toString().split(",");
        for (String n : strings) {
            System.out.print(n + " ");
        }


        System.out.println("===========================");
        String appName = "global_Gatewayasdasd_dasd_GLO";
        if (appName.toUpperCase().contains("GLOBAL") || appName.toLowerCase().contains("global")) {
            System.out.println("YESYESYES22");
        } else {
            System.out.println("NONONO22");
        }

    }

}
