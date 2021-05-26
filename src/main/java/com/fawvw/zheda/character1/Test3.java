package com.fawvw.zheda.character1;

import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test3 {
//    最大子列和问题
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        str = br.readLine();
        String[] stringArray = str.split(" ");
//        System.out.println(str);
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
//            System.out.println(intArray[i]);
        }
        System.out.println(getSeqSumMax(intArray));
    }

    public static int getSeqSumMax(int[] array) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < array.length; i++) {
            thisSum += array[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        if (maxSum < 0) {
            return 0;
        }
        return maxSum;
    }
}
