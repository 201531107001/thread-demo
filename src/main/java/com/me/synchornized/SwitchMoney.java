package com.me.synchornized;


/**
 * ͬ���뻥��
 * @author ������
 *
 */
public class SwitchMoney {
	public People people[] = new People[100];
	private Object lock = new Object();
	
	public static void main(String[] args) {
		SwitchMoney sMoney = new SwitchMoney();
		for(int i=0;i<100;i++){
			SwitchTask task = new SwitchTask(i, sMoney);
			new Thread(task).start();
		}
	}
	
	public SwitchMoney(){
		for(int i=0;i<100;i++)
			people[i] = new People(100);		
	}
	
	public void switchMoney(int from, int to, int amount) {
		synchronized (lock) {
//			if (people[from].getMonet() < amount)
//				return;
			//������������ʱ����������𣬽����̻߳�ȡ���Ŀ���
			while (people[from].getMoney() < amount) {
				try {
					//���̷߳���wait set
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			people[from].sub(amount);
			people[to].add(amount);
			System.out.println(people[to].getMoney());
			System.out.println("Ǯ������" + getTotalMoney());	
			//���ѵȴ����߳�
			lock.notifyAll();
		}

	}
	
	public int getTotalMoney() {
		int totalMonet = 0;
		for(int i=0;i<100;i++)
			totalMonet+=people[i].getMoney();
		return totalMonet;
	}
}
