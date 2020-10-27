package com.gh.question.leetcode.test_jd;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        boolean flag2 = true;
        for(int i=0;i<matrix.length;i++){
            flag = true;
            flag2 = true;
            for(int j=0;j<matrix[i].length;j++){
                for(int k=0;k<matrix.length;k++){
                    if(matrix[i][j]<matrix[(i+k)%matrix.length][j]){
                        flag = false;
                        break;
                    }
                }
                for(int m=0;m<matrix[i].length;m++){
                    if(matrix[i][j]>matrix[i][(j+m)%matrix[i].length]){
                        flag2 = false;
                        break;
                    }
                }
                if(flag&&flag2){
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }

    public List<Integer> luckyNumbers2 (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int min = 0;
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < matrix.length ; i++) {
            flag = true;
            min = matrix[i][0];
            index = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]<min){
                    min = matrix[i][j];
                    index = j;
                }
            }
            for(int m=1;m<matrix.length;m++){
                if(matrix[(i+m)%matrix.length][index]>matrix[i][index]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(matrix[i][index]);
            }
        }
       return list;
    }

}
