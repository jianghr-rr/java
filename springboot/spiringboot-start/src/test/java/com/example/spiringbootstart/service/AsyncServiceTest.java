package com.example.spiringbootstart.service;

import com.example.spiringbootstart.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {
    @Autowired
    private AsyncService asyncService;

    @Test
    public void  testAsyncProcess() throws InterruptedException {
        asyncService.asyncProcess();
        log.info("coming in testAsyncProcess");
    }

    @Test
    public void  testAsyncProcessHasReturn() throws Exception {
        long start = System.currentTimeMillis();
        Future<Integer> result = asyncService.asyncProcessReturn();

        log.info("get async task value: {}", result.get(1, TimeUnit.SECONDS));
        log.info("time elapse for async task: {}ms", System.currentTimeMillis()-start);
    }
}
