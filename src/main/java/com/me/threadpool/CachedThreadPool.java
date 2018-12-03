package com.me.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �ɶ�̬�����̵߳��̳߳أ����һ���߳�60����û��ʹ�ã���destroy��
 * @author gqm
 *
 */
public class CachedThreadPool {
	
	public static void main(String[] args) {
		//�����̵߳��̳߳�
		ExecutorService service = Executors.newCachedThreadPool();
		 
		service.execute(new PrintTask("a"));
		service.execute(new PrintTask("b"));
		service.execute(new PrintTask("c"));
		service.execute(new PrintTask("d"));
		service.execute(new PrintTask("e"));
		service.execute(new PrintTask("f"));
		
		service.shutdown();
	}
}
