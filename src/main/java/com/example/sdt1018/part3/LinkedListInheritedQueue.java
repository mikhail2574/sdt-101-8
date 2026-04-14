package com.example.sdt1018.part3;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Queue implementation based on inheritance.
 *
 * Academic note:
 * Because Java inheritance keeps LinkedList's public methods visible, FIFO-only exposure cannot be
 * enforced perfectly on the concrete class. This class still provides the required FIFO API.
 */
public class LinkedListInheritedQueue<T> extends LinkedList<T> implements QueueOperations<T> {
    private static final long serialVersionUID = 1L;

    @Override
    public void enqueue(T item) {
        addLast(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from an empty queue.");
        }
        return removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek into an empty queue.");
        }
        return getFirst();
    }

    @Override
    public String toString() {
        return "Front -> " + super.toString() + " <- Rear";
    }
}
