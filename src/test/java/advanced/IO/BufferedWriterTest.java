package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:通过缓冲流写文件
 * 接下来的示例是拷贝文件，文件拷贝
 */


public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String projectPath = System.getProperty("user.dir");

        try {
            //读取当前的JAVA的文件
            fileReader = new FileReader(projectPath +"\\src\\test\\java\\advanced\\IO\\BufferedWriterTest.java");
            //像文件 BufferedWriter.txt 写入文件信息
            fileWriter = new FileWriter(projectPath + "\\src\\main\\resources\\IO\\BufferedWriter.txt");

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("开始读取文件.....");
            //接下来开始读取文件信息
            int num = 0;
            //读取文件信息
            num = bufferedReader.read();
            while (num != -1) {
                System.out.println(num);
                //向文件BufferedWriter.txt 写入文件信息
                bufferedWriter.write(num);
                //向下读取文件信息
                num = bufferedReader.read();
            }
            //刷新缓冲区
            bufferedWriter.flush();
            System.out.println("刷新缓冲区, 文件拷贝成功！！！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            System.out.println("关闭流成功！！！");
        }

    }
}
