package com.me.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class People {
	private int money;
	public static Lock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();

	public People(int money) {
		this.money = money;
	}
	
	public void add() {
		try {
			lock.lock();
			money = money + 10;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void sub() {
		lock.lock();

		try {
			while (money <= 0) {
				condition.await();
			}
			money = money - 10;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public int getMoney() {
		return money;
	}
}
