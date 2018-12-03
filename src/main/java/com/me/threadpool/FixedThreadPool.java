package com.me.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * �����̳߳���������
 * @author ������
 *
 */
public class FixedThreadPool {
	
	public static void main(String[] args) {
		FixedThreadPool.excuteMethod();
		
		//FixedThreadPool.submitMethod();
	}
	
	/**
	 * ececute����ִ���޷���ֵ������
	 */
	public static void excuteMethod(){
		//�����̳߳ش�СΪ5,�������������5��������������Ҫ�ȴ���������ִ����
		ExecutorService service = Executors.newFixedThreadPool(5);
		 
		service.execute(new PrintTask("a"));
		service.execute(new PrintTask("b"));
		service.execute(new PrintTask("c"));
		service.execute(new PrintTask("d"));
		service.execute(new PrintTask("e"));
		service.execute(new PrintTask("f"));
		
		
		//�رշ��񣬲����������
		service.shutdown();
		//�رշ���ֹͣ��������
		//service.shutdownNow();
	}
	
	/**
	 * submit�����񽻸�RunnableFuture��Ȼ�����excuteִ�У����������з���ֵ������
	 */ 
	public static void submitMethod(){
		//�����̳߳ش�СΪ5
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		Future<Integer> future1 = (Future<Integer>) service.submit(new ReturnTask(5));
		Future<Integer> future2 = (Future<Integer>) service.submit(new ReturnTask(6));
		Future<Integer> future3 = (Future<Integer>) service.submit(new ReturnTask(7));
		Future<Integer> future4 = (Future<Integer>) service.submit(new ReturnTask(8));
		Future<Integer> future5 = (Future<Integer>) service.submit(new ReturnTask(9));
		
		
		//�رշ��񣬲����������
		service.shutdown(); 
		
		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
			System.out.println(future3.get());
			System.out.println(future4.get());
			System.out.println(future5.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		//�رշ���ֹͣ��������
		//service.shutdownNow();
	}
}
