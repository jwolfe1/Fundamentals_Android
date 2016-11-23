package com.JasonWolfe.Week_12;

import java.util.ArrayList;
import java.util.List;

class QueueFullException extends Exception{}
class QueueEmptyException extends Exception{}

class Queue<E> {
    private List<E> elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = new ArrayList<>();
        this.size = size;
    }

    public void enqueue(E element) throws QueueFullException {
        if (elements.size() >= size) {
            throw new QueueFullException();
        }
        elements.add(element);

    }

    public E dequeue() throws QueueEmptyException {
        if (elements.size() == 0) {
            throw new QueueEmptyException();
        }
        return elements.remove(0);
    }

}

public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(2);
        try {
            strings.enqueue("First String");
            strings.enqueue("Second String");

            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        }
        catch (QueueEmptyException | QueueFullException e) {
            e.printStackTrace();
        }
    }
}