package com.example.sdt1018;

import java.util.NoSuchElementException;

import com.example.sdt1018.part1.LinkedListInheritedStack;
import com.example.sdt1018.part2.LinkedListComposedStack;
import com.example.sdt1018.part3.LinkedListInheritedQueue;
import com.example.sdt1018.part4.LinkedListComposedQueue;

public class Main {
    private static int passedTests = 0;
    private static int totalTests = 0;

    public static void main(String[] args) {
        testInheritedStack();
        testComposedStack();
        testInheritedQueue();
        testComposedQueue();

        System.out.println();
        System.out.println("All tests finished.");
        System.out.println("Passed " + passedTests + " out of " + totalTests + " tests.");
    }

    private static void testInheritedStack() {
        System.out.println("=== Part 1: Stack via inheritance ===");
        LinkedListInheritedStack<Integer> stack = new LinkedListInheritedStack<>();

        assertTrue(stack.isEmpty(), "New inherited stack should be empty.");
        assertEquals(0, stack.size(), "New inherited stack size should be 0.");

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(3, stack.size(), "Inherited stack size after three pushes.");
        assertEquals(Integer.valueOf(30), stack.peek(), "Inherited stack peek should return the top element.");
        assertEquals("Top -> [30, 20, 10]", stack.toString(), "Inherited stack toString should show LIFO order.");
        assertEquals(Integer.valueOf(30), stack.pop(), "Inherited stack first pop.");
        assertEquals(Integer.valueOf(20), stack.pop(), "Inherited stack second pop.");
        assertEquals(Integer.valueOf(10), stack.pop(), "Inherited stack third pop.");
        assertTrue(stack.isEmpty(), "Inherited stack should be empty after all pops.");
        expectNoSuchElementException(stack::pop, "Inherited stack pop on empty stack should throw.");
        expectNoSuchElementException(stack::peek, "Inherited stack peek on empty stack should throw.");
    }

    private static void testComposedStack() {
        System.out.println("=== Part 2: Stack via composition ===");
        LinkedListComposedStack<String> stack = new LinkedListComposedStack<>();

        assertTrue(stack.isEmpty(), "New composed stack should be empty.");
        assertEquals(0, stack.size(), "New composed stack size should be 0.");

        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals(3, stack.size(), "Composed stack size after three pushes.");
        assertEquals("C", stack.peek(), "Composed stack peek should return the top element.");
        assertEquals("Top -> [C, B, A]", stack.toString(), "Composed stack toString should show LIFO order.");
        assertEquals("C", stack.pop(), "Composed stack first pop.");
        assertEquals("B", stack.pop(), "Composed stack second pop.");
        assertEquals("A", stack.pop(), "Composed stack third pop.");
        assertTrue(stack.isEmpty(), "Composed stack should be empty after all pops.");
        expectNoSuchElementException(stack::pop, "Composed stack pop on empty stack should throw.");
        expectNoSuchElementException(stack::peek, "Composed stack peek on empty stack should throw.");
    }

    private static void testInheritedQueue() {
        System.out.println("=== Part 3: Queue via inheritance ===");
        LinkedListInheritedQueue<Double> queue = new LinkedListInheritedQueue<>();

        assertTrue(queue.isEmpty(), "New inherited queue should be empty.");
        assertEquals(0, queue.size(), "New inherited queue size should be 0.");

        queue.enqueue(1.5);
        queue.enqueue(2.5);
        queue.enqueue(3.5);

        assertEquals(3, queue.size(), "Inherited queue size after three enqueues.");
        assertEquals(Double.valueOf(1.5), queue.peek(), "Inherited queue peek should return the front element.");
        assertEquals("Front -> [1.5, 2.5, 3.5] <- Rear", queue.toString(), "Inherited queue toString should show FIFO order.");
        assertEquals(Double.valueOf(1.5), queue.dequeue(), "Inherited queue first dequeue.");
        assertEquals(Double.valueOf(2.5), queue.dequeue(), "Inherited queue second dequeue.");
        assertEquals(Double.valueOf(3.5), queue.dequeue(), "Inherited queue third dequeue.");
        assertTrue(queue.isEmpty(), "Inherited queue should be empty after all dequeues.");
        expectNoSuchElementException(queue::dequeue, "Inherited queue dequeue on empty queue should throw.");
        expectNoSuchElementException(queue::peek, "Inherited queue peek on empty queue should throw.");
    }

    private static void testComposedQueue() {
        System.out.println("=== Part 4: Queue via composition ===");
        LinkedListComposedQueue<Character> queue = new LinkedListComposedQueue<>();

        assertTrue(queue.isEmpty(), "New composed queue should be empty.");
        assertEquals(0, queue.size(), "New composed queue size should be 0.");

        queue.enqueue('X');
        queue.enqueue('Y');
        queue.enqueue('Z');

        assertEquals(3, queue.size(), "Composed queue size after three enqueues.");
        assertEquals(Character.valueOf('X'), queue.peek(), "Composed queue peek should return the front element.");
        assertEquals("Front -> [X, Y, Z] <- Rear", queue.toString(), "Composed queue toString should show FIFO order.");
        assertEquals(Character.valueOf('X'), queue.dequeue(), "Composed queue first dequeue.");
        assertEquals(Character.valueOf('Y'), queue.dequeue(), "Composed queue second dequeue.");
        assertEquals(Character.valueOf('Z'), queue.dequeue(), "Composed queue third dequeue.");
        assertTrue(queue.isEmpty(), "Composed queue should be empty after all dequeues.");
        expectNoSuchElementException(queue::dequeue, "Composed queue dequeue on empty queue should throw.");
        expectNoSuchElementException(queue::peek, "Composed queue peek on empty queue should throw.");
    }

    private static void assertTrue(boolean condition, String message) {
        totalTests++;
        if (!condition) {
            throw new AssertionError("FAILED: " + message);
        }
        passedTests++;
        System.out.println("PASSED: " + message);
    }

    private static void assertEquals(int expected, int actual, String message) {
        totalTests++;
        if (expected != actual) {
            throw new AssertionError("FAILED: " + message + " Expected: " + expected + ", but got: " + actual);
        }
        passedTests++;
        System.out.println("PASSED: " + message);
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        totalTests++;
        if (!expected.equals(actual)) {
            throw new AssertionError("FAILED: " + message + " Expected: " + expected + ", but got: " + actual);
        }
        passedTests++;
        System.out.println("PASSED: " + message);
    }

    private static void expectNoSuchElementException(ThrowingAction action, String message) {
        totalTests++;
        try {
            action.run();
            throw new AssertionError("FAILED: " + message + " No exception was thrown.");
        } catch (NoSuchElementException expected) {
            passedTests++;
            System.out.println("PASSED: " + message);
        }
    }

    @FunctionalInterface
    private interface ThrowingAction {
        void run();
    }
}
