package advanced.IO;

import java.io.File;

/**
 * @author：ZDY
 * @Date：Created on 2021/4/8 13:56
 * @Description:
 */
public class uploadFileFolder {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "\\src\\main\\resources\\IO\\test.txt");

        if (file.exists()) {
            file.delete();
            System.out.println("删除成功");
        }
    }
}
