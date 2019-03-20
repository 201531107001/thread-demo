package com.me.lock.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1.Java并发库中ReetrantReadWriteLock实现了ReadWriteLock接口并添加了可重入的特性
 * 2.ReetrantReadWriteLock读写锁的效率明显高于synchronized关键字
 * 3.ReetrantReadWriteLock读写锁的实现中，读锁使用共享模式；写锁使用独占模式，换句话说，
 * 读锁可以在没有写锁的时候被多个线程同时持有，写锁是独占的
 * 4.ReetrantReadWriteLock读写锁的实现中，需要注意的，当有读锁时，写锁就不能获得；而当有写锁时，
 * 除了获得写锁的这个线程可以获得读锁外，其他线程不能获得读锁
 * 地址:https://www.jianshu.com/p/9cd5212c8841
 *
 */
public class ReadWriteLockTest {
	//ReadWriteLock，其读锁是共享锁，其写锁是独享锁。
	//读锁的共享锁可保证并发读是非常高效的，读写，写读 ，写写的过程是互斥的。
	public static ReadWriteLock rwLock = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		new Thread(()->read()).start();
		new Thread(()->read()).start();
		new Thread(()->write()).start();
		new Thread(()->write()).start();
	}

	public static void read(){
		try {
			for (int i=0;i<5;i++){
				rwLock.readLock().lock();
				System.out.println(Thread.currentThread()+":进行读操作...");
				Thread.sleep(1000);
				rwLock.readLock().unlock();
			}
		}catch (Exception e){

		}
	}

	public static void write(){
		try {
			for(int i=0;i<5;i++) {
				rwLock.writeLock().lock();
				System.out.println(Thread.currentThread() + ":正在进行写操作...");
				rwLock.readLock().lock();
				System.out.println(Thread.currentThread() + ":正在进行读操作...");
				rwLock.readLock().unlock();
				Thread.sleep(1000);
				rwLock.writeLock().unlock();
			}
		}catch (Exception e){

		}
	}
}
