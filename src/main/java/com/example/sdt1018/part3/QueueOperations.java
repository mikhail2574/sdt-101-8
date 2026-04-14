package com.example.sdt1018.part3;

public interface QueueOperations<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
    String toString();
}
