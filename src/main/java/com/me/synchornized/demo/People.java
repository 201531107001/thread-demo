package com.me.synchornized.demo;

public class People {
    private int money;
    
    public People(int money) {
        this.money = money;
    }
    
    public synchronized void add() {
        money = money + 1;
    }
    
//  //与上面方法等价
//  public void add() {
//      synchronized (this) {
//          money = money + 1;
//      }
//  }
    
    public int getMoney(){
        return money;
    }
}
