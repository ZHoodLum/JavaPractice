package advanced.IO;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:练习字节流的时候，控制台打印中文字节出现中文乱码，那么应该如何处理呢，首先来了解一下编码
 */


public class ReaderWriterTest {
    public static void main(String[] args) {
        System.out.println("当前文件的编码格式：" + System.getProperty("file.encoding"));

        String string = "大家好";
        System.out.println("文件为UTF8时字节占用长度" + string.getBytes().length);
        //输出：文件为GBK时字节占用长度9
        //也就是说UTF8每个字节占用3个字符

        System.out.println("文件为GBK时字节占用长度" + string.getBytes().length);
        //输出：文件为GBK时字节占用长度6
        //也就是说GBK每个字节占用2个字符
    }
}
