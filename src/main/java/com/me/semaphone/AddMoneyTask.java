package com.me.semaphone;

public class AddMoneyTask implements Runnable{
    private People people;
    
    public AddMoneyTask(People people) {
        this.people = people;
    }
    
    @Override
    public void run() {
        try{
        for(int i=0;i<5;i++){
            people.add();
            Thread.sleep(500);
        }
        }catch(Exception e){
            
        }
    }
}
