package advanced.demo;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @className: ForeachFiles* @description:
 * @author: caoyangjie
 * @date: 2021/6/24
 * */
public class ForeachFileWork {
    public static void main(String[] args) throws Exception{
        List<String> ignoreFile = Arrays.asList("/.","/.git/","/target/",".iml",".jar","/test/");
        String filePath = "/home/caoyangjie/IdeaProjects/spring-stack-skills";
        String homePath = "/home/caoyangjie/copy";
        File dir = new File(filePath);
        getFileList(filePath,new ArrayList<>()).stream().filter(file-> !ignore(file, ignoreFile) ).forEach(file->{
            String writeFilePath = file.getAbsolutePath().replace(filePath,homePath);
            List<String> readLines = null;
            try {
                readLines = Files.readAllLines(file.toPath());
            } catch (IOException e) {
                readLines = new ArrayList<>();
            }finally {
            }
            readLines.add(0,writeFilePath);
            ClipboardTools.setClipboardString(Joiner.on("/r/n").join(readLines));
            String lines = ClipboardTools.getClipboardString();
            List<String> lineList = Splitter.on("/r/n").splitToList(lines);
            if( lineList.size() >= 2 ){
                try {
                    writeContent(lineList.get(0),lineList.subList(1,lineList.size()));
                } catch (IOException e) {
                }
            }
        });
    }

    public static List<File> getFileList(String strPath,List<File> filelist) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath(),filelist);
                } else {
                    filelist.add(files[i]);
                }
            }

        }
        return filelist;
    }

    static boolean ignore(File file,List<String> ignore){
        AtomicBoolean returnValue = new AtomicBoolean(false);
        ignore.forEach(it->{
            returnValue.set(returnValue.get() || file.getAbsolutePath().contains(it) || file.getAbsolutePath().endsWith(it));
        });
        return returnValue.get();
    }

    static void writeContent(String realPath,List<String> allLine) throws IOException {
        new File(realPath.substring(0, realPath.lastIndexOf(File.separator))).mkdirs();
        Files.write(new File(realPath).toPath(),allLine, StandardOpenOption.CREATE_NEW);
    }
}
