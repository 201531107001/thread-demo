package com.me.synchorized.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 当调用一个对象上的同步实例方法时，线程为该对象加锁（隐式加锁）
 * 当调用一个类上的同步静态方法时，线程为类加锁（隐式加锁）
 * 当执行方法的同步语句块是，不仅可以是this,还可以是为任何对象加锁（隐式加锁）
 * @author 郭清明
 *
 */
public class Test {
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(10);
		People people = new People(100);
		//10个线程启动转账任务
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		
		service.shutdown();
		
		while(!service.isTerminated()){
		}
		System.out.println(people.getMoney());
	}
}
