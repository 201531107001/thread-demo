package com.me.semaphone;

import java.util.concurrent.Semaphore;

public class People {
	private int money;
	//�����ź���Ϊ1��ʵ���߳�ͬ��
	public static Semaphore semaphore = new Semaphore(1);

	public People(int money) {
		this.money = money;
	}

	public void add() {
		try {
			semaphore.acquire();
			money = money + 1;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	public int getMoney() {
		return money;
	}
}
