package com.me.monitor;

public class People {
    private int money;
    public static Object object = new Object();

    public People(int money) {
        this.money = money;
    }

    public void add() {
        synchronized (object) {
            money = money + 10;
            object.notifyAll();
        }
    }

    public void sub() {
        synchronized (object) {

            try {
                while (money <= 0) {
                    object.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            money = money - 10;
        }
    }

    public int getMoney() {
        return money;
    }
}
