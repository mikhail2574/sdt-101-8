package com.example.sdt1018.part2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListComposedStack<T> implements StackOperations<T> {
    private final LinkedList<T> items = new LinkedList<>();

    @Override
    public void push(T item) {
        items.addFirst(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop from an empty stack.");
        }
        return items.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek into an empty stack.");
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
        return "Top -> " + items;
    }
}
