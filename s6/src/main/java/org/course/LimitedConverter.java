package org.course;

public class LimitedConverter <E extends Number>{

    public boolean esMayorQue(E input, E input2){
        return input.doubleValue() > input2.doubleValue();
    }
}
