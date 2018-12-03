package com.me.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * ���й鲢����
 * 
 * @author ������
 *
 */
public class ParallelMargeSort {
	
	public static void main(String[] args) {
		int[] list = new int[10000];
		Random random = new Random();
		for(int i=0;i<10000;i++) {
			int a = random.nextInt()%10000;
			list[i] = a;
		}
		
		parallelMargeSort(list);
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+" ");
			if((i+1) % 20 == 0 )
				System.out.println();
		}
	}

	public static void parallelMargeSort(int[] list) {
		//��������
		RecursiveAction recursiveAction = new SortTesk(list);

		//ִ��������̳߳�
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(recursiveAction);
	}

	/**
	 * �̳�RecursiveAction�����������޷���ֵ������
	 * @author gqm
	 *
	 */
	private static class SortTesk extends RecursiveAction {
		
		private static final long serialVersionUID = 1L;
		private int[] list;
		private final int THRESHOLD = 500;

		public SortTesk(int[] list) {
			this.list = list;
		}

		@Override
		protected void compute() {
			//����ִ�е�������񣬷�������ֽ�
			if (list.length <= THRESHOLD) {
				Arrays.sort(list);
			} else {
				int firstLength = list.length / 2;
				int[] firstHalf = new int[firstLength];
				System.arraycopy(list, 0, firstHalf, 0, firstLength);

				int secondLength = list.length - firstLength;
				int[] secondHalf = new int[secondLength];
				System.arraycopy(list, firstLength, secondHalf, 0, secondLength);

				//�ֽ�����������ɺ󷵻�
				invokeAll(new SortTesk(firstHalf), new SortTesk(secondHalf));
				MargeSort.marge(list, firstHalf, secondHalf);
			}
		}

	}
}
