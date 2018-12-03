package com.me.lock;

public class AccountTask implements Runnable {
	People people;
	boolean flag;
	public static int count = 0;

	public AccountTask(People people, boolean flag) {
		this.people = people;
		this.flag = flag;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				if (flag) {
					people.add();
					System.out.println(count++ +"  "+people.getMoney());
				} else {
					people.sub();
					System.out.println(count++ +"  "+people.getMoney());
				}

				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
