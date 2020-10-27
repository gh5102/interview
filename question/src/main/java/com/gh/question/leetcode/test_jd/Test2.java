package com.gh.question.leetcode.test_jd;

public class Test2 {
    public String generateTheString(int n) {

        char a = 'a';
        char b = 'b';
        if(n%2==0){
            char[] c = new char[n-1];
            for(int i=0;i<n-1;i++){
                c[i] = b;
            }
            return new String(c)+a;
        }else {
            char[] c = new char[n];
            for (int i = 0; i < n - 1; i++) {
                c[i] = b;
            }
            return new String(c);
        }
    }
}
