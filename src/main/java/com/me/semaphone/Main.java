package com.me.semaphone;

import java.util.concurrent.Semaphore;

public class Main {
	public static Semaphore semaphore = new Semaphore(0);
	public static void main(String[] args) {
		new Thread(()->customer()).start();
		//new Thread(()->producter()).start();
	}

	public static void producter(){
		System.out.println("生产者添加产品");
		semaphore.release();
	}

	public static void customer(){
		try {
			semaphore.acquire();
			System.out.println("消费者消费产品");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
