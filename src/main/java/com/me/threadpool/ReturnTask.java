package com.me.threadpool;

import java.util.concurrent.Callable;

/**
 * �з���ֵ������
 * @author gqm
 *
 */
public class ReturnTask implements Callable<Integer>{
	
	private int n; 
	
	public ReturnTask(int n) {
		this.n = n;
	} 

	@Override
	public Integer call() throws Exception {
		int result = 1;
		for(int i=1;i<n;i++) {
			result *= i;
		}
		return result;
	}
	
}
