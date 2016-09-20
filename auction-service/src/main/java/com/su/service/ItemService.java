package com.su.service;


import com.su.domain.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();
    Item createItem(String title, String description);
}
