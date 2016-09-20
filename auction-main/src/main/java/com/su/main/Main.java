package com.su.main;

import com.su.domain.Lot;
import com.su.domain.User;
import com.su.service.AuctionService;
import com.su.service.ItemService;
import com.su.service.LotHistoryService;
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
        LotHistoryService lotHistoryService = context.getBean(LotHistoryService.class);

        auctionService.createLot(
                itemService.createItem("Ford Fiesta", "car, 2012, blue"),
                userService.createUser("semmi", "Sem", "Stinson"),
                new BigDecimal(25000));

        auctionService.createLot(
                itemService.createItem("Opel Astra", "car, 2008, white"),
                userService.createUser("jakl", "Jack", "Long"),
                new BigDecimal(13000));

        for (Lot lot : auctionService.getActiveLots()){
            System.out.println(lot);
            System.out.println("Members:");
            List<User> members =  userService.getAll().stream().filter(user -> user != lot.getOwner()).collect(Collectors.toList());

            for (User member : members){
                System.out.println("id=" + members.indexOf(member)+ ", " + member);
            }

            System.out.println("You have next actions:");
            System.out.println("to do a raise you must say: 'UserId' 'New prise(optional)'");
            System.out.println("to close lot, print 'close'");

            String action;
            while (true){
                action = reader.readLine();
                if (action.equals("close")) break;
                String[] actions = action.split(" ");

                int userId;
                BigDecimal newPrice = null;

                try{
                    userId = Integer.parseInt(actions[0]);
                    if (actions.length == 2){
                        newPrice = BigDecimal.valueOf(Double.parseDouble(actions[1])).setScale(0, BigDecimal.ROUND_UP);
                    }
                    if (userId > (members.size()-1) || userId < 0) throw new Exception();
                } catch (Exception e){
                    System.out.println("Wrong information. Try again");
                    continue;
                }

                User member = members.get(userId);
                if (newPrice == null){
                    auctionService.placeBid(lot, member);
                    lotHistoryService.createLotHistory(lot, member, lot.getCurrentPrice());
                } else {
                    auctionService.placeBid(lot, member, newPrice);
                    lotHistoryService.createLotHistory(lot, member, newPrice);
                }

                System.out.println(member + " did a raise. Current price is " + lot.getCurrentPrice() + ". Current owner is: " + lot.getBuyer());
            }
            System.out.println("The winner is " + lot.getBuyer() + ". Current price is " + lot.getCurrentPrice());
            System.out.println("-------------------------------");
        }

        lotHistoryService.getAll().forEach(System.out::println);
    }

}
