package com.nick.ssm.vo;

import com.nick.ssm.po.Item;

import java.util.List;


public class ItemQueryVO {
    private Item item;


    private List<Item> itemList;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
