package HW1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static class ArrayList2<E> extends ArrayList{
        public void add(E[] array){
            for (int i = 0; i < array.length; i++) {
                super.add(array[i]);
            }
        }
    }//task2

    public static void main(String[] args) {
        System.out.println("--Первое задание--");
        task1();
        System.out.println("--Второе задание--");
        task2();
        System.out.println("--Третее задание--");
        task3();
    }

    private static void task3() {
        Box<Apple> boxForApple1 = new Box<>();
        Box<Apple> boxForApple2 = new Box<>();
        Box<Orange> boxForOrange = new Box<>();

        for (int i = 0; i < 25; i++) {
            boxForApple1.add(new Apple());
        }

        System.out.println("Вес первой коробки с яблоками - " + boxForApple1.getWeight());

        for (int i = 0; i < 50; i++) {
            boxForApple2.add(new Apple());
        }

        System.out.println("Вес второй коробки с яблоками - " + boxForApple2.getWeight());
        System.out.println("Пересыпаем яблоки в одну коробку");
        boxForApple1.intersperseIn(boxForApple2);

        for (int i = 0; i < 50; i++) {
            boxForOrange.add(new Orange());
        }
        System.out.println("Вес коробки с апельсинами - " + boxForOrange.getWeight());

        System.out.println("Ящики имеют одинаковый вес - " + boxForApple2.compare(boxForOrange));
    }

    private static void task2() {
        String[] strings = new String[10];
        Integer[] integers = new Integer[10];

        initStr(strings);
        initInt(integers);

        ArrayList2<String> stringsList = new ArrayList2<>();
        ArrayList2<Integer> integersList = new ArrayList2<>();

        stringsList.add(strings);
        integersList.add(integers);

        System.out.println(stringsList.toString());
        System.out.println(integersList.toString());
    }

    private static void task1() {
        int element = 3;
        int whereMove = 7;

        String[] str = new String[10];
        Integer[] integers = new Integer[10];

        initStr(str);
        initInt(integers);

        System.out.println("Arr1: " + Arrays.toString(str));
        System.out.println("Arr2: " + Arrays.toString(integers));
        System.out.println("------------------------------------");

        moveElement(str, element, whereMove);
        moveElement(integers, element, whereMove);

        System.out.println("Arr1: " + Arrays.toString(str));
        System.out.println("Arr2: " + Arrays.toString(integers));
    }

    private static <T> void moveElement(T[] array, int element, int whereMove) {
        if (element > array.length - 1 || element < 0 || whereMove < 0 || whereMove > array.length - 1) return;
        if (whereMove - element < 0) {
            int a = element;
            element = whereMove;
            whereMove = a;
        }
        T buffer = array[element];
        for (int i = element; i < whereMove; i++) {
            array[i] = array[i + 1];
        }
        array[whereMove] = buffer;
    }

    private static void initInt(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
    }

    private static void initStr(String[] str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf((char)(i + 97));
        }
    }
}
