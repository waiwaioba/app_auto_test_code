package com.lemon.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jTest {
    private Logger logger = Logger.getLogger(Log4jTest.class);
    @Test
    public void test(){
        logger.debug("记录debug级别的日志");
        logger.info("记录info级别的日志");
        logger.warn("记录warn级别的日志");
        logger.error("记录eror级别的日志");
    }
}
