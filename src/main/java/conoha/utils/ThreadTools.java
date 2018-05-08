package conoha.utils;

import java.util.concurrent.*;

public class ThreadTools {

    public static ThreadPoolExecutor getThreadPool(int corePoolSize, int maximunPoolSize, int keepAliveTime, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(1, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), threadFactory,
                handler);

        return executorPool;
    }

    public static Runnable getMonitorThread(ThreadPoolExecutor executorPool, int time) {
        MonitorThread monitor = new MonitorThread(executorPool, time);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        return monitorThread;
    }

}
