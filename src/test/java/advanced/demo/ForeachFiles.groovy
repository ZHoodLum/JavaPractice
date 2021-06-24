package advanced.demo

import com.google.common.base.Splitter
import groovy.io.FileType

import java.nio.file.Files
import java.nio.file.StandardOpenOption

/**
 * @className: ForeachFiles* @description:
 * @author: caoyangjie
 * @date: 2021/6/24
 * */
class ForeachFiles {
    static void main(args) {
        def ignoreFile = ["/.","/.git/","/target/",".iml",".jar","/test/"]
        String filePath = "/home/caoyangjie/IdeaProjects/spring-stack-skills"
        String homePath = "/home/caoyangjie/copy"
        def list = []
        def dir = new File(filePath)
        dir.eachFileRecurse (FileType.FILES) { file ->
            if( !ignore(file, ignoreFile) ){
                list << file
            }
        }
        println list.size()
        list.each { it->
            def writeFilePath = ((File)it).path.replace(filePath,homePath)
            def readLines = ((File)it).readLines()
            readLines.add(0,writeFilePath)
            ClipboardTools.setClipboardString(readLines.join("/r/n"))
            def lines = ClipboardTools.getClipboardString()
            def lineList = Splitter.on("/r/n").splitToList(lines);
            if( lineList.size() >= 2 ){
                writeContent(lineList.get(0),lineList.subList(1,lineList.size()))
            }
        }
    }

    static boolean ignore(File file,List<String> ignore){
        boolean returnValue = false
        ignore.forEach({it->
            returnValue = returnValue || file.path.contains(it) || file.path.endsWith(it)
        })
        returnValue
    }

    static void writeContent(String realPath,List<String> allLine){
        new File(realPath.substring(0,realPath.lastIndexOf("/"))).mkdirs()
        Files.write(new File(realPath).toPath(),allLine, StandardOpenOption.CREATE_NEW)
        println realPath
    }
}
