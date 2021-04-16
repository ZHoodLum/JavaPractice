package advanced.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:读文件的操作类
 * * 我们先回忆一下字符输入流的操作
 *  * 首先新建FileInputStream fileInputStream = new FileInputStream(projectPath + "\\src\\main\\resources\\IO\\FileInputStream.txt");
 *  * 然后将fileInputStream作为一个变量传给inputStreamReader
 *  * InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
 *  * 过程是这样去操作流的
 *  * 那么FileReader是怎么处理的呢？直接去操作文件  ，可以大大的简化代码量
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");
        FileReader fileReader = null;
        try {
            //这样的filereader就可以直接去操作文件了   还可以处理中文
            fileReader = new FileReader(projectPath + "\\src\\main\\resources\\IO\\FileReader.txt");

            int num = 0;
            num = fileReader.read();
            while (num != -1) {
                System.out.print((char) num);
                num = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

    }
}
