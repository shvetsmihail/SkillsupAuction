package com.su.dao.impl;

import com.su.dao.api.LotDao;
import com.su.domain.Lot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LotDaoIml implements LotDao {
    private List<Lot> lots = new ArrayList<>();

    @Override
    public List<Lot> getAll() {
        return lots;
    }

    @Override
    public void add(Lot entity) {
        lots.add(entity);
    }

    @Override
    public void remote(Lot entity) {
        lots.remove(entity);
    }
}
