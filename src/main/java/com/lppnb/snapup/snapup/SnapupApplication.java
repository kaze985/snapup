package com.lppnb.snapup.snapup;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class SnapupApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnapupApplication.class, args);
    }

}
