package com.me.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Executors��ĵײ�ʵ�ֱ���ThreadPoolExecutor,���ݲ�����ͬ������ͬ���̳߳�
 * �鿴����http://dongxuan.iteye.com/blog/901689#bc2382115
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
