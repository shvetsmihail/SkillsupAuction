package com.su.service.impl;

import com.su.dao.api.LotDao;
import com.su.dao.api.UserDao;
import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;
import com.su.service.AuctionService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class AuctionServiceImp implements AuctionService {
    private UserDao userDao;
    private LotDao lotDao;

    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        Lot lot = new Lot();
        lot.setItem(item);
        lot.setOwner(user);
        lot.setCurrentPrice(startPrice);
        lot.setDatePlaced(new Date());
        return lot;
    }

    @Override
    public List<Lot> getActiveLots() {
        return lotDao.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setLotDao(LotDao lotDao) {
        this.lotDao = lotDao;
    }
}
