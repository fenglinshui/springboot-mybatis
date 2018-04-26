package conoha.quartz;

import conoha.utils.ClawerTools;
import conoha.utils.RejectedExecution;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.concurrent.*;

public class TaskTest {
    ThreadPoolExecutor executorPool = null;
    ThreadFactory threadFactory = Executors.defaultThreadFactory();
    RejectedExecution rejectionHandler = new RejectedExecution();
    @Test
    public void cronJob() {

        executorPool = new ThreadPoolExecutor(1, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), threadFactory,
                rejectionHandler);


        Document document = ClawerTools.getDocument("http://174.127.195.166/bbs/forum-229-1.html");
        Elements forms = document.getElementsByAttributeValue("id", "forum_229");
        Element form = forms.get(forms.size() - 1);
        Elements trs=form.getElementsByTag("tr");
        trs.stream().filter(element -> element.getElementsByTag("em").size()>0).forEach(element -> {
            String tag=element.getElementsByTag("em").get(0).getElementsByTag("a").html();
            String name=element.getElementsByTag("span").get(0).getElementsByTag("a").html();
            String  href=element.getElementsByTag("span").get(0).getElementsByTag("a").get(0).attr("href");
            System.out.format("%-10s   -%20s   %-20s\n",tag,name,href);//tag
            Document page = ClawerTools.getDocument("http://174.127.195.166/bbs/"+href);
            Element attachment=page.getElementsByClass("t_attachlist").get(0).getElementsByTag("a").get(0);
            String attachmentUrl="http://174.127.195.166/bbs/"+attachment.attr("href");
            String attachmentName=attachment.html();
            System.out.format("%-20s   %-20s",attachmentUrl,attachmentName);
            Elements imgs=page.getElementsByClass("t_msgfont").get(0).getElementsByTag("img");
            int size=5;
            if(imgs.size()<5){
                size=imgs.size();
            }
            for(int index=0;index<=size;index++){
                System.out.println(imgs.get(index).attr("src"));
            }
        });

    }
}