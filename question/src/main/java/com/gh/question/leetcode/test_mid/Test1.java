package com.gh.question.leetcode.test_mid;


/**
 * 最长回文子串
 */
public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.longestPalindrome("cbb212sa"));
    }

    // TODO: 2020-10-27
    public String longestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        if(s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append("#");
            stringBuilder.append(chars[i]);
        }
        stringBuilder.append("#");
        char[] chars1 = stringBuilder.toString().toCharArray();
        int count = 0;
        int max = 0;
        int maxCount = 0;
        //中间数对称
        for (int i = 0; i <chars1.length ; i++) {
            count = 0;
            for(int j=1;j<=i&&j<(chars1.length-i);j++){
                if(chars1[i-j]==chars1[i+j]){
                    count++;
                }else{
                    break;
                }
            }
            if(count > maxCount){
                max = i;
                maxCount = count;
            }

        }
        return  String.copyValueOf(chars1,max-maxCount,2*maxCount+1).replace("#","");
    }
}
