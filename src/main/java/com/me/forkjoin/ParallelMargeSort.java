package com.me.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 并行归并排序
 * 
 * @author 郭清明
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
		//创建任务
		RecursiveAction recursiveAction = new SortTesk(list);

		//执行任务的线程池
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(recursiveAction);
	}

	/**
	 * 继承RecursiveAction，用来定义无返回值的任务
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
			//允许执行的最大任务，否则将任务分解
			if (list.length <= THRESHOLD) {
				Arrays.sort(list);
			} else {
				int firstLength = list.length / 2;
				int[] firstHalf = new int[firstLength];
				System.arraycopy(list, 0, firstHalf, 0, firstLength);

				int secondLength = list.length - firstLength;
				int[] secondHalf = new int[secondLength];
				System.arraycopy(list, firstLength, secondHalf, 0, secondLength);

				//分解任务，任务完成后返回
				invokeAll(new SortTesk(firstHalf), new SortTesk(secondHalf));
				MargeSort.marge(list, firstHalf, secondHalf);
			}
		}

	}
}
