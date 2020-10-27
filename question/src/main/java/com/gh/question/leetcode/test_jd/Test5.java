package com.gh.question.leetcode.test_jd;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.createTargetArray(new int[]{0,1,2,3,4},new int[]{0,1,2,2,1});
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[index.length];
        for(int i=0;i<index.length;i++){
            if(index[i]<i){
                //插入操作
                for(int j=i;j>index[i];j--){
                    target[j] = target[j-1];
                }
                target[index[i]] = nums[i];
            }else{
                target[i] = nums[i];
            }
            System.out.println(Arrays.toString(target));
        }
        return target;
    }
}
