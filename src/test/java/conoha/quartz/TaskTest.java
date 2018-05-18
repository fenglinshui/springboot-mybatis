package conoha.quartz;

import conoha.utils.ClawerTools;
import org.junit.Test;

import java.util.regex.Matcher;

public class TaskTest {

    @Test
    public void cronJob() {
        System.out.println(getSize("[MP4/1582MB]"));
    }

    public static int getSize(String name) {
//        System.out.println(name);
//        Matcher matcher = ClawerTools.getMatcher(name, "([0-9]{1,5}[GBM]{2})+]");
        Matcher matcher = ClawerTools.getMatcher(name, "([\\d\\.]+[GMB]{2})+]");
        String size = "";
        int result = 0;
        if (matcher.find()) {
//            System.out.println("size:"+);
            size = matcher.group(1);
        }
        System.out.println(size);
        if (size.contains("MB")) {
            result = Integer.valueOf(size.replace("MB", ""));
        }
//        System.out.println(size);
        if (size.contains("GB")) {
            Float f = 1024 * Float.valueOf(size.replace("GB", ""));
            result = f.intValue();
        }
        ;
        return result;
    }
}
