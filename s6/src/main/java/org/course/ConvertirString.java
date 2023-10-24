package org.course;

public class ConvertirString<T>{
    private T Object;

    void hold(T object){
        this.Object = object;
    }

    T realease(){
        return Object;
    }

    String convertirString(){
        return Object.toString();
    }

    public static <E> String convertirSting2(E input){
        return input.toString();
    }

}

