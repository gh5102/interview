package com.gh.question.leetcode.test_mid;


/**
 * Z 字形变换
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.convert("AB",1);
    }
    public String convert(String s, int numRows) {
        if(s == null||s.length()<=numRows||numRows<=1){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i <stringBuilders.length ; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        for (int i = 0; i < chars.length; i++) {
            int temp = i%(2*numRows-2);
            if(temp<numRows){
                stringBuilders[temp].append(chars[i]);
            }else{
                stringBuilders[2*numRows-temp-2].append(chars[i]);
            }

           //stringBuilders[i%numRows].append(chars[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilder.append(stringBuilders[i]);
        }
        return stringBuilder.toString();
    }
}
