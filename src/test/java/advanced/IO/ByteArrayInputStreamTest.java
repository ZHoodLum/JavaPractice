package advanced.IO;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:字节流数组输入操作
 */


public class ByteArrayInputStreamTest {

    public static void main(String[] args) {
        String string = "hello world";
        byte[] bytes = string.getBytes();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        int num = 0;

        //循环两次 目的是配合API使用mark()和reset()方法
        //mark() 设置流中的当前标记位置。
        //reset() 将缓冲区的位置重置为标记位置。
        //两者配合使用时的效果就是   mark标记的位置为标记为   使用reset() 再次读取该字节时，从标记位（mark()）开始读取
        for (int i = 0; i < 2; i++) {
            num = byteArrayInputStream.read();
            //-1代表读到文件末尾啦
            while (num != -1) {
                //第一次读取字符串时
                if (i == 0) {
                    System.out.print((char) num);
                }
                //当i=2时  为第二次循环 读取字符串
                else{
                    System.out.print(Character.toUpperCase((char) num));
                }
                //读取字符串
                num = byteArrayInputStream.read();
            }
            System.out.println("===========我是分割线===========");
            //当i=1时  第一次读完了   那么在我使用for循环第二次读取该字符串时
            //我想从最开头的位置读取  也就是从缓冲区最开始的位置读取
            //注：ByteArrayInputStream本身就是一个缓冲区
            byteArrayInputStream.reset();
        }
    }
}
