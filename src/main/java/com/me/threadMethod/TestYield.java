package com.me.threadMethod;
/**
 * yield()����ʹ�õ�ǰ�߳��ó���������Դ
 * @author ������
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
		System.out.println(Thread.currentThread().getName()+"��ʼ");
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"["+i+"]");
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName()+"����");

	}
}
