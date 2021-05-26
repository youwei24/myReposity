package com.fawvw.zheda.character1;

import com.alibaba.fastjson.JSONArray;

import java.util.LinkedList;

public class TestLamda {
    public static void main(String[] args) {
        String jsonObj =  "[[\"子模块编号\",\"子模块名称\"],[\"RM_MODULE_HEALTHCHECKER\",\"健康检查模块\"]]";
        JSONArray arr = JSONArray.parseArray(jsonObj);
        System.out.println(arr);
        for (int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
//            JSONArray data = JSON.parseArray((String) arr.get(i));
            System.out.println(arr.getJSONArray(i).get(0));
        }
        LinkedList<String > list = new LinkedList<String>();
        //lamda表达式应用
        //lamda表达式的方便在于：不需要定义变量接收x的值
        list.forEach(x -> {
            x=x+"hello world";
        });
    }
}
