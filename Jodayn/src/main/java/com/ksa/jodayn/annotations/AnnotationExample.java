package com.ksa.jodayn.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RunMe {
    int value() default -1;
}


class WithAutoMethods{

    @RunMe(2)
    public void method1(){
        System.out.println("method1");
    }

    @RunMe(value = 1)
    public void method2(){
        System.out.println("method2");
    }

}


public class AnnotationExample {

    static class MethodItem{
        int index;
        Method method;

        MethodItem(
                int index,
                Method method
        ){
            this.index = index;
            this.method = method;
        }
    }

    static void runAllAutoMethods(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        List<MethodItem> methodItems = new ArrayList<>();

        for (Method method : methods) {
            RunMe annotation = method.getAnnotation(RunMe.class);
            if (annotation != null) {
                methodItems.add(new MethodItem(annotation.value(), method));
            }
        }

        methodItems.sort(Comparator.comparingInt(o -> o.index));

        for (MethodItem methodItem : methodItems) {
            methodItem.method.invoke(obj);
        }


    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        WithAutoMethods obj = new WithAutoMethods();

        runAllAutoMethods(obj);
    }

}
