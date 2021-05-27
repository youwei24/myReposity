package com.fawvw.zheda.character1;

import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestLambda {
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

        long count = arrayList.stream().filter(w -> w.length()>4).count();
        //并行执行
        long count2 = arrayList.parallelStream().filter(w -> w.length()>4).count();
        System.out.println(count+","+count2);
        //一个包含100个随机数字的流
        Stream<Double> randoms = Stream.generate(Math::random).limit(10);
        System.out.println(randoms.collect(Collectors.toList()));
        //distinct方法会根据原始流中的元素返回一个具有相同顺序、抑制了重复元素的心流。显然，该流必须记住之前已读取的元素
        Stream<String> uniqueWords = Stream.of("one","one","one","two","two").distinct();
        System.out.println(uniqueWords.collect(Collectors.joining("、")));//只输出one，two两个单词
        //sorted排序
        Stream<String> sortedWords = Stream.of("1","one","three","on","two","finger").sorted(Comparator.comparing(String::length).reversed());
        System.out.println(sortedWords.collect(Collectors.toList()));
        //聚合方法count、max、min
        Stream<String> words = Stream.of("1","one","three","on","two","finger");
        Optional<String> max = words.max(String::compareToIgnoreCase);
        if (max.isPresent()){
            System.out.println("largest:"+max.get());
        }
        //filter与findFirst相结合
        words = Stream.of("1","one","three","on","two","finger");
        Optional<String> startWithO = words.filter(s -> s.startsWith("o")).findFirst();
        System.out.println("startWithO the first:"+startWithO.get());
        //findAny与parellel、filter相结合，并行执行时只要在任何片段中发现了第一个匹配元素，都会结束整个计算
        words = Stream.of("1","one","three","on","two","finger");
        Optional<String> startWithOALL = words.parallel().filter(s -> s.startsWith("n")).findAny();
        if (startWithOALL.isPresent()){
            System.out.println("startWithO the all:"+startWithOALL.get());
        }
        //Optional计算反转值的平方根
        Optional<Double> optionalDouble = inverse(0.01).flatMap(TestLambda::squareRoot);
        if (optionalDouble.isPresent()){
            System.out.println("optionalDouble:"+optionalDouble.get());
        }
        //聚合方法求sum
        IntStream values = IntStream.of(1,3,99,20);
        OptionalInt sum = values.reduce((x, y) -> x + y);
        if (sum.isPresent()){
            System.out.println("sum:"+sum.getAsInt());
        }
        //流中包含字符串以外的对象，先将他们转换为字符串，然后以，为间隔拼在一起，组成一个string
        Stream<Integer> values2 = Stream.of(1,3,99,20);
        String result = values2.map(Object::toString).collect(Collectors.joining(","));
        System.out.println("拼接成字符串为："+result);
    }
    public static String change(String str){
        return str+"1";
    }
    public static Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty():Optional.of(1/x);
    }
    public static Optional<Double> squareRoot(Double x){
        return x < 0 ? Optional.empty():Optional.of(Math.sqrt(x));
    }


}
