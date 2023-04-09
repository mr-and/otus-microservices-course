package com.microservicesotuscourse.dockerdemo;

import java.util.List;

public class Test {

    List<? extends Number> lb;

    public static void main(String[] args) {

    }


    interface IA<E> {
        void paint(E e);

        void paint2(int i);
    }


    static class A<T> implements IA<T> {

        public void paint(T t) {
            System.out.println("HelloA " + t);
        }

        public void paint2(int i) {
        }
    }

    interface IB<E> {
        void paint(E e);
    }

    static class B<E> extends A<E> implements IB<E> {

        public void paint(E e) {
            System.out.println("HelloB " + e);
        }

    }

    static <T extends IA> void test3(IA<T> t) {
        t.paint((T) t);
    }


}
