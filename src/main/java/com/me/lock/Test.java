package com.me.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 为程序显示加锁
 * @author 郭清明
 *
 */
public class Test {
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
		
		while(!service.isTerminated());
		
		System.out.println("main"+people.getMoney());
	}
}
