package com.me.threadpool;

/**
 * �����࣬���߳�����
 * @author gqm
 *
 */
public class PrintTask implements Runnable{
	private String str = null;
	
	public PrintTask(String string) {
		this.str = string;
	}
	
	/** 
	 * ���500���ַ�
	 */
	@Override
	public void run() {
		for(int i=0;i<500;i++){
			System.out.print(str);
			if(i%20==0) 
				System.out.println();
		}
		System.out.println(str+"��ӡ���");
	}
}
