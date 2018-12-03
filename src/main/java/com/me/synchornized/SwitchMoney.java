package com.me.synchornized;


/**
 * 同步与互斥
 * @author 郭清明
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
//          if (people[from].getMonet() < amount)
//              return;
            //当条件不满足时，将任务挂起，降低线程获取锁的开销
            while (people[from].getMoney() < amount) {
                try {
                    //将线程放入wait set
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            people[from].sub(amount);
            people[to].add(amount);
            System.out.println(people[to].getMoney());
            System.out.println("钱的总数" + getTotalMoney());   
            //唤醒等待的线程
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
