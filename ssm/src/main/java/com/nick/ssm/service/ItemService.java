package com.nick.ssm.service;

import com.nick.ssm.po.Item;

import java.util.List;

public interface ItemService {
    List<Item> queryItemList();
    Item queryItemById(Integer id);
    void updateItem(Item item);
    void login(String str);
}
