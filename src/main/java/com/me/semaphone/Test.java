package com.me.semaphone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Semaphone 信号量，只有获得信号的线程可以继续执行，否则线程阻塞。可以限制一个共享资源的线程访问数
 * acquire() 获取信号，信号量减1，如果为空则线程阻塞
 * release() 释放信号，信号量加1
 * @author 郭清明
 *
 */
public class Test {
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(10);
		People people = new People(0);
		
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		
		service.shutdown();
		while(!service.isTerminated());
		System.out.println(people.getMoney());
	}
}
