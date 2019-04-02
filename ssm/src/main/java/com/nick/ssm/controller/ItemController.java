package com.nick.ssm.controller;


import com.nick.ssm.po.Item;
import com.nick.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    //    @RequestMapping("queryItem")
//    public ModelAndView queryItem(){
//        List<Item> itemList = itemService.queryItemList();
//        ModelAndView modelAndView= new ModelAndView();
//        modelAndView.addObject("itemList",itemList);
//        modelAndView.setViewName("item/item-list");
//        return modelAndView;
//    }
    @RequestMapping("queryItem")
    public String queryItem(HttpServletRequest request , Model model) {
        List<Item> itemList = itemService.queryItemList();
        model.addAttribute("itemList",itemList);
        return "item/item-list";
        //    return "redirect:testRedirect";   //重定向  浏览器URL发生改变，Request域不能共享
    //    return "forward:testForward";     //转发  Request域共享
    }

    @RequestMapping("testRedirect")
    public String testRedirect(HttpServletRequest request ) {
        Object itemList = request.getAttribute("itemList");//不能获取到对象
        System.out.println(itemList);
        return "item/item-list";
    }
    @RequestMapping("testForward")
    public String testForward(HttpServletRequest request ) {
        Object itemList = request.getAttribute("itemList");//能获取到对象
        System.out.println(itemList);
        return "item/item-list";
    }

    @ResponseBody
    @RequestMapping("queryItemById")
    public Item queryItemById(){
        Item item =  itemService.queryItemById(1);
        return item;
    }


}
