package com.gh.question.leetcode.test_mid;

/**
 * 两数相除
 * @author guohao
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(test3.divide(-1010369383, -2147483648));
        //2147483647

    }

    /**
     * 用位移运算符
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        long dividendTemp = dividend;
        long divisorTemp = divisor;
        if(dividend == 0){
            return 0;
        }
        //是否为负数
        //处理正否数问题
        boolean flag = false;
        if(dividendTemp>0&&divisorTemp>0){
            flag = false;
        }else if(dividendTemp<0&&divisorTemp<0){
            dividendTemp = -dividendTemp;
            divisorTemp = -divisorTemp;
        }else if(dividendTemp<0){
            dividendTemp = -dividendTemp;
            flag = true;
        }else{
            divisorTemp = -divisorTemp;
            flag = true;
        }
        //除数补0操作
        //准备
        long retNum = 0;
        long temp = divisorTemp;
        //除数
        while (dividendTemp > divisorTemp) {
            divisorTemp = divisorTemp << 1;
            //int越界（除数）
        }
        //计算
        while (divisorTemp>=temp) {
            retNum = retNum << 1;
            int t = (dividendTemp >= divisorTemp ? 1 : 0);
            retNum += t;
            dividendTemp = dividendTemp >= divisorTemp ? dividendTemp - divisorTemp : dividendTemp;
            divisorTemp = divisorTemp >> 1;
        }
        //处理int越界问题(被除数)

        if(flag){
            if(-retNum<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                return -(int)retNum;
            }
        }else{
            if(retNum>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int)retNum;
            }
        }
        //return (int)retNum;
    }
}
