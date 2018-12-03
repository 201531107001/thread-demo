package com.me.thread;

public class ThreadDemo2 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++)
			System.out.println(i);
	}
	
	
	public static void main(String[] args) {
		Runnable runnable = new ThreadDemo2();
		Thread thread = new Thread(runnable);
		thread.start();
		for(int i=0;i<1000;i++)
			System.out.println(" 	"+i);
	}
}
