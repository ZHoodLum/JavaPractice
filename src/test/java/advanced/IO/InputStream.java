package advanced.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 20210329
 * @Description:
 */
public class InputStream {
    public static void main(String[] args) throws IOException {
        SynFrameRunnable();
    }

    //请求入口
    public static void SynFrameRunnable() throws IOException {
        Object object = readByOnce();
        System.out.println("请求报文是：" + object);
    }

    //高级参数才会调用的方法
    public static byte[] readByOnce() throws IOException {
        //模拟socket的消息内容
        File file = new File("D:\\IdeaProject\\JavaPractice\\src\\main\\resources\\IO\\test.txt");
        FileInputStream input = new FileInputStream(file);
        //每次读取1024个字节
        byte[] b = new byte[1024];
        int len = input.read(b); //一次性读取,返回总共读取的字节数
        System.out.println(len);
        if (len == -1) {
            String s = "client should not shutdown outputstream before response received";
//            System.out.println(s);
//            throw new IOException(s);
            return null;
        }

        System.out.println("`````````````````");

        byte[] req = new byte[len];
        System.out.println("我是探测报文：" + req);
        return req;
    }
}
