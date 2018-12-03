package com.me.thread;

public class ThreadDemo extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<1000;i++)
			System.out.println(i);
	}
	
	public static void main(String[] args) {
		new ThreadDemo().start();
		for(int i=0;i<1000;i++)
			System.out.println(" 	"+i);
	}
}
