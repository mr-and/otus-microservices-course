package com.microservicesotuscourse.dockerdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        B<String> b = new B<>();
    }

}

class A<T> {

}
class B<S> extends A<S> {

}