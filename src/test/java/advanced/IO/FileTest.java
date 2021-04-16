package advanced.IO;

import java.io.File;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/28
 * @Description:文件管理--File类
 */


public class FileTest {
    public static void main(String[] args) {
        /**
         * File这个类名起的有点歧义，他代表的不仅仅是文件，还有文件夹
         * 所以说FilePath这个名字更能体现出File的真实含义
         */
        String projectPath = System.getProperty("user.dir");

        File file = new File(projectPath + "\\src\\main\\resources\\IO");

        //文件是否存在
        if (!file.exists()) {//不存在
            //递归的创建文件夹
//            file.mkdirs();
            System.out.println("创建文件夹成功！！");
            //如果说文件夹存在多级目录  使用file.mkdir()会报错
            // file.mkdir();
        }
        //如果文件夹存在  则证明可以获取信息
        else {
            //listFiles() 获取该文件夹下的所有文件信息
            File[] files = file.listFiles();
            for(File getFile:files){
                System.out.println("文件名称：" + getFile.getName() + "             文件路径：" + getFile.getPath() + "             是否是一个文件：" + getFile.isFile()+"             是否是一个文件夹：" + getFile.isDirectory());
            }
        }
    }
}
