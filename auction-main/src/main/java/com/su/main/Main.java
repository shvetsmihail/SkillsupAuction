package com.su.main;

import com.su.service.AuctionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config.xml");
        AuctionService service = context.getBean(AuctionService.class);

        System.out.println("Users:" + service.getUsers().size());
    }
}
