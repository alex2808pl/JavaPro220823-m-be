package de.telran.module_2.lesson_7;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.add("Один"));
        queue.add("Два");
        queue.add("Три");
        queue.add("Четыре");
//        queue.add(null);
//        queue.add(null);
//        queue.add(null);
        System.out.println(queue);
        System.out.println(queue.size() /*+ " --- "+queue.capacity()*/);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());


        System.out.println(queue.poll());

        System.out.println(queue.isEmpty());
//        System.out.println(queue.remove());

        for (String el : queue) {
            System.out.println(el);
        }
    }
}
