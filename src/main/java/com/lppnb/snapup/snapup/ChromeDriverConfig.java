package com.lppnb.snapup.snapup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ChromeDriverConfig {
    @Bean
    public ChromeDriver driver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //解决 403 出错问题
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        //页面加载超时时间设置为 5s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //定位对象时给 10s 的时间, 如果 10s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
