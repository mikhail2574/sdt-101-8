package com.example.sdt1018.part1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Stack implementation based on inheritance.
 *
 * Academic note:
 * Extending LinkedList means LinkedList's public API still exists on the concrete class.
 * The assignment asks to expose only LIFO methods; in Java this cannot be enforced perfectly
 * with inheritance alone. This class therefore provides a clean LIFO API and the driver uses it
 * through that API.
 */
public class LinkedListInheritedStack<T> extends LinkedList<T> implements StackOperations<T> {
    private static final long serialVersionUID = 1L;

    @Override
    public void push(T item) {
        addFirst(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop from an empty stack.");
        }
        return removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek into an empty stack.");
        }
        return getFirst();
    }

    @Override
    public String toString() {
        return "Top -> " + super.toString();
    }
}
