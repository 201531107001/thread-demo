package com.me.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *CyclicBarrier 也相当于一个线程同步器，当多个线程都执行完成时，再执行指定的回调函数
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.execute();
	}

	private int sum1,sum2;
	// 参数虽然是Runnable接口，但执行依然是串行(与其他线程中的一个),如果想要并行，就需要自己创建线程执行
	CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()->{
		System.out.println(sum1 + sum2);
		System.out.println(Thread.currentThread());
	});

	private void execute(){
		new Thread(()->{
			sum1 = sum(1,100);
			try {
				cyclicBarrier.await();
				System.out.println("sum1 "+Thread.currentThread());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(()->{
			sum2 = sum(101,200);
			System.out.println("sum2 "+Thread.currentThread());
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}).start();

		System.out.println("execute "+Thread.currentThread());
	}

	private int sum(int a,int b){
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum = sum + i;
		}
		return sum;
	}
}
