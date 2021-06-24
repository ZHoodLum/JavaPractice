package advanced.demo;

import com.google.common.base.Splitter;

import java.io.IOException;
import java.util.List;

import static advanced.demo.ForeachFileWork.writeContent;

/**
 * @author：ZDY
 * @Date：Created on 2021/6/24 23:14
 * @Description:
 */
public class MainFor {
    static int count = 0;
    static String lastcontent = "";

    public static void main(String[] args) {
        for (; ; ) {

            String lines = ClipboardTools.getClipboardString();
            if (lastcontent.equals(lines)) {
                count++;
            } else {
                count = 0;
            }
            if (count > 10) {
                break;
            }
            List<String> lineList = Splitter.on("/r/n").splitToList(lines);

            if (lineList.size() >= 2) {
                try {
                    writeContent(lineList.get(0), lineList.subList(1, lineList.size()));
                } catch (IOException e) {
                }
            }
        }
    }
}
