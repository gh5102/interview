package com.gh.question.leetcode.test_jd;

public class Test6 {
    public int findLucky(int[] arr) {
        int max = -1;
        int count = 0;
        int temp = 0;
        for(int i=0;i<arr.length;i++){
            temp = arr[i];
            for(int j=0;j<arr.length;j++){
                if(temp==arr[j]){
                    count++;
                }
            }
            if(temp == count){
                if(temp>max){
                    max = temp;
                }
            }
        }
        return max;
    }
}
