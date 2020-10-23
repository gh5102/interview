package com.gh.question.test.test1;

public class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.sortIntegers(new int[]{1,3,2,4});
    }

    public void sortIntegers(int[] A) {
        // write your code here
        int temp = 0;
        for(int i=0;i<A.length-1;i++){
            for(int j=0;j<A.length-1-i;j++){
                if(A[j]>A[j+1]){
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
    }
}
