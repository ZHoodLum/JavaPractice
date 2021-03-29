package advanced.IO;

import com.sun.beans.editors.ByteEditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:字节流数组输出操作
 */


public class ByteArrayOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //开辟一块内存空间
        //初始容量默认32
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //初始容量为自定义的值 64
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(64);

        String string = "hello world ！ any  nothing";
        byte[] bytes = string.getBytes();

        //需要抛异常 IOException
        //这句话就把字符串写到缓冲区中了
        byteArrayOutputStream.write(bytes);

        System.out.println("写进去的流：" + byteArrayOutputStream.toString());
        System.out.println("初始化为64的位操作的流：" + byteArrayOutputStream2.toString());

        System.out.println("=================那么如何获取的byte数组呢？=================");
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        //打印到控制台
        for (int i = 0; i < bytes1.length; i++) {
            System.out.print((char) bytes1[i]);
        }
    }
}
