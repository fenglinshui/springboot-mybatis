package conoha.quartz;


import conoha.dao.AvMovieMapper;
import conoha.thread.SisTaskOne;
import conoha.utils.RejectedExecution;
import conoha.utils.SisUtils;
import conoha.utils.ThreadTools;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class Task {

    @Autowired
    private AvMovieMapper avMovieMapper;
    ThreadPoolExecutor executorPool = null;
    Boolean flag = false;
    @Scheduled(cron = "0/5 * * * * ?")
    public void cronJob() {
        if (flag) {
            System.exit(0);
        }
        flag = true;
//        AvMovie avMovie=new AvMovie();
//        avMovie.setId((11));
//        avMovie.setName("flag");
//        AvMovieMapper avMovieMapper=  (AvMovieMapper) SpringUtil.getBeanByClass(AvMovieMapper.class);
//        avMovieMapper.insert(avMovie);
//        if(flag){
//            return;
//        }
        Set<String> names = avMovieMapper.getNames();
        System.out.println("saved:" + names.size());
        executorPool = ThreadTools.getThreadPool(1, 10, 10, Executors.defaultThreadFactory(), new RejectedExecution());
        Runnable monitor = ThreadTools.getMonitorThread(executorPool, 1);
        for (int index = 1; index < 1001; index++) {
            Elements trs = SisUtils.getRows("forum-229-" + index + ".html");
            System.out.println("forum-229-" + index + ".html");
            if (trs == null) {
                continue;
            }
            trs.stream().filter(element -> element.getElementsByTag("em").size() > 0).forEach(element -> {
//                String href = element.getElementsByTag("span").get(0).getElementsByTag("a").get(0).attr("href");
                String name = element.getElementsByTag("span").get(0).getElementsByTag("a").html();
                if (names.contains(name)) {

                } else {
                    while (executorPool.getActiveCount() >= 20) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "已达最大进程数");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    executorPool.execute(new SisTaskOne(element));
                }

            });
        }
//
        executorPool.shutdown();
        while (executorPool.getActiveCount() != 0) {
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
