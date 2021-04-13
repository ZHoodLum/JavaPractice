package advanced.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:字节流的输入操作
 */


public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");

        File file = new File(projectPath + "\\src\\main\\resources\\IO\\FileInputStream.txt");

        FileInputStream fileInputStream = null;
        int num = 0;
        //需要抛异常，FileNotFoundException 主要是怕文件找不到
//        fileInputStream = new FileInputStream("E:\\安装包\\video\\《JavaSE轻松入门高级教程》\\FileInputStream.txt");
        fileInputStream = new FileInputStream(file);

        //需要抛异常 IOException(父异常  所以FileNotFoundException就没有了)   主要是怕读文件的是否很有可能会出问题   文件突然被删除  服务器挂机等等
        num = fileInputStream.read();
        while (num != -1) {
            System.out.print((char) num);
            num = fileInputStream.read();
        }
        /**
         * 注意  上面的程序如果说文件中由中文的话  会存在乱码的问题  后续在解决
         *  因为字节流是按照字节去读取文件的，而一个字节无法描述完整的一个杆子，所以会出现乱码的问题
         */
    }
}
