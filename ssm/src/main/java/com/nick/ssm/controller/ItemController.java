package com.nick.ssm.controller;


import com.nick.ssm.po.Item;
import com.nick.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("queryItem")
    public ModelAndView queryItem(){
        List<Item> itemList = itemService.queryItemList();
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("itemList",itemList);
        modelAndView.setViewName("item/item-list");
        return modelAndView;
    }
}
