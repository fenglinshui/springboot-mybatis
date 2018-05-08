package conoha.utils;

import java.util.concurrent.ThreadPoolExecutor;

//多线程监视类
public class MonitorThread implements Runnable {
    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run = true;

    public MonitorThread(ThreadPoolExecutor executor, int delay) {
        this.executor = executor;
        this.seconds = delay;
    }

    public void shutdown() {
        this.run = false;
    }

    @Override
    public void run() {
        while (run) {
            System.out
                    .println(String
                            .format("[线程监视器] [当前线程数：%d/核心线程数：%d] 正在执行任务: %d, 完成任务数: %d, 当前队列中任务总数: %d, 是否已停止: %s, 任务是否完成: %s",
                                    this.executor.getPoolSize(),
                                    this.executor.getCorePoolSize(),
                                    this.executor.getActiveCount(),
                                    this.executor.getCompletedTaskCount(),
                                    this.executor.getTaskCount(),
                                    this.executor.isShutdown(),
                                    this.executor.isTerminated()));
            try {
                Thread.sleep(seconds * 1000);
                if (this.executor.isTerminated()) {
                    run = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
