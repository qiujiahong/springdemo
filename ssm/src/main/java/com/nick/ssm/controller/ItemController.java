package com.nick.ssm.controller;


import com.nick.ssm.exception.CustomExcetion;
import com.nick.ssm.po.Item;
import com.nick.ssm.service.ItemService;
import com.nick.ssm.vo.ItemQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RequestMapping(value="item",produces = "application/json;charset=utf8")
@Controller
public class ItemController {

    @Autowired
    private ItemService service;

    //    @RequestMapping("queryItem")
//    public ModelAndView queryItem(){
//        List<Item> itemList = service.queryItemList();
//        ModelAndView modelAndView= new ModelAndView();
//        modelAndView.addObject("itemList",itemList);
//        modelAndView.setViewName("item/item-list");
//        return modelAndView;
//    }
    @RequestMapping("queryItem")
    public String queryItem(HttpServletRequest request , Model model) throws CustomExcetion {
        List<Item> itemList = service.queryItemList();
        model.addAttribute("itemList",itemList);
        if (itemList.size() < 10) {
            throw new CustomExcetion("我是自定义异常类");
        }
        System.out.println("执行...");
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
        Item item =  service.queryItemById(1);
        return item;
    }

    //http://localhost:8080/ssm/item/findItem?id=1
//    @ResponseBody
//    @RequestMapping("findItem")
//    public String findItem( Integer id){  //参数一致可以直接写，不一致可以加注解翻译
//        return "接收到的参数是:"+id;
//    }
    //http://localhost:8080/ssm/item/findItem?itemId=1
//    public String findItem(@RequestParam("itemId") Integer id){
//        return "接收到的参数是:"+id;
//    }

    //http://localhost:8080/ssm/item/findItem?itemId=1
//    public String findItem(@RequestParam(value = "itemId",required = false,defaultValue = "8") Integer id){
//        return "接收到的参数是:"+id;
//    }

    //传递POJO对象
    //http://localhost:8080/ssm/item/updateItem?id=1&name=iphone&price=100
//    @RequestMapping("updateItem")
//    @ResponseBody
//    public Item updateItem(Integer id ,String name,Double price,Item item){
//        return item;
//    }

//    http://localhost:8080/ssm/item/showEdit?id=1
    @RequestMapping("showEdit")
    public String showEdit(Integer id,Model model) {
        try{

            Item item = service.queryItemById(id);

            model.addAttribute("item", item);

            return "item/item-edit";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("updateItem")
    @ResponseBody
    public Item updateItem(Integer id, String name, Float price, Item item, MultipartFile pictureFile) throws Exception{
        if (pictureFile != null) {
            //获取上传文件名称
            String originalFilename = pictureFile.getOriginalFilename();
            if (originalFilename != null && !"".contentEquals(originalFilename)) {
                //获取扩展名
                String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
                //重新生成一个文件名称
                String newFileName = UUID.randomUUID().toString()+extName;
                //指定存储文件的根目录
                String baseDir="E:\\07-upload\\temp\\";
                File dirFile=new File(baseDir);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                //将上传的文件复制到新的文件(完整路径)中
                pictureFile.transferTo(new File(baseDir + newFileName));

                //保存文件路径
                item.setPic(newFileName);
            }
        }

        //商品修改
        service.updateItem(item);

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


    //自定义转换器
    //http://localhost:8080/ssm/item/saveItem?date=2018-12-10
    @RequestMapping("saveItem")
    @ResponseBody
    public Date saveItem(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return date;
    }



    //ResponseBody -- 请求是json
    //RequestBody  -- 响应是json
    //客户端保证发送的数据是json数据需要传送contentType: 'application/json;charset=utf-8'
    @ResponseBody
    @RequestMapping("/requetstJson")
    public Item requestJson(@RequestBody Item item){
        return item;
    }

    @RequestMapping("findItem")
    @ResponseBody
    public Item findItem( Integer id) {
        return service.queryItemById(id);
    }
}
