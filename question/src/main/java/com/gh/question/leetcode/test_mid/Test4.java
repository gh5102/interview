package com.gh.question.leetcode.test_mid;

import java.util.Arrays;

/**
 * @author guohao
 */
public class Test4 {

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        /*
        * "RRU"
           [[5, 5], [9, 4], [9, 7], [6, 4], [7, 0], [9, 5], [10, 7], [1, 1], [7, 5]]
           1486
           743
        * */
        System.out.println(test4.robot("RRU", new int[][]{{5, 5},{9,4},{9,7},{6,4},{7,0},{9,5},{10,7},{1,1},{7,5}}, 1486, 763));
    }

    /**
     *
     * @param command
     * @param obstacles
     * @param x
     * @param y
     * @return
     */
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        //步骤
        char[] chars = command.toCharArray();
        //起点,r向上,u向右
        int r=0,u=0;
        //判断是否成功
        boolean flag = false;
        //路径
        int[][] temp = new int[x+1][y+1];
        //第一轮
        temp[0][0] = 1;
        for (int i = 0; i < chars.length; i++) {
            //R横向移动
            if(chars[i] == 'R'){
                u++;
            }else{
                r++;
            }
            //第一轮就越界时
            if(u>x||r>y){
                break;
            }
            temp[u][r] = 1;
        }
        for (int i = 0; i <=x; i++) {
            for (int j = 0; j <=y; j++) {
                System.out.printf("%d\t",temp[i][j]);
            }
            System.out.println();
        }
        //所有轮
        //u=1,i=2;
        int count = 0;
        for (int i = 0; i <= x; i++) {
            if(i<u){
                continue;
            }
            for (int j = 0; j <= y; j++) {
                if(j<r){
                    continue;
                }
                temp[i][j] = temp[i-u][j-r];
            }
            if(i==u*2+1){
                r = 2*r-1;
                u = 2*u-1;
            }

        }
        System.out.println("-----------------------");
        for (int i = 0; i <=x; i++) {
            for (int j = 0; j <=y; j++) {
                System.out.printf("%d\t",temp[i][j]);
            }
            System.out.println();
        }
        if(temp[x][y] == 1){
            flag = true;
        }

        //做判断
        for (int i = 0; i < obstacles.length; i++) {
            if(obstacles[i][0]<=x&&obstacles[i][1]<=y&&temp[obstacles[i][0]][obstacles[i][1]] == 1){
                flag = false;
            }
        }
        return flag;
    }
}
