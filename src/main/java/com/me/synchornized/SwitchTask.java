package com.me.synchornized;


public class SwitchTask implements Runnable{
	private int from;
	private SwitchMoney switchMoney;
	
	public SwitchTask(int from, SwitchMoney switchMoney) {
		super();
		this.from = from;
		this.switchMoney = switchMoney;
	}

	@Override
	public void run() {
		while(true){
			int to = (int)(Math.random()*100);
			int amount = (int)(Math.random()*10);
			switchMoney.switchMoney(from, to, amount);
			try {
				Thread.sleep((int)(Math.random()*10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
