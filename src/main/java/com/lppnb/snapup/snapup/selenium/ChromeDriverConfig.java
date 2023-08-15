package com.lppnb.snapup.snapup.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ChromeDriverConfig {
    @Bean
    public ChromeDriver driver() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");// 窗口最大化
        options.addArguments("--remote-allow-origins=*");// 解决 403 出错问题
        options.addArguments("--headless");// 无头化
        options.addArguments("--window-size=1920,1080");// 防止浏览器渲染后元素之间遮挡，这里直接给个比较大的窗口大小
        options.addArguments("--blink-settings=imagesEnabled=false"); // 禁用图片加载
        ChromeDriver driver = new ChromeDriver(options);
        //页面加载超时时间设置为 5s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //定位对象时给 10s 的时间, 如果 10s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
