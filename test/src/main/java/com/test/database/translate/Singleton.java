package com.test.database.translate;

public class Singleton {
    private volatile Singleton singleton;

    public Singleton getInstanse(){
        if(singleton==null){
            synchronized (this.getClass()){
                if (singleton==null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
