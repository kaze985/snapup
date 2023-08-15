package com.lppnb.snapup.snapup.selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
@Slf4j
public class SeleniumSnapupTask {
    @Resource
    private ChromeDriver driver;

    @PostConstruct
    public void login() throws InterruptedException {
        log.info("开始登录");
        driver.get("https://pass.cctalk.com/login.aspx?url=https%3A%2F%2Fwww.cctalk.com%2Fm%2Fgroup%2F90928519%3Fxh_fshareuid%3D166115258");
        // 账号密码登录
        driver.findElement(By.cssSelector("#hp-pass-box > div > div.hp-main-oauth > button.hp-button-text.hp-button-cc.hp-login-btn.hp-account-login")).click();
        // 输入账号
        driver.findElement(By.cssSelector("#nameInput")).sendKeys("18836215105");
        // 输入密码
        driver.findElement(By.cssSelector("#passInput")).sendKeys("LPP9817815");
        Thread.sleep(1000);
        // 同意协议
        driver.findElement(By.cssSelector("#hp-pass-box > div > div.hp-login-account > div.agree-container > div > button > i")).click();
        Thread.sleep(1000);
        // 登录
        driver.findElement(By.cssSelector("#hp-pass-box > div > div.hp-login-account > button")).click();
        log.info("登录成功");
    }

    @Scheduled(cron = "00 20 19 * * *")
    public void snapUp() throws InterruptedException {
        long start = System.currentTimeMillis();

        log.info("开始抢购");

        // 立即报名
        driver.findElement(By.cssSelector("#root > div.bar-wrapper_36L7 > div.bar-main_84iB > div")).click();
        log.info("立即报名");

        // 同意协议
        WebElement element = driver.findElement(By.cssSelector("#root > div.agreement_1PQa > label > span.ui-checkbox-input > span"));
        //浏览器渲染后按钮被别的东西遮挡，可以通过js代码触发按钮
//        driver.executeScript("arguments[0].click();", element);
        element.click();
        log.info("同意协议");

        // 立即支付
        driver.findElement(By.cssSelector("#root > div.pay-button-wrap_x1Fr > div.pay-button_rLeU")).click();
        log.info("立即支付");

        log.info("抢购完毕");

        long end = System.currentTimeMillis();
        log.info("抢购共用时：{}ms", (end - start));
        Thread.sleep(3000);
    }
}
