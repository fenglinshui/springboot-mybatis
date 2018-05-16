package conoha.utils;

import conoha.dao.AvMovieMapper;
import conoha.model.AvMovie;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class SisUtils {
    public static String rootUrl = "http://174.127.195.166/bbs/";
    public static String rootUrl2 = "http://www.sexinsex.net/bbs/";

    //    @Autowired
    private static AvMovieMapper avMovieMapper = (AvMovieMapper) SpringUtil.getBeanByClass(AvMovieMapper.class);

    public static Map<String, String> getHeader() {
        Map<String, String> map = new HashMap<>();
//        map.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//        map.put("Accept-Encoding","gzip, deflate, br");
//        map.put("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        map.put("Connection", "keep-alive");
        map.put("Cookie", "cdb3_sid=LF9tDc; __utma=1.54231517.1524705846.d.1w1rqwd524705846.1; __utmb=1.1.10.1524705846; __utmc=1; __utmz=1.1524705846.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1");
        map.put("Host", "www.south-plus.net");
        map.put("Upgrade-Insecure-Requests", "1");
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0");
        return map;
    }

    public static Elements getRows(String url) {
        Elements trs = null;
        try {
            Document document = ClawerTools.getDocument(rootUrl + url);
            Elements forms = document.getElementsByAttributeValue("id", "forum_229");
            Element form = forms.get(forms.size() - 1);
            trs = form.getElementsByTag("tr");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trs;
    }

    public static int getSize(String name) {
//        System.out.println(name);
        Matcher matcher = ClawerTools.getMatcher(name, "([\\d\\.]+[\\S]{2})+]");
        String size = "";
        int result = 0;
        if (matcher.find()) {
//            System.out.println("size:"+);
            size = matcher.group(1);
        }
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

    public static void getMovieDetails(Element element) {
        try {
            String tag = element.getElementsByTag("em").get(0).getElementsByTag("a").html();
            String name = element.getElementsByTag("span").get(0).getElementsByTag("a").html();
            String href = element.getElementsByTag("span").get(0).getElementsByTag("a").get(0).attr("href");
//        System.out.format("%-10s   -%20s   %-20s\n", tag, name, href);//tag
            Document page = ClawerTools.getDocument(rootUrl + href);
            Element attachment = null;
            String attachmentUrl = "";
            String attachmentName = "";
            if (page.getElementsByClass("t_attachlist").size() == 0) {

            } else {
                attachment = page.getElementsByClass("t_attachlist").get(0).getElementsByTag("a").get(0);
                attachmentUrl = rootUrl2 + attachment.attr("href");
                attachmentName = attachment.html();
            }

//        System.out.format("%-20s   %-20s", attachmentUrl, attachmentName);
            Elements imgs = page.getElementsByClass("t_msgfont").get(0).getElementsByTag("img");
            StringBuffer sb = new StringBuffer();

            int size = 5;
            if (imgs.size() < 5) {
                size = imgs.size();
            }
            for (int index = 0; index < size; index++) {
//            System.out.println(imgs.get(index).attr("src"));
                sb.append(imgs.get(index).attr("src"));
                sb.append(";");
            }
            getSize(name);
            sb.deleteCharAt(sb.length() - 1);
            AvMovie avMovie = new AvMovie();
            avMovie.setTag(tag);
            avMovie.setName(name);
            avMovie.setUrl(rootUrl2 + href);
            avMovie.setAttachmentName(attachmentName);
            avMovie.setAttachmentUrl(attachmentUrl);
            avMovie.setImgs(sb.toString());
            avMovie.setIsDelete(false);
            avMovie.setDownload(false);
            avMovie.setIsShow(true);
            avMovie.setSize((long) (getSize(name)));
            avMovie.setAddDate(new Date());
            System.out.println(name);
            System.out.println(avMovieMapper.insert(avMovie));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

}
