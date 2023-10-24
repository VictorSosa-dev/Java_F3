package org.course;

public class Holder<T> {

    private T Object;

    void hold(T object) {
        this.Object = object;
    }

    T realease(){
        return Object;
    }
}
