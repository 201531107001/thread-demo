package com.me.synchorized.demo;

public class People {
	private int money;
	
	public People(int money) {
		this.money = money;
	}
	
	public synchronized void add() {
		money = money + 1;
	}
	
//	//�����淽���ȼ�
//	public void add() {
//		synchronized (this) {
//			money = money + 1;
//		}
//	}
	
	public int getMoney(){
		return money;
	}
}
