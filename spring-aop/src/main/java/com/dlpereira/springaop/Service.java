package com.dlpereira.springaop;

@org.springframework.stereotype.Service
public class Service {

    @LogExecutionTime
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }
}
