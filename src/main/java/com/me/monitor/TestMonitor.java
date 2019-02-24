package com.me.monitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在1.5之前，无锁和条件，线程间的通信是通过监视器
 * java的任何对象都可以是监视器
 * @author 郭清明
 *
 */
public class TestMonitor {
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(10);
		People people = new People(0);
		
		//加钱
		service.submit(new AccountTask(people, true));
		service.submit(new AccountTask(people, true));
		service.submit(new AccountTask(people, true));
		service.submit(new AccountTask(people, true));
		service.submit(new AccountTask(people, true));
		
		//减钱
		service.submit(new AccountTask(people, false));
		service.submit(new AccountTask(people, false));
		service.submit(new AccountTask(people, false));
		service.submit(new AccountTask(people, false));
		service.submit(new AccountTask(people, false));
		
		service.shutdown();
		
		while(!service.isTerminated()){

		}
		
		System.out.println("main"+people.getMoney());
	}
}






















