package com.su.service.impl;


import com.su.dao.api.ItemDao;
import com.su.domain.Item;
import com.su.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getAll() {
        return itemDao.getAll();
    }

    @Override
    public Item createItem(String title, String description) {
        Item item = new Item(title, description);
        itemDao.add(item);
        return item;
    }
}
