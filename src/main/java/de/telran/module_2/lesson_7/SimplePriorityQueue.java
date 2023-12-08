package de.telran.module_2.lesson_7;

import lombok.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SimplePriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<People> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new People("Вася", 20, 1));
        priorityQueue.add(new People("Деня", 45, 6));
        priorityQueue.add(new People("Катя", 34, 3));
        priorityQueue.add(new People("Валентина Павловна", 65, 7));
        System.out.println(priorityQueue);

        for (People people : priorityQueue) {
            System.out.println(people);
        }

        System.out.println();
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);

        priorityQueue.add(new People("Петя", 48, 2));
        System.out.println(priorityQueue);
//
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue);


        System.out.println("--- Меняем компаратор ----");
        PriorityQueue<People> priorityQueue1 = new PriorityQueue<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });

        priorityQueue1.addAll(priorityQueue);
        priorityQueue1.add(new People("Вова", Integer.MIN_VALUE+2, 8));
        System.out.println(priorityQueue1);
        System.out.println(priorityQueue1.peek());

        PriorityQueue<People> priorityQueue2 = new PriorityQueue<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if(o1.getAge()>60) return -1;
                if(o2.getAge()>60) return 1;
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        priorityQueue2.addAll(priorityQueue);
        priorityQueue2.add(new People("Вова", 62, 8));
        System.out.println(priorityQueue2);
        System.out.println(priorityQueue2.peek());

    }
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class People implements Comparable<People>{
    private String name;
    private int age;
    private int ticketNumber;
    @Override
    public int compareTo(People o) {
        if(this.ticketNumber > o.ticketNumber)
            return 1;
        if(this.ticketNumber < o.ticketNumber)
            return -1;
        return 0;
    }
}
