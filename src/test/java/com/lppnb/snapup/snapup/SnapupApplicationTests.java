package com.lppnb.snapup.snapup;


import com.lppnb.snapup.snapup.htmlunit.HtmlUnitSnapupTask;
import com.lppnb.snapup.snapup.selenium.SeleniumSnapupTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
@Slf4j
class SnapupApplicationTests {
    @Resource
    private SeleniumSnapupTask seleniumSnapupTask;
    @Test
    void testSelenium() throws InterruptedException {
        long start = System.currentTimeMillis();
        seleniumSnapupTask.snapUp();
        long end = System.currentTimeMillis();
        log.info("抢购共用时：{}ms", (end - start));
        Thread.sleep(3000);
    }

    @Test
    void testHtmlUnit() {
        new HtmlUnitSnapupTask().execute();
    }
}
