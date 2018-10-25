package com.wang.sell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    //    final static Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1() {

        String name = "wpt";
        String pass = "12345";
        log.info("iiiiiiinfo");
        log.debug("dddddebug");
        log.error("eeeeerror");
        log.info("name:{}---pass:{}",name,pass);
    }
}
