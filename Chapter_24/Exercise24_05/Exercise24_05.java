/*
Author: Charles Carter
Date: 12/11/2024

Description:  This is a test program that demonstrates using the enqueue and dequeue methods
and prints how they affect the queue.
 */


public class Exercise24_05 {
    public static void main(String[] args) {
        // Create a queue
        GenericQueue<Integer> queue = new GenericQueue<>();

        // Enqueue elements
        System.out.println("Enqueueing elements:");
        queue.enqueue(10);
        System.out.println(queue);
        queue.enqueue(20);
        System.out.println(queue);
        queue.enqueue(30);
        System.out.println(queue);

        // Dequeue elements
        System.out.println("\nDequeueing elements:");
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println(queue);
    }
}
