package conoha.quartz;


import conoha.thread.SisTaskOne;
import conoha.utils.RejectedExecution;
import conoha.utils.SisUtils;
import conoha.utils.ThreadTools;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class Task {
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
        executorPool = ThreadTools.getThreadPool(1, 4, 10, Executors.defaultThreadFactory(), new RejectedExecution());
        Runnable monitor = ThreadTools.getMonitorThread(executorPool, 1);
        for (int index = 1000; index < 10000; index++) {
            Elements trs = SisUtils.getRows("forum-229-" + index + ".html");
            if (trs == null) {
                continue;
            }
            trs.stream().filter(element -> element.getElementsByTag("em").size() > 0).forEach(element -> {
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
