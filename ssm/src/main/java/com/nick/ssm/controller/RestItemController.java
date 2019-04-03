package com.nick.ssm.controller;

import com.nick.ssm.po.Item;
import com.nick.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestItemController {
    @Autowired
    private ItemService service;

    @RequestMapping("queryItemByIdWithRest")
    public Item queryItemById() {
        Item item = service.queryItemById(1);
        return item;
    }

    @RequestMapping("testReturnStringWithRest")
    public String testReturnString() {
        return "ok";
    }

}
