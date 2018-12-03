package com.me.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ���������ֵ
 * 
 * @author ������
 *
 */
public class ParallerFindMax {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(10000);
		Random random = new Random();
		int max = 0;
		for (int i = 0; i < 10000; i++) {
			int a = random.nextInt() % 10000;
			if (a > max)
				max = a;
			list.add(a);
		}
		System.out.println(max);
		System.out.println(findMax(list));
	}

	public static int findMax(List<Integer> list) {
		int a = findMax(list, 0, list.size() - 1);
		return a;
	}

	public static int findMax(List<Integer> list, int head, int tail) {
		// ��������
		RecursiveTask<Integer> findTask = new FindTask(list, head, tail);

		// �����̳߳�
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(findTask);
	}

	/**
	 * �̳�RecursiveTask�����������з���ֵ������
	 * 
	 * @author gqm
	 *
	 */
	private static class FindTask extends RecursiveTask<Integer> {
		private static final long serialVersionUID = 1L;

		private List<Integer> list;
		private int head, tail, length;
		public final int THRESHOLD = 1000;

		public FindTask(List<Integer> list, int head, int tail) {
			this.list = list;
			this.head = head;
			this.tail = tail;
			this.length = tail - head + 1;
		}

		@Override
		protected Integer compute() {

			// ����ִ�е����������
			if (length < THRESHOLD) {
				Integer max = list.get(head);
				for (int i = head; i <= tail; i++) {
					if (list.get(i).compareTo(max) > 0)
						max = list.get(i);
				}
				return max;
			} else {
				int secondHalf = (head + tail) / 2;
				int firstHalf = (secondHalf + head) / 2;
				int thirdHalf = (secondHalf + tail) / 2;

				// �����ֽ�����
				FindTask first = new FindTask(list, head, firstHalf);
				FindTask second = new FindTask(list, firstHalf, secondHalf);
				FindTask third = new FindTask(list, secondHalf, thirdHalf);
				FindTask fourth = new FindTask(list, thirdHalf, tail);

				
				// invokeAllҲ�ǵ��õ�fork�����ֽ�����ִ��
				// invokeAll(first, second, third, fourth);

				first.fork();
				second.fork();
				third.fork();
				fourth.fork();

				// ��ȡ����ֵ
				Integer a = first.join();
				Integer b = second.join();
				Integer c = third.join();
				Integer d = fourth.join();
				int e = Math.max(a, b);
				int f = Math.max(c, d);

				return new Integer(e > f ? e : f);
			}
		}
	}

}
