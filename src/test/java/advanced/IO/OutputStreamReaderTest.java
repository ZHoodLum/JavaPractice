package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:字符流输出操作 OutputStreamWriter 是字符流通向字节流的桥梁  将字符转换为字节
 */


public class OutputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        String projectPath = System.getProperty("user.dir");
        try {
            fileOutputStream = new FileOutputStream(projectPath + "\\\\src\\\\main\\\\resources\\\\IO\\\\FileOutPutStream2.txt");

//            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            //防止出现乱码的问题  指定字符集的编码格式
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            String string = "马什么梅？马冬梅；什么冬梅？马冬梅；马什么梅？您歇着吧！好嘞！！";

            for (int i = 0; i < string.length(); i++) {
                outputStreamWriter.write(string.charAt(i));
            }
            //强制写入文件
            outputStreamWriter.flush();
        } finally {
            //关闭流  先关闭被调用的
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (outputStreamWriter != null) {
                //关闭流之前  会先执行flush方法
                outputStreamWriter.close();
            }
            System.out.println("关闭流成功！");
        }


    }
}
