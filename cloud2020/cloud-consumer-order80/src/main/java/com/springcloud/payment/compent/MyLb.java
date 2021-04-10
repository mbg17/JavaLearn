package com.springcloud.payment.compent;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLb {

    private AtomicInteger atomicInteger = new AtomicInteger();

    public final int getCurrent(){
        int current;
        int next;
        do{
            current=atomicInteger.get();
            next = current>= Integer.MAX_VALUE ? 0:current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));
        return next;
    }

    public ServiceInstance getInstance(List<ServiceInstance> serviceInstanceList){
        int i = getCurrent() % serviceInstanceList.size();
        return serviceInstanceList.get(i);
    }


}
