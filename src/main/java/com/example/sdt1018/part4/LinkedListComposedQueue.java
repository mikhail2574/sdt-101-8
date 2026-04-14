package com.example.sdt1018.part4;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListComposedQueue<T> implements QueueOperations<T> {
    private final LinkedList<T> items = new LinkedList<>();

    @Override
    public void enqueue(T item) {
        items.addLast(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from an empty queue.");
        }
        return items.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek into an empty queue.");
        }
        return items.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Front -> " + items + " <- Rear";
    }
}
