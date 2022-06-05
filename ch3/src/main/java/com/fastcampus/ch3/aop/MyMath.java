package com.fastcampus.ch3.aop;

import org.springframework.stereotype.Component;

@Component
public class MyMath { //부가기능 적용할 target 객체임
    public int add(int a, int b){
        int result = a + b;
        return result;
    }

    public int add(int a, int b, int c){
        int result = a+b+c;
        return result;
    }

    public int subtract(int a, int b){
        int result = a - b;
        return result;
    }

    public int multiply(int a, int b){
        int result = a * b;
        return result;
    }

}
