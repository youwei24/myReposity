package com.fawvw.zheda.character1;

import java.util.Date;

public class Test1 {
//    递归与循环打印n个数对比
    public static void main(String[] args) {
        int i = 10000;
        long startTime = System.currentTimeMillis();
        printNum(i);
//        printNumFor(i);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime - startTime)+" ms");
    }

    public static void printNum(int i){
        if (i > 0) {
            printNum( i-1 );
            System.out.println(i);
        } else {
            System.out.println(i);
        }
    }
    public static void printNumFor(int i){
        for (int j = 0; j < i; j++) {
            System.out.println(j);
        }
    }


}
