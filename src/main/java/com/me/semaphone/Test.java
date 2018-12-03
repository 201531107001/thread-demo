package com.me.semaphone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Semaphone �ź�����ֻ�л���źŵ��߳̿��Լ���ִ�У������߳���������������һ��������Դ���̷߳�����
 * acquire() ��ȡ�źţ��ź�����1�����Ϊ�����߳�����
 * release() �ͷ��źţ��ź�����1
 * @author ������
 *
 */
public class Test {
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(10);
		People people = new People(0);
		
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		service.submit(new AddMoneyTask(people));
		
		service.shutdown();
		while(!service.isTerminated());
		System.out.println(people.getMoney());
	}
}
