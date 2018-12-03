package com.me.threadgroup;

/**
 * ��java��Ϊ�˷����̹߳���������߳���ThreadGroup�ĸ��ÿ��ThreadGroup����ͬʱ����������̺߳Ͷ�����߳��飬
 * ��һ���������߳����������εķ�ʽ���ڣ�ͨ������¸��߳�����system��system�߳�������main�߳��飬Ĭ������µ�һ��Ӧ
 * ���Լ����߳�����ͨ��main�߳��鴴�������ġ�
 * @author ����
 *
 */
public class ThreadGroupTest {

	public static void main(String[] args) throws InterruptedException {
		// ���̶߳�Ӧ���߳���
		printGroupInfo(Thread.currentThread());// �߳���Ϊmain���߳���Ϊsystem

		// �½��̣߳�ϵͳĬ�ϵ��߳���
		Thread appThread = new Thread(() -> {}, "appThread");
		printGroupInfo(appThread);// �߳���Ϊmain���߳���Ϊsystem

		// �Զ����߳���
		ThreadGroup factoryGroup = new ThreadGroup("factory");
		Thread workerThread = new Thread(factoryGroup, () -> {}, "worker");
		printGroupInfo(workerThread);// �߳���Ϊfactory�����߳���Ϊmain

		// ���ø��߳���
		ThreadGroup deviceGroup = new ThreadGroup(factoryGroup, "device");
		Thread pcThread = new Thread(deviceGroup, () -> {}, "pc");
		printGroupInfo(pcThread);// �߳���Ϊdevice�����߳���Ϊfactory

	}

	static void printGroupInfo(Thread t) {
		ThreadGroup group = t.getThreadGroup();
		System.out.println("thread " + t.getName() + " group name is " + group.getName() 
				+ " max priority is "+ group.getMaxPriority() 
				+ " thread count is " + group.activeCount() 
				+ " parent group is " + (group.getParent() == null ? null : group.getParent().getName()));

		ThreadGroup parent = group;
		do {
			ThreadGroup current = parent;
			parent = parent.getParent();
			if (parent == null) {
				break;
			}
			System.out.println(current.getName() + " Group's  parent group name is " + parent.getName());

		} while (true);
		System.out.println("--------------------------");
	}

}
