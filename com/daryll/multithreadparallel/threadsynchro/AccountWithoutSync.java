package com.daryll.multithreadparallel.threadsynchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Thread synchronization is to coordinate the execution of the dependent threads.
A shared resource may become corrupted if it is accessed simultaneously by multiple threads.
The following example demonstrates the problem.
Suppose you create and launch 100 threads, each of which adds a penny to an account.
Define a class named Account to model the account, a class named AddAPennyTask to add
a penny to the account, and a main class that creates and launches threads. The relationships
of these classes are shown in Figure 30.9. The program is given in Listing 30.4.
 */

public class AccountWithoutSync {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        //  create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        //  wait until all tasks are finished
        while (!executor.isTerminated()) {

        }

        // output: What is balance? 1
        System.out.println("What is balance? " + account.getBalance());
    }

    //  a thread for adding a penny to the account
    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    //  an inner class for account
    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            int newBalance = balance + amount;

            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            balance = newBalance;
        }
    }
}

/*
The classes AddAPennyTask and Account in lines 24–51 are inner classes. Line 4 creates an Account with initial balance
0. Line 11 creates a task to add a penny to the account and submits the task to the executor. Line 11 is repeated 100
times in lines 10–12. The program repeatedly checks whether all tasks are completed in lines 17 and 18. The account
balance is displayed in line 20 after all tasks are completed. The program creates 100 threads executed in a thread pool
executor (lines 10–12). The isTerminated() method (line 17) is used to test whether the thread is terminated. The
balance of the account is initially 0 (line 32). When all the threads are finished, the balance should be 100 but the
output is unpredictable. As can be seen in Figure 30.10, the answers are wrong in the sample run. This demonstrates the
data-corruption problem that occurs when all the threads have access to the same data source simultaneously.

the deposit method body could be replace by one statement:
balance = balance + amount;

It is highly unlikely, although plausible, that the problem can be replicated using this single statement. The
statements in lines 39–49 are deliberately designed to magnify the datacorruption problem and make it easy to see. If
you run the program several times but still do not see the problem, increase the sleep time in line 44. This will
increase the chances for showing the problem of data inconsistency.

What, then, caused the error in this program? A possible scenario is shown in Figure 30.11

Step    Balance     Task 1                      Task 2
1       0           newBalance = balance + 1;
2       0                                       newBalance = balance + 1;
3       1           balance = newBalance;
4       1                                       balance = newBalance;

Task 1 and Task 2 both add 1 to the same balance.

In Step 1, Task 1 gets the balance from the account. In Step 2, Task 2 gets the same balance from the account.
In Step 3, Task 1 writes a new balance to the account. In Step 4, Task 2 writes a new balance to the account. The effect
of this scenario is that Task 1 does nothing because in Step 4 Task 2 overrides Task 1’s result. Obviously, the problem
is that Task 1 and Task 2 are accessing a common resource in a way that causes a conflict. This is a common problem,
known as a race condition, in multithreaded programs. A class is said to be thread-safe if an object of the class does
not cause a race condition in the presence of multiple threads. As demonstrated in the preceding example, the Account
class is not thread-safe.
*/