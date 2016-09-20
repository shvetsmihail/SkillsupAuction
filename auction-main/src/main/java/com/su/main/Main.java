package com.su.main;

import com.su.domain.Lot;
import com.su.domain.User;
import com.su.service.AuctionService;
import com.su.service.ItemService;
import com.su.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config.xml");
        AuctionService auctionService = context.getBean(AuctionService.class);
        ItemService itemService = context.getBean(ItemService.class);
        UserService userService = context.getBean(UserService.class);





//        1. Создать несколько User’ов
//        2. Создать несколько Item’ов
//        3. Один пользователей создает лот
//        4. Несколько других пользователей делают ставки
//        5. Закрываем лот
//        6. Выводим в консоль имя победителя торгов

        //Create lots
        auctionService.createLot(
                itemService.createItem("Ford Fiesta", "Type: car, Year: 2012, Color: blue"),
                userService.createUser("semmi", "Sem", "Stinson"),
                new BigDecimal(25000));

        auctionService.createLot(
                itemService.createItem("Opel Astra", "Type: car, Year: 2008, Color: white"),
                userService.createUser("jakl", "Jack", "Long"),
                new BigDecimal(25000));

        System.out.println("Today ve have next lots:");
        int i = 1;
        for (Lot lot : auctionService.getActiveLots()){
            System.out.println("lot number " + i++);
            System.out.println(lot);
            System.out.println("Members:");
            List<User> members =  userService.getAll().stream().filter(user -> user != lot.getOwner()).collect(Collectors.toList());

            for (User member : members){
                System.out.println("id=" + members.indexOf(member)+ " , " + member);
            }

            System.out.println("You have next action:");
            System.out.println("to do a raise you must say: 'UserId' 'New prise(optional)'");
            System.out.println("to close lot, print 'close'");
            String action = null;
            while (true){
                action=reader.readLine();
                if (action.equals("close")) break;
                String[] actions = action.split(" ");
                User member = members.get(Integer.parseInt(actions[0]));

                if (actions.length == 1){
                    auctionService.placeBid(lot, member);
                    System.out.println(member + "do a raise. Current prise is " + lot.getCurrentPrice());

                }
                else {
                    BigDecimal newPrice = BigDecimal.valueOf(Integer.parseInt(actions[1]));
                    auctionService.placeBid(lot, member, newPrice);
                    System.out.println(member + "do a raise. Current prise is " + lot.getCurrentPrice());
                }
            }
            System.out.println("The winner is " + lot.getBuyer() + "Current prise is " + lot.getCurrentPrice());
        }







    }

}
