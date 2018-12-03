package com.me.synchorized.demo;

public class ChangeMoneyTask implements Runnable {

	People people;

	public ChangeMoneyTask(People people) {
		this.people = people;
	}

	@Override
	public void run() {

		try {
			for(int i=0;i<5;i++){
				people.add();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
