package advanced.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:字符输入流
 * InputStreamReader 是字节流通向字符流的桥梁 ，字节转换为字符
 */


public class InputStreamReaderTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            //当前项目运行路径
            String projectPath = System.getProperty("user.dir");
            //fileInputStream = new FileInputStream("E:\\安装包\\video\\《JavaSE轻松入门高级教程》\\FileInputStream.txt");
            fileInputStream = new FileInputStream(projectPath + "\\src\\main\\resources\\IO\\FileInputStream.txt");

            //将 fileInputStream 作为参数传给 inputStreamReader 按照编码格式去读取文本，
            //fileInputStream去读取文本信息，但是每次处理都是inputStreamReader根据编码集的标准去处理文件信息
            //utf8中文按照每三个为一个字符去处理；  GBK中文按照每两个为一个字符去处理

            //手动指定编码集
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            //平台处理的可能会有问题 建议使用上面的
            //inputStreamReader = new InputStreamReader(fileInputStream);

            int num = 0;
            //与之前的比较分析一下 fileInputStream每次读取 一个字节 ； 而inputStreamReader每次读取的字节是按照编码集决定的  也就是UTF8读取三个  GBK读取两个
            //fileInputStream.read();
            //从第一个字开始读取文本
            num = inputStreamReader.read();
            while (num != -1) {
                System.out.print((char) num);
                //循环读取文本
                num = inputStreamReader.read();
            }
        }finally {
            //关闭流
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        }
    }
}
