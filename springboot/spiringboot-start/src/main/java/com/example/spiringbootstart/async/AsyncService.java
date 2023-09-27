package com.example.spiringbootstart.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AsyncService {
    @Async("getAsyncExecutor")
    public void asyncProcess() throws InterruptedException {
        log.info("async task, current thread name:::", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep((2));
    }

    @Async("getAsyncExecutor")
    public AsyncResult<Integer> asyncProcessReturn()throws InterruptedException {
        log.info("async task has return, current thread name:::", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        return new AsyncResult<Integer>(100);
    }
}
