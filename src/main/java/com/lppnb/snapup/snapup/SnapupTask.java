package com.lppnb.snapup.snapup;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class SnapupTask {
    @Resource
    private ChromeDriver driver;

    @PostConstruct
    public void login() throws InterruptedException {
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
    }

    @Scheduled(cron = "0 20 19 * * *")
    public void snapUp() {
        // 立即报名
        driver.findElement(By.cssSelector("#root > div.bar-wrapper_36L7 > div.bar-main_84iB > div")).click();
        // 同意协议
        driver.findElement(By.cssSelector("#root > div.agreement_1PQa > label > span.ui-checkbox-input > span")).click();
        // 立即支付
        driver.findElement(By.cssSelector("#root > div.pay-button-wrap_x1Fr > div.pay-button_rLeU")).click();
        // 支付宝支付
        driver.findElement(By.cssSelector("#root > div.main-container > div.paynow-wrapper > a")).click();
    }
}
