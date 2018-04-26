package conoha.utils;

import java.util.HashMap;
import java.util.Map;

public class SisUtils {
    public static Map<String,String> getHeader(){
        Map<String, String> map=new HashMap<>();
//        map.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//        map.put("Accept-Encoding","gzip, deflate, br");
//        map.put("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        map.put("Connection","keep-alive");
        map.put("Cookie","cdb3_sid=LF9tDc; __utma=1.54231517.1524705846.1524705846.1524705846.1; __utmb=1.1.10.1524705846; __utmc=1; __utmz=1.1524705846.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1");
        map.put("Host","www.south-plus.net");
        map.put("Upgrade-Insecure-Requests","1");
        map.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0");
        return map;
    }
}
