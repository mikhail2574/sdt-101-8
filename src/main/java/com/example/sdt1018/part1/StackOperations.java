package com.example.sdt1018.part1;

public interface StackOperations<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
    String toString();
}
