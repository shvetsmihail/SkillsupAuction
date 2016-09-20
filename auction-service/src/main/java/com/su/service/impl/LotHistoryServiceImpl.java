package com.su.service.impl;


import com.su.dao.api.LotHistoryDao;
import com.su.domain.Lot;
import com.su.domain.LotHistory;
import com.su.domain.User;
import com.su.service.LotHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class LotHistoryServiceImpl implements LotHistoryService {

    @Autowired
    private LotHistoryDao lotHistoryDao;

    @Override
    public List<LotHistory> getAll() {
        return lotHistoryDao.getAll();
    }

    @Override
    public LotHistory createLotHistory(Lot lot, User user, BigDecimal price) {
        LotHistory lotHistory = new LotHistory(lot, user, price);
        lotHistoryDao.add(lotHistory);
        return lotHistory;
    }
}
