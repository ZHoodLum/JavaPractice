package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:字节流输出操作
 */

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //要写入文件的字节
        String string = "we4rt5yuh,olsadfhansfniaWZcfiazivgfinfan";

        FileOutputStream fileOutputStream1 = null;
        FileOutputStream fileOutputStream2 = null;

        String projectPath = System.getProperty("user.dir");

        File file1 = new File(projectPath + "\\src\\main\\resources\\IO\\FileOutPutStream1.txt");
        File file2 = new File(projectPath + "\\src\\main\\resources\\IO\\FileOutPutStream2.txt");

        //判断文件是否存在 创建新的文件
        //创建新的文件  createNewFile
        //创建新的文件夹  mkdirs  或者 mkdir
        if (!file2.exists()) {
            file1.createNewFile();
            System.out.println("创建文件：" + file1);
        }
        if (!file1.exists()) {
            file2.createNewFile();
            System.out.println("创建文件：" + file2);
        }
        try {
            //抛异常 FileNotFoundException
            fileOutputStream1 = new FileOutputStream(file1);
            fileOutputStream2 = new FileOutputStream(file2);

            System.out.println("开始对流进行写的操作.....");
            //字符串转数组  然后根据API的方法直接写入
            byte[] bytes = string.getBytes();

            System.out.println("使用第1种方法写流......");
            //抛异常 IOException
            //使用API方法 void write(byte[] buffer)|
            fileOutputStream1.write(bytes);

            System.out.println("使用第2种方法写流......");
            //使用API方法 void write(byte[] buffer,int `off`,int len)  指定字节数组中从`偏移量 off` 开始的 len 个字节
            fileOutputStream2.write(bytes, 0, string.length());


            System.out.println("写入文件成功！！！");
        }
        //检测流是否为空   不为空的时候 关闭  防止资源浪费
        finally {
            if (fileOutputStream1 != null) {
                fileOutputStream1.close();
                System.out.println("关闭流操作fileOutputStream1");
            }
            if (fileOutputStream2 != null) {
                System.out.println("关闭流操作fileOutputStream2");
                fileOutputStream2.close();
            }
        }
    }
}


