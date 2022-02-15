package com.daryll.multithreadparallel.threadcooperation;

/*
Queues and priority queues are introduced in Section 20.9. A blocking queue causes a thread to block when you try to add
an element to a full queue or to remove an element from an empty queue. The BlockingQueue interface extends
java.util.Queue and provides the synchronized put and take methods for adding an element to the tail of the queue and
for removing an element from the head of the queue, as shown in Figure 30.20.

    <<interface>>
java.util.Collection<E>
        ^
        |
    <<interface>>
java.util.Queue<E>
        ^
        |
    <<interface>>
java.util.concurrent.BlockingQueue<E>
-------------------------------------
+put(element: E): void                      Inserts an element to the tail of the queue.
                                                Waits if the queue if full
+take(): E                                  Retrieves and removes the head of this queue.
                                                Waits if the queue is empty.

Three concrete blocking queues—ArrayBlockingQueue, LinkedBlockingQueue, and PriorityBlockingQueue—are provided in Java,
as shown in Figure 30.21. All are in the java.util.concurrent package. ArrayBlockingQueue implements a blocking queue
using an array. You have to specify a capacity or an optional fairness to construct an ArrayBlockingQueue.
LinkedBlockingQueue implements a blocking queue using a linked list. You can create an unbounded or bounded
LinkedBlockingQueue. PriorityBlockingQueue is a priority queue. You can create an unbounded or bounded priority queue.

                                                <<interface>>
                +------------------> java.util.concurrent.BlockingQueue<E> <------------------+
                |                                    ^                                        |
                |                                    |                                        |
                |                                    |                                        |
    ArrayBlockingQueue<E>                   LinkedBlockingQueue<E>                      PriorityBlockingQueue<E>
-----------------------------------     -----------------------------------     -------------------------------------
+ArrayBlockingQueue(Capacity: int)      +LinkedBlockingQueue()                  +PriorityBlockingQueue()
+ArrayBlockingQueue(capacity: int,      +LinkedBlockingQueue(capacity: int)     +PriorityBlockingQueue(capacity: int)
    fair: boolean)
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducerUsingBlockingQueue {
    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2);

    public static void main(String[] args) {

        //  create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProduceTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

    //  a task for adding an int to the buffer
    private static class ProduceTask implements Runnable {
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes "+i);

                    //  add any value to the buffer, say, 1
                    buffer.put(i++);

                    //  put the thread into sleep
                    Thread.sleep((int)(Math.random() * 10000));
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    //  a task for reading and deleting an int from the buffer
    private static class ConsumerTask implements Runnable {
        public void run() {
            try {
                while (true) {
                    System.out.println("\t\t\tConsumer reads "+buffer.take());

                    //  put the thread into sleep
                    Thread.sleep((int)(Math.random() * 10000));
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

/*
run:

Producer writes 1
			Consumer reads 1
Producer writes 2
			Consumer reads 2
Producer writes 3
Producer writes 4
Producer writes 5
			Consumer reads 3
Producer writes 6
			Consumer reads 4
			Consumer reads 5
			Consumer reads 6
Producer writes 7
			Consumer reads 7
Producer writes 8
			Consumer reads 8
Producer writes 9
			Consumer reads 9
Producer writes 10
			Consumer reads 10
Producer writes 11
Producer writes 12
Producer writes 13
			Consumer reads 11
			Consumer reads 12
Producer writes 14
Producer writes 15
			Consumer reads 13
			Consumer reads 14
Producer writes 16
Producer writes 17
			Consumer reads 15
			Consumer reads 16
Producer writes 18

Process finished with exit code -1

 */