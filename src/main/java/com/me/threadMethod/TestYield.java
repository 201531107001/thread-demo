package com.me.threadMethod;
/**
 * yield()方法使得当前线程让出处理器资源
 * @author 郭清明
 *
 */
public class TestYield {
	public static void main(String[] args){
		
		Thread thread1 = new Thread(new Task(),"123");
		Thread thread2 = new Thread(new Task(),"123456789");
		
		thread1.start();
		thread2.start();
	}
}
 
class Task implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始");
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"["+i+"]");
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName()+"结束");

	}
}
