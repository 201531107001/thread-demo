package com.me.threadlocal;

/**
 * ThreadLocal �̱߳��ر�����˵���˾������һ�����������ᱻ����߳�ʹ�ã�����ÿ���߳�ʹ�õ�ֵ�ֲ�һ����Ϊ�˱�������߳�ͬ�����⣬���Կ���ʹ��
 * ThreadLocal,������Ȼʹ�õ���ͬһ��������������ÿ���߳����ǵ�ֵ�ǲ�һ���ģ����ɵ�ǰ�߳̾����ġ�
 * @author gqm
 *
 */
public class TestThreadLocal {
	
	public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
	
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadLocal.set(Thread.currentThread().getName());
				System.out.println("threadLocal:"+threadLocal.get());
			}
		},"thread1");
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadLocal.set(Thread.currentThread().getName());
				System.out.println("threadLocal:"+threadLocal.get());
			}
		},"thread2");
		
		thread1.start();
		thread2.start();
		
		
	}
}
