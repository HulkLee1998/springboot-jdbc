package com.hulk.springbootjdbc.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        final List<Map<String, Object>> list =  jdbcTemplate.queryForList("select * FROM department");

        return list.get(0);
    }

    @ResponseBody
    @GetMapping("/json")
    public JSONObject json(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value","hulk");
        return jsonObject;
    }



    @GetMapping("/api")
    public String getApi(){
        return "laoxu.html";
    }
}
