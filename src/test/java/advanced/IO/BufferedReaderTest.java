package advanced.IO;

import java.io.*;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/29
 * @Description:
 */


public class BufferedReaderTest {
    //为了方便   使用InputStreamReader   自定义指定编码集
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;

        String projectPath = System.getProperty("user.dir");
        try {
            fileInputStream = new FileInputStream(projectPath + "\\src\\main\\resources\\IO\\BufferedReader.txt");
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            //这里面的1000 指的是缓冲区大小
            bufferedReader = new BufferedReader(inputStreamReader, 1000);

            //标记位   供reset()方法使用  与字节流不同  字节流reset()默认位置为文件开头位置
            //这里面的1000  一定要比文件大小要大  否则会抛异常
            bufferedReader.mark(1000);

            //两种方式去读文件
            //第一种方法  使用read()方法
            System.out.println("第一种方法  使用read()方法");
            int num = 0;
            num = bufferedReader.read();
            while (num != -1) {
                System.out.print((char) num);
                num = bufferedReader.read();
            }
            System.out.println(" ");
            System.out.println(" ");


            //第二种方法 使用readLine()方法
            System.out.println("第二种方法 使用readLine()方法");
            //注意 ****** 这里需要手动的marked 否则会抛异常java.io.IOException: Stream not marked******
            //重置  从文件开头开始读取文件
            bufferedReader.reset();
            //开始读取第一行
            String string = bufferedReader.readLine();
            //readLine判断其是否为空  不为空继续读，与read方法不一样  read方法读取文件末尾会返回-1
            while (string != null) {
                System.out.println(string);
                string = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    //使用FileReader方法的同时  也要注意文件与平台程序的编码一致性  否则会乱码
    //乱码的解决方式可以使用InputStreamReader方法  自定义执行编码集  方法如上面所示
    public static void main2(String[] args) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        String projectPath = System.getProperty("user.dir");
        try {
            fileReader = new FileReader(projectPath + "\\src\\main\\resources\\IO\\BufferedReader.txt");
            //这里面的1000 指的是缓冲区大小
            bufferedReader = new BufferedReader(fileReader, 1000);

            //两种方式去读文件
            //第一种方法  使用read()方法
            System.out.println("第一种方法  使用read()方法");
            int num = 0;
            num = bufferedReader.read();
            while (num != -1) {
                System.out.print((char) num);
                num = bufferedReader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

}
