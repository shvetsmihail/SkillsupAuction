package com.su.service;


import com.su.domain.Lot;
import com.su.domain.LotHistory;
import com.su.domain.User;

import java.math.BigDecimal;
import java.util.List;

public interface LotHistoryService {
    List<LotHistory> getAll();
    LotHistory createLotHistory(Lot lot, User user, BigDecimal price);
}
