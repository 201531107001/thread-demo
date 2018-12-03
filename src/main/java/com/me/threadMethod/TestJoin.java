package com.me.threadMethod;
import java.util.*;
/**
 * join()����ʹ�������̶߳��ȴ���ǰ�߳�ִ�����
 * 
 * @author ������
 *
 */
public class TestJoin {
	public static void main(String[] args) {

		Thread thread1 = new Thread(new Task1(), "123");
		Thread.currentThread().setName("main");

		thread1.start();
		//�ȴ�thread1�߳�ִ�����
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<100;i++){
			System.out.println("main"+i);
		}
	}
}

class Task1 implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
}