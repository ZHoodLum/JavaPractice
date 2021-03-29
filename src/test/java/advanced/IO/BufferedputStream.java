package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:主要测试的是 缓冲字节输入（BufferedInputStream）和输出（BufferedOutputStream）流
 * 使用缓冲字节流是  以空间换时间 的一个操作  因为开辟缓冲区是需要内存的   默认开辟8192个内存空间  去操作缓冲流
 */
public class BufferedputStream {

    public static void main(String[] args) throws IOException {
        //输入
        FileInputStream fileInputStream = null;
        //private static int DEFAULT_BUFFER_SIZE = 8192;  默认大小大概在8K这样
        BufferedInputStream bufferedInputStream = null;
        //输出
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        //写入文件
        //file是真正和文件进行IO操作的
        //当前项目运行路径
        String projectPath = System.getProperty("user.dir");
        //fileInputStream = new FileInputStream("E:\\安装包\\video\\《JavaSE轻松入门高级教程》\\FileOutPutStream1.txt");
        fileInputStream = new FileInputStream(projectPath + "\\src\\main\\resources\\IO\\FileOutPutStream1.txt");

        //bufferedInputStream = new BufferedInputStream(fileInputStream);

        //这样创建就是一次性读取16384个字节  默认按照默认8192字节去读取文件
        //而buffered是每次和缓冲区（就是我们的字节数组 16384）进行交互  相比file来说  性能要好
        bufferedInputStream = new BufferedInputStream(fileInputStream,16384);

        //输出文件
        //如果单独使用file是每次都要向文件中write(int)个字节 都要进行IO操作
        fileOutputStream = new FileOutputStream(projectPath + "\\src\\main\\resources\\IO\\FileOutPutStream2.txt");
        //先向缓冲区写入字节 当缓冲区写满了 或者 文件数据写完，在将缓冲区的数据直接写入文件  减少IO操作次数
        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        int num = 0;
        try {
            num = fileInputStream.read();

            while (num != -1) {
                //向文件FileOutPutStream2写数据
                bufferedOutputStream.write((char) num);
                //循环读取文件FileOutPutStream1
                num = fileInputStream.read();
            }
            //必须刷新  因为是缓冲流  如果缓冲区没有写满  则强制将缓冲区的数据写入文件
            bufferedOutputStream.flush();
            System.out.println("我读取文件FileOutPutStream1，向文件FileOutPutStream2写数据成功啦！！");
        }
        //用完流记得关闭
        //操作顺序是  由内向外关闭流操作  否则生成出来的文件有问题或者丢失数据
        finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        }

    }
}