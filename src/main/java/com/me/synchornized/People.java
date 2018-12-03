package com.me.synchornized;


public class People {
    private int money;

    public People(int money) {
        super();
        this.money = money;
    }
    
    public void add(int a) {
        money += a;
    }
    
    public void sub(int a) {
        money -= a;
    }
    
    public int getMoney(){
        return money;
    }
}
