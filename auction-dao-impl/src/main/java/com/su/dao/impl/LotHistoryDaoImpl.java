package com.su.dao.impl;


import com.su.dao.api.LotHistoryDao;
import com.su.domain.LotHistory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LotHistoryDaoImpl implements LotHistoryDao {
    private List<LotHistory> lotHistories = new ArrayList<>();

    @Override
    public List<LotHistory> getAll() {
        return lotHistories;
    }

    @Override
    public void add(LotHistory entity) {
        lotHistories.add(entity);
    }

    @Override
    public void remote(LotHistory entity) {
        lotHistories.remove(entity);
    }
}
