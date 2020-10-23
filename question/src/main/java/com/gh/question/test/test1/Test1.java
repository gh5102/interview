package com.gh.question.test.test1;

/**
 *
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.fibonacci2(16));
    }
    public int fibonacci(int n) {
        // write your code here
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public int fibonacci2(int n) {
        // write your code here
        int sum = 0;
        //第n-2个数
        int x = 0;
        //第n-1个数
        int y = 1;
        int temp = 0;
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }
        for(int i=3;i<=n;i++){
            //计算第n个数并赋值给y
            temp = x+y;
            x = y;
            y = temp;

        }
        return  y;
    }
}
