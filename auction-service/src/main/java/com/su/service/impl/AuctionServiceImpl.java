package com.su.service.impl;

import com.su.dao.api.LotDao;
import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;
import com.su.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuctionServiceImpl implements AuctionService {

    private BigDecimal minPercentRaise = BigDecimal.valueOf(1.1);

    @Autowired
    private LotDao lotDao;

    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        Lot lot = new Lot(item, user, startPrice);
        lotDao.add(lot);
        return lot;
    }

    @Override
    public List<Lot> getActiveLots() {
        return lotDao.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    @Override
    public void placeBid(Lot lot, User user) {
        if (lot.getCurrentPrice() == null){
            lot.setCurrentPrice(lot.getStartPrice());
        } else {
            lot.setCurrentPrice(lot.getCurrentPrice().multiply(minPercentRaise).setScale(0, BigDecimal.ROUND_UP));
        }
        lot.setBuyer(user);
    }

    @Override
    public void placeBid(Lot lot, User user, BigDecimal newPrice) {
        if (lot.getCurrentPrice() == null){
            if (newPrice.compareTo(lot.getStartPrice()) >= 0){
                lot.setCurrentPrice(newPrice);
                lot.setBuyer(user);
            }
        } else {
            if (newPrice.compareTo(lot.getCurrentPrice()) == 1){
                lot.setCurrentPrice(newPrice);
                lot.setBuyer(user);
            }
        }
    }

    @Override
    public Lot closeLot(Lot lot) {
        lot.setDateEnd(new Date());
        return lot;
    }

    public void setLotDao(LotDao lotDao) {
        this.lotDao = lotDao;
    }
}
