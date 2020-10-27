package com.gh.question.leetcode.test_mid;

/**
 * 两数相除
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(test3.divide(-2147483648, -1));
    }
    public int divide(int dividend, int divisor) {
        int flag = 0;
        if(dividend>0){
            flag +=1;
        }else{
            dividend= Math.abs(dividend);
            flag-=1;
        }
        if(divisor>0){
            flag+=1;
        }else {
            divisor = -divisor;
            flag-=1;
        }
        int count = 0;
        while (dividend>=divisor){
            dividend-=divisor;
            count++;
        }
        if(flag == 0){
            count = -count;
        }
        return count;
    }
}
