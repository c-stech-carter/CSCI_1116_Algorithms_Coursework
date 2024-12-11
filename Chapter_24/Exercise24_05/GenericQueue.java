/*
Author: Charles Carter
Date: 12/11/2024

Description: GenericQueue class from textbook using inheritance to implement LinkedList
 */

public class GenericQueue<E> extends java.util.LinkedList<E> {

    // Adds an element to the end of the queue
    public void enqueue(E e) {
        addLast(e);
    }

    // Removes and returns the element at the front of the queue
    public E dequeue() {
        return removeFirst();
    }

    // Returns the size of the queue
    public int getSize() {
        return size();
    }

    @Override
    public String toString() {
        return "Queue: " + super.toString();
    }
}
