package com.me.threadgroup;

/**
 * 在java中为了方便线程管理出现了线程组ThreadGroup的概念，每个ThreadGroup可以同时包含多个子线程和多个子线程组，
 * 在一个进程中线程组是以树形的方式存在，通常情况下根线程组是system。system线程组下是main线程组，默认情况下第一级应
 * 用自己的线程组是通过main线程组创建出来的。
 * @author 清明
 *
 */
public class ThreadGroupTest {

    public static void main(String[] args) throws InterruptedException {
        // 主线程对应的线程组
        printGroupInfo(Thread.currentThread());// 线程组为main父线程组为system

        // 新建线程，系统默认的线程组
        Thread appThread = new Thread(() -> {}, "appThread");
        printGroupInfo(appThread);// 线程组为main父线程组为system

        // 自定义线程组
        ThreadGroup factoryGroup = new ThreadGroup("factory");
        Thread workerThread = new Thread(factoryGroup, () -> {}, "worker");
        printGroupInfo(workerThread);// 线程组为factory，父线程组为main

        // 设置父线程组
        ThreadGroup deviceGroup = new ThreadGroup(factoryGroup, "device");
        Thread pcThread = new Thread(deviceGroup, () -> {}, "pc");
        printGroupInfo(pcThread);// 线程组为device，父线程组为factory

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
