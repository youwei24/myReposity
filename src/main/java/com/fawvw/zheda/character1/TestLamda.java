package com.fawvw.zheda.character1;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TestLamda {
    public static void main(String[] args) {
//        String jsonObj =  "[[\"子模块编号\",\"子模块名称\"],[\"RM_MODULE_HEALTHCHECKER\",\"健康检查模块\"]]";
//        JSONArray arr = JSONArray.parseArray(jsonObj);
//        System.out.println(arr);
//        for (int i=0;i<arr.size();i++){
//            System.out.println(arr.get(i));
////            JSONArray data = JSON.parseArray((String) arr.get(i));
//            System.out.println(arr.getJSONArray(i).get(0));
//        }
        ArrayList<String > list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        //lamda表达式应用
        //lamda表达式的方便在于：不需要定义变量接收x的值

        list.forEach(x -> {//list.forEach()无返回值
            x=x+"2";
            System.out.println(x);
            if (x.equals("three2")){return;}//通过return、break无法跳出循环，是个bug
        });
        //list对象通过处理重新转成另一个对象的list
        List<String> arrayList= list.stream().map(x -> change(x)).collect(Collectors.toList());
        System.out.println("arrayList:"+arrayList);
        System.out.println(list);
    }
    public static String change(String str){
        return str+"1";
    }
}
