package com.me.synchorized.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ������һ�������ϵ�ͬ��ʵ������ʱ���߳�Ϊ�ö����������ʽ������
 * ������һ�����ϵ�ͬ����̬����ʱ���߳�Ϊ���������ʽ������
 * ��ִ�з�����ͬ�������ǣ�����������this,��������Ϊ�κζ����������ʽ������
 * @author ������
 *
 */
public class Test {
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(10);
		People people = new People(100);
		//10���߳�����ת������
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		service.submit(new ChangeMoneyTask(people));
		
		service.shutdown();
		
		while(!service.isTerminated()){
		}
		System.out.println(people.getMoney());
	}
}
