package com.nick.ssm.controller;


import com.nick.ssm.po.Item;
import com.nick.ssm.service.ItemService;
import com.nick.ssm.vo.ItemQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping(value="item",produces = "application/json;charset=utf8")
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

    //http://localhost:8080/ssm/item/findItem?id=1
    @ResponseBody
    @RequestMapping("findItem")
//    public String findItem( Integer id){  //参数一致可以直接写，不一致可以加注解翻译
//        return "接收到的参数是:"+id;
//    }
    //http://localhost:8080/ssm/item/findItem?itemId=1
//    public String findItem(@RequestParam("itemId") Integer id){
//        return "接收到的参数是:"+id;
//    }

    public String findItem(@RequestParam(value = "itemId",required = false,defaultValue = "8") Integer id){
        return "接收到的参数是:"+id;
    }

    //传递POJO对象
    //http://localhost:8080/ssm/item/updateItem?id=1&name=iphone&price=100
    @RequestMapping("updateItem")
    @ResponseBody
    public Item updateItem(Integer id ,String name,Double price,Item item){
        return item;
    }

    //传递嵌套pojo对象
    //http://localhost:8080/ssm/item/queryItem1?item.id=1&item.name=iphone&item.price=1000
    @ResponseBody
    @RequestMapping("queryItem1")
    public Item queryItem1(ItemQueryVO vo){
        return vo.getItem();
    }

    //传递数组
    //http://localhost:8080/ssm/item/deleteItem?id=1&id=2&id=3
    @ResponseBody
    @RequestMapping("deleteItem")
    public Integer[] deleteItem(Integer[] id){
        return id;
    }

    //传递pojo数组
    //http://localhost:8080/ssm/item/batchUpdateItem?itemList[0].id=1&itemList[0].name=iphone&itemList[0].price=100&itemList[1].id=2&itemList[1].name=hua wei&itemList[1].price=200
    @ResponseBody
    @RequestMapping("batchUpdateItem")
    public ItemQueryVO  batchUpdateItem(ItemQueryVO vo){
        return vo;
    }
}
