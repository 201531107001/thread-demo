package com.me.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ϊ������ʾ����
 * @author ������
 *
 */
public class Test {
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(10);
		People people = new People(0);
		
		//��Ǯ
		service.submit(new AccountTask(people, true));
		service.submit(new AccountTask(people, true));
		service.submit(new AccountTask(people, true));
		service.submit(new AccountTask(people, true));
		service.submit(new AccountTask(people, true));
		
		//��Ǯ
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