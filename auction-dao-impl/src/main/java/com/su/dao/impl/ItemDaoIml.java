package com.su.dao.impl;

import com.su.dao.api.ItemDao;
import com.su.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoIml implements ItemDao {
    private List<Item> items = new ArrayList<>();

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void add(Item entity) {
        items.add(entity);
    }

    @Override
    public void remote(Item entity) {
        items.remove(entity);
    }
}
