package com.fastcampus.ch3.aop;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {
    public static void main(String[] args) throws Exception{
        MyAdvice myAdvice = new MyAdvice();

        //MyClass의 class객체를 얻어오자
        Class myClass = Class.forName("com.fastcampus.ch3.aop.MyClass");
        //class객체로부터 객체를 생성하자
        Object obj = myClass.newInstance();
        //반복문 이용해서 myClass의 메소드들을 하나씩 호출할거다
        for(Method m : myClass.getDeclaredMethods()){
            // myAdvice에 invoke메서드에다 MyClass에 정의된 메서드 정보들을
            //넘겨주는것이다.
            myAdvice.invoke(m, obj, null);
        }

    }
}

class MyAdvice{
    //원하는 메서드에다만 추가를 하고싶다면 pattern을 추가하면 된다
    //정규식 이용
    Pattern p = Pattern.compile("a.*");

    //matches메서드만들어야한다
    boolean matches(Method m){
        Matcher matcher = p.matcher(m.getName());
        return matcher.matches();
    }

    void invoke(Method m, Object obj, Object... args) throws Exception{
        // 패턴을 이용해서 코드를 추가할 메서드들을 선택할수있다.
//        if(matches(m))
        if(m.getAnnotation(Transactional.class)!=null)
            System.out.println("[before]{");
        //reflection api ?
        m.invoke(obj,args); // aaa(), aaa2(), bbb() 메서드를 각각 호출한다
//        if(matches(m))
        if(m.getAnnotation(Transactional.class)!=null)
            System.out.println("}[after]");
    }
}


class MyClass {
    //패턴 대신 @애너테이션 사용도 가능하다.
    @Transactional // -> 붙인 후 matches대신에 @정보 얻어와서 붙은게 있음 실행해라
    void aaa(){
        System.out.println("aaa() is called");
    }
    void aaa2(){
        System.out.println("aaa2() is called");
    }
    void bbb(){
        System.out.println("bbb() is called");
    }


}
