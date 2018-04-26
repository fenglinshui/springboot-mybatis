package conoha.quartz;


import conoha.utils.ClawerTools;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class Task {

    @Scheduled(cron = "0/5 * * * * ?")
    public void cronJob() {
        Document document=ClawerTools.getDocument("http://174.127.195.166/bbs/forum-229-1.html");
        System.out.println("document:"+document);
        Elements forms=document.getElementsByAttributeValue("id","forum_229");
        System.out.println(forms.size());
    }
}
