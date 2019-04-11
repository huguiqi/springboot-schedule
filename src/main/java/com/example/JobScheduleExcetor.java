package com.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by sam on 2019/4/11.
 */
@Component
public class JobScheduleExcetor {

  private int count = 0;

@Scheduled(fixedDelay = 20*1000)
@Async("taskScheduler")
public void fixedDelayJob() throws InterruptedException {

    System.out.println(Thread.currentThread().getName()+"===task fixedDelayJob run");
    Thread.sleep(6*1_000);
    System.out.println(Thread.currentThread().getName()+"===task fixedDelayJob end");
}

 @Scheduled(fixedRate = 20*1000)
 @Async("taskScheduler")
public void fixedRateJob() throws InterruptedException {
     count ++;
     System.out.println("count is :"+count);
    System.out.println(Thread.currentThread().getName()+"===fixedRateJob task run");
     Thread.sleep(6*1_000);
     System.out.println(Thread.currentThread().getName()+"=== fixedRateJob task end");

     if (count == 5){
         throw new IllegalStateException("逻辑错误");
     }
}


}
