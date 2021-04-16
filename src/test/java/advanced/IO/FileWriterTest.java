package advanced.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:写文件字符流，编码集与系统编码默认一致
 */

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = null;
        String projectPath = System.getProperty("user.dir");

        try {
            fileWriter = new FileWriter(projectPath + "\\src\\main\\resources\\IO\\FileWriter.txt");
            String writerString = "啦啦啦啦 我是卖报的小行家；你kin你擦";

            for (int i = 0; i < writerString.length(); i++) {
                fileWriter.write(writerString.charAt(i));
            }
            //强制写入
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流要严谨  不为空才关闭
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
