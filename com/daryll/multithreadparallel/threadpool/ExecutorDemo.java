package com.daryll.multithreadparallel.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Runnable task = new TaskClass(task);
new Thread(task).start();

This approach is convenient for a single task execution, but it is not efficient for a large number of tasks because
you have to create a thread for each task. Starting a new thread for each task could limit throughput and cause poor
performance. Using a thread pool is an ideal way to manage the number of tasks executing concurrently. Java provides
the Executor interface for executing tasks in a thread pool and the ExecutorService interface for managing and
controlling tasks. ExecutorService is a subinterface of Executor, as shown in Figure 30.7.

        <<interface>>
java.util.concurrent.Executor
----------------------------------------
+execute(Runnable object): void             -Executes the runnable task

        <<interface>>
java.util.concurrent.ExecutorService
----------------------------------------
+shutdown(): void                           -shuts down the executor, but allows the task in the executor
                                            to complete. once shut down, it cannot accept new tasks
+shutdownNow(): List<Runnable>              -shuts down the executor immediately even though there are unfinished
                                            threads in the pool. Returns a list of unfinished tasks.
+isShutdown(): boolean                      -returns true if the executor has been shut down
+isTerminated(): boolean                    -returns true if all tasks in the pool are terminated.

To create an Executor object, use the static methods in the Executors class, as shown in Figure 30.8. The
newFixedThreadPool(int) method creates a fixed number of threads in a pool. If a thread completes executing a task, it
can be reused to execute another task. If a thread terminates due to a failure prior to shutdown, a new thread will be
created to replace it if all the threads in the pool are not idle and there are tasks waiting for execution. The
newCachedThreadPool() method creates a new thread if all the threads in the pool are not idle and there are tasks
waiting for execution. A thread in a cached pool will be terminated if it has not been used for 60 seconds. A cached
pool is efficient for many short tasks.

java.util.concurrent.Executors
---------------------------------------
+newFixedThreadPool(numberOfThreads:        -creates a thread pool with a fixed number of threads executing concurrently.
    int): ExecutorService                   a thread may be reused to execute another task after its current task is
                                            finished.
+newCachedThreadPool():                     -creates a thread pool that creates new threads as needed, but will reuse
    ExecutorService                         previously constructed threads when they are available.
 */

public class ExecutorDemo {
    public static void main(String[] args) {

        //  create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //ExecutorService executor = Executors.newFixedThreadPool(1);
        //- the three runnable tasks will be executed sequentially because there is only
        //one thread in the pool

        //ExecutorService executor = Executors.newCachedThreadPool();
        //- new threads will be created for each waiting task, so all the task will be
        //executed concurrently.

        //  submit runnable tasks to the executor
        executor.execute(new PrintChar('a', 10));
        executor.execute(new PrintChar('b', 10));
        executor.execute(new PrintNum(10));

        //  shut down the executor
        executor.shutdown();
    }
}

class PrintChar implements Runnable {
    private char charToPrint;
    private int times;

    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}

class PrintNum implements Runnable {
    private int lastNum;

    public PrintNum(int n) {
        lastNum = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" "+i);
        }
    }
}