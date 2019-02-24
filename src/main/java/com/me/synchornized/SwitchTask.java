package com.me.synchornized;

/**
 * 支付金钱线程
 */
public class SwitchTask implements Runnable{
    private int id;
    private SwitchMoney switchMoney;
    
    public SwitchTask(int id, SwitchMoney switchMoney) {
        super();
        this.id = id;
        this.switchMoney = switchMoney;
    }

    @Override
    public void run() {
        while(true){
            int to = (int)(Math.random()*100);
            int amount = (int)(Math.random()*10);
            switchMoney.switchMoney(id, to, amount);
            try {
                Thread.sleep((int)(Math.random()%10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
