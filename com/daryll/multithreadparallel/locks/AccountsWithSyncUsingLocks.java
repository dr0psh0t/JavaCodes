package com.daryll.multithreadparallel.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Locks and conditions can be explicitly used to synchronize threads.Recall that in Listing 30.4, 100 tasks deposit a
penny to the same account concurrently, which causes conflicts. To avoid it, you use the synchronized keyword in the
deposit method, as follows:

public synchronized void deposit(double amount)

A synchronized instance method implicitly acquires a lock on the instance before it executes the method.
Java enables you to acquire locks explicitly, which give you more control for coordinating threads. A lock is an
instance of the Lock interface, which defines the methods for acquiring and releasing locks, as shown in Figure 30.13.
A lock may also use the newCondition() method to create any number of Condition objects, which can be used for thread
communications.

        <<interface>>
java.util.concurrent.locks.Lock
----------------------------------------
+lock(): void                               -acquires the lock.
+unlock(): void                             -releases the lock.
+newCondition(): Condition                  -returns a new condition instance that is bound to this Lock instance
                ^
                |
java.util.concurrent.locks.ReentrantLock
----------------------------------------
+ReentrantLock()                            -same as ReentrantLock(false).
+ReentrantLock(fair: boolean)               -creates a lock with given fairness policy. when the fairness is true, the
                                            longest-waiting thread will get the lock. Otherwise, there is no particular
                                            access order

The ReentrantLock class implements the Lock interface to represent a lock.

ReentrantLock is a concrete implementation of Lock for creating mutually exclusive locks. You can create a lock with the
specified fairness policy. True fairness policies guarantee that the longest-waiting thread will obtain the lock first.
False fairness policies grant a lock to a waiting thread arbitrarily. Programs using fair locks accessed by many threads
may have poorer overall performance than those using the default setting, but they have smaller variances in times to
obtain locks and prevent starvation. Listing 30.5 revises the program in Listing 30.7 to synchronize the account
modification using explicit locks.
 */

public class AccountsWithSyncUsingLocks {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        //  wait until all tasks are finished
        while (!executor.isTerminated()) {

        }

        System.out.println("What is balance? "+account.getBalance());
    }

    public static class AddAPennyTask implements Runnable {
        public void run() {
            account.deposit(1);
        }
    }

    public static class Account {
        private static Lock lock = new ReentrantLock();
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            //  explicitly locking without using synchronized method or block
            lock.lock();    //  acquire the lock

            try {
                int newBalance = balance + amount;

                //  this delay is deliberately added to magnify the
                //  data-corruption problem and make it easy to see
                Thread.sleep(5);

                balance = newBalance;
            }
            catch (InterruptedException ex) {
            }
            finally {
                lock.unlock();
            }
        }
    }
}
