package com.daryll.multithreadparallel.threadsynchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
To avoid race conditions, it is necessary to prevent more than one thread from simultaneously entering a certain part
of the program, known as the critical region. The critical region in Listing 30.4 is the entire deposit method. You can
use the keyword synchronized to synchronize the method so that only one thread can access the method at a time. There
are several ways to correct the problem in Listing 30.4. One approach is to make Account thread-safe by adding the
keyword synchronized in the deposit method in line 38, as follows:

public synchronized void deposit(double amount)

A synchronized method acquires a lock before it executes. A lock is a mechanism for exclusive use of a resource. In the
case of an instance method, the lock is on the object for which the method was invoked. In the case of a static method,
the lock is on the class. If one thread invokes a synchronized instance method (respectively, static method) on an
object, the lock of that object (respectively, class) is acquired first, then the method is executed, and finally the
lock is released. Another thread invoking the same method of that object (respectively, class) is blocked until the lock
is released. With the deposit method synchronized, the preceding scenario cannot happen. If Task 1 enters the method,
Task 2 is blocked until Task 1 finishes the method, as shown in Figure 30.12.

              Task 1                                Task 2

Acquire a lock on the object account
                |
                V
    Execute the deposit method
                |
                V                           Wait to acquire the lock
        Release the lock                                |
                                                        V
                                        Acquire a lock on the object account
                                                        |
                                                        V
                                            Execute the deposit method
                                                        |
                                                        V
                                                Release the lock

Task 1 and Task 2 are synchronized.

Invoking a synchronized instance method of an object acquires a lock on the object, and invoking a synchronized static
method of a class acquires a lock on the class. A synchronized statement can be used to acquire a lock on any object,
not just this object, when executing a block of the code in a method. This block is referred to as a synchronized block.
The general form of a synchronized statement is as follows:

synchronized (expr) {
    statements;
}

The expression expr must evaluate to an object reference. If the object is already locked by another thread, the thread
is blocked until the lock is released. When a lock is obtained on the object, the statements in the synchronized block
are executed and then the lock is released. Synchronized statements enable you to synchronize part of the code in a
method instead of the entire method. This increases concurrency. You can make Listing 30.4 thread-safe by placing the
statement in line 26 inside a synchronized block:

synchronized (account) {
    account.deposit(1);
}
 */

public class AccountWithSync {

    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        //  create and lunch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        //  wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        //  output: What is balance? 100
        System.out.println("What is balance? "+account.getBalance());
    }

    // a thread for adding a penny to the account
    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            /*
            synchronized statement with account as object reference.
            the balance is 100 when using the method 3
            synchronized (account) {
                account.deposit(1);
            }*/

            account.deposit(1);
        }
    }

    //  an inner class for account
    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        /*  deposit method 1
        synchronized method declaration makes the balance 100 at first run.
         */
        public synchronized void deposit(int amount) {
            int newBalance = balance + amount;

            try {
                Thread.sleep(5);
            }
            catch (InterruptedException ex) {
            }

            balance = newBalance;
        }

        /*  deposit method 2
        synchronized statement makes the balance 100 at first run.
        public void deposit(int amount) {
            synchronized (this) {
                int newBalance = balance + amount;

                try {
                    Thread.sleep(5);
                }
                catch (InterruptedException ex) {
                }

                balance = newBalance;
            }
        }*/

        /*  deposit method 3
        will not make the balance 100 at first run.
        public void deposit(int amount) {
            int newBalance = balance + amount;

            try {
                Thread.sleep(5);
            }
            catch (InterruptedException ex) {
            }

            balance = newBalance;
        }*/
    }
}