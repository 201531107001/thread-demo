package com.me.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Executors类的底层实现便是ThreadPoolExecutor,根据参数不同创建不同的线程池
 * 查看博客http://dongxuan.iteye.com/blog/901689#bc2382115
 * @author gqm
 *
 */
public class TestThreadPoolExecetor {
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(5));
		
		threadPoolExecutor.execute(new PrintTask("a"));
		threadPoolExecutor.execute(new PrintTask("b"));
		threadPoolExecutor.execute(new PrintTask("c")); 
		threadPoolExecutor.execute(new PrintTask("d"));
		threadPoolExecutor.execute(new PrintTask("e"));
		threadPoolExecutor.execute(new PrintTask("f"));
		
		threadPoolExecutor.shutdown();
	}
}
