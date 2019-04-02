package com.nick.ssm.service;

import com.nick.ssm.mapper.ItemMapper;
import com.nick.ssm.po.Item;
import com.nick.ssm.po.ItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    /***
     * 使用逆向工程代码完成持久层查询
     * @return
     */
    @Override
    public List<Item> queryItemList() {
        ItemExample itemExample = new ItemExample();
//        ItemExample.Criteria criteria =  itemExample.createCriteria();
        List<Item> items = itemMapper.selectByExample(itemExample);
        return items;
    }

    @Override
    public Item queryItemById(Integer id) {
        if(id == null)
            return null;
        return itemMapper.selectByPrimaryKey(id);
    }
}
