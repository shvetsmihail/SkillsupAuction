package com.su.service;

import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;

import java.math.BigDecimal;
import java.util.List;

public interface AuctionService {
    /**
     *
     * @param item - item for auction
     * @param user - user that starts auction
     * @param startPrice - his start price
     * @return created lot
     */
    Lot createLot(Item item, User user, BigDecimal startPrice);

    /**
     * Returns all lots that has no end date yet
     * @return lots
     */
    List<Lot> getActiveLots();

    /**
     * Returns all registered users
     * @return users
     */
    List<User> getUsers();


}
