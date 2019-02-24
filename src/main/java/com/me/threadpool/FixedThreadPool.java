package com.me.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 创建线程池运行任务
 * 队列采用LinkedBlockingQueue（阻塞队列）实现，有容量，即当线程数达到最大值，就不会创建线程了
 * @author 郭清明
 *
 */
public class FixedThreadPool {
	
	public static void main(String[] args) {
		FixedThreadPool.excuteMethod();
		
		//FixedThreadPool.submitMethod();
	}
	
	/**
	 * ececute方法执行无返回值的任务
	 */
	public static void excuteMethod(){
		//生成线程池大小为5,如果添加任务大于5，则多余的任务需要等待其他任务执行完
		ExecutorService service = Executors.newFixedThreadPool(5);
		 
		service.execute(new PrintTask("a"));
		service.execute(new PrintTask("b"));
		service.execute(new PrintTask("c"));
		service.execute(new PrintTask("d"));
		service.execute(new PrintTask("e"));
		service.execute(new PrintTask("f"));
		
		
		//关闭服务，不再添加任务
		service.shutdown();
		//关闭服务，停止所有任务
		//service.shutdownNow();
	}
	
	/**
	 * submit将任务交给RunnableFuture，然后调用excute执行，用来处理有返回值的任务
	 */ 
	public static void submitMethod(){
		//生成线程池大小为5
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		Future<Integer> future1 = service.submit(new ReturnTask(5));
		Future<Integer> future2 = service.submit(new ReturnTask(6));
		Future<Integer> future3 = service.submit(new ReturnTask(7));
		Future<Integer> future4 = service.submit(new ReturnTask(8));
		Future<Integer> future5 = service.submit(new ReturnTask(9));
		
		
		//关闭服务，不再添加任务
		service.shutdown(); 
		
		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
			System.out.println(future3.get());
			System.out.println(future4.get());
			System.out.println(future5.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		//关闭服务，停止所有任务
		//service.shutdownNow();
	}
}
