package advanced.IO;

import java.io.File;
import java.io.IOException;

/**
 * @author：ZDY
 * @Date：Created on 2021/4/7 16:30
 * @Description:
 */
public class SystemGetpropertyPath {
    static final String uploadFilePath = System.getProperty("user.dir") + "//asa//falog";

    public static void main(String[] args) throws IOException {
        test();
        String fileName = "ddd.jar";
        if (null != fileName && !"".equals(fileName)) {
            int index = fileName.indexOf(".");
            String indexFileName = fileName.substring(0, index);
            String subFileName = fileName.substring(index + 1, fileName.length());

            if (subFileName.equals("zip") || subFileName.equals("jar")) {
                System.out.println(indexFileName + "上传成功" + subFileName);
            }
        } else {
            System.out.println("呱");
        }

        File file = new File(uploadFilePath + "/" + "V1.1.1_" + fileName);

        System.out.println("文件全路径1：" + file.getPath());
        System.out.println("文件全路径2：" + file.getAbsolutePath());
        System.out.println("文件全路径3：" + file.getCanonicalPath());
    }
    public static void test() {
        System.out.println(uploadFilePath);
    }
}
