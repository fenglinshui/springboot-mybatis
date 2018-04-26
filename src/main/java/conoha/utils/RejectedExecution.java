package conoha.utils;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecution implements RejectedExecutionHandler {


	/**
	 * 当线程已满时，任务执行的内容
	 */
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.execute(r);
		System.out.println(Thread.currentThread().getName()+r.toString() + " 被拒绝");
	}

}