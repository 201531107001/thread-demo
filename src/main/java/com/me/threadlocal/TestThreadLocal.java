package com.me.threadlocal;

/**
 * ThreadLocal 线程本地变量，说白了就是针对一个变量，他会被多个线程使用，但是每个线程使用的值又不一样，为了避免出现线程同步问题，所以可以使用
 * ThreadLocal,这样虽然使用的是同一个变量，但是在每个线程他们的值是不一样的，是由当前线程决定的。
 * @author gqm
 *
 */
public class TestThreadLocal {
    
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    
    public static void main(String[] args) {
        
        Thread thread1 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                threadLocal.set(Thread.currentThread().getName());
                System.out.println("threadLocal:"+threadLocal.get());
            }
        },"thread1");
        Thread thread2 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                threadLocal.set(Thread.currentThread().getName());
                System.out.println("threadLocal:"+threadLocal.get());
            }
        },"thread2");
        
        thread1.start();
        thread2.start();
        
        
    }
}
