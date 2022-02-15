package com.daryll.multithreadparallel.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
Semaphores can be used to restrict the number of threads that access a shared resource.
In computer science, a semaphore is an object that controls the access to a common resource. Before
accessing the resource, a thread must acquire a permit from the semaphore. After finishing with
the resource, the thread must return the permit back to the semaphore, as shown in Figure 30.22.

A thread accessing a share resource
        |
        |
        V
semaphore.acquire();    Acquire a permit from a semaphore.
        |               Wait if the permit is not available.
        V
Access the resource
        |
        V
semaphore.release();    Release the permit to the semaphore.

A limited number of threads can access a shared resource controlled by a semaphore.

To create a semaphore, you have to specify the number of permits with an optional fairness policy, as shown in
Figure 30.23. A task acquires a permit by invoking the semaphore’s acquire() method and releases the permit by
invoking the semaphore’s release() method. Once a permit is acquired, the total number of available permits in a
semaphore is reduced by 1. Once a permit is released, the total number of available permits in a semaphore
is increased by 1.

java.util.concurrent.Semaphore
+Semaphore(numberOfPermits: int)                    creates a semaphore with the specified number of permits. the fairness policy is false.
+Semaphore(numberOfPermits: int, fair: boolean)     creates a semaphore with the specified number of permits and the fairness policy.
+acquire(): void                                    acquires a permit from this semaphore. if no permit is available, the thread is blocked until one is available.
+release(): void                                    releases a permit back to the semaphore

A semaphore with just one permit can be used to simulate a mutually exclusive lock.
Listing 30.9 revises the Account inner class in Listing 30.9 using a semaphore to ensure that
only one thread at a time can access the deposit method.
 */

public class SemaphoreDemo {

    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        //  create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        //  wait until all tasks are finished
        while (!executor.isTerminated()) {}

        System.out.println("What is balance? "+account.getBalance());
    }

    //  a thread for adding a penny to the account
    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account {

        //  create a semaphore
        private static Semaphore semaphore = new Semaphore(1);
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            try {
                //  acquire a permit
                semaphore.acquire();

                int newBalance = balance + amount;

                //  this delay is deliberately added to magnify the
                //  data-corrumption problem and make it easy to see
                Thread.sleep(5);

                balance = newBalance;
            } catch (InterruptedException ex) {

            } finally {
                //  release a permit
                semaphore.release();
            }
        }
    }
}

/*
A semaphore with one permit is created in line 4. A thread first acquires a permit when executing the deposit method in
line 13. After the balance is updated, the thread releases the permit in line 25. It is a good practice to always place
the release() method in the finally clause to ensure that the permit is finally released even in the case of exceptions.
 */