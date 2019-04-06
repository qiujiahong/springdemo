package com.nick.ssm.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


//WebAppConfiguration 可以在单元测试的时候不用启动servlet容器就能获得一个应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
@WebAppConfiguration
public class TestMockMVC {


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        //初始化一个mvc对象
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    //    http://localhost:8080/ssm/item/showEdit?id=1
    @Test
    public void test() throws Exception {
        //perform发送一个http请求
        //andExpect判断请求是否成功
        //        MockMvcResultMatchers.view().name()
        //andDo 对请求结果进行输出

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/item/showEdit").param("id", "1"))
                .andExpect(MockMvcResultMatchers.view().name("item/showEdit"))
//                .andExpect(MockMvcResultMatchers.view().name("item/item-edit"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("==========================");
        System.out.println(result.getHandler());
    }

    @Test
    public void test2() throws Exception {
        // 通过perform去发送一个HTTP请求
        // andExpect：通过该方法，判断请求执行是否成功
        // andDo :对请求之后的结果进行输出
        String responseString  = mockMvc.perform(
                MockMvcRequestBuilders.get("/item/findItem")
                        .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("================================");
        System.out.println(responseString);
    }
}
