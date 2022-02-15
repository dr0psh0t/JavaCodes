package com.daryll.multithreadparallel.threadcooperation;

/*
Conditions are objects created by invoking the newCondition() method on a Lock object. Once a condition is created, you
can use its await(), signal(), and signalAll() methods for thread communications, as shown in Figure 30.14. The await()
method causes the current thread to wait until the condition is signaled. The signal() method wakes up one waiting
thread, and the signalAll() method wakes all waiting threads.

        <<interface>>
java.util.concurrent.Condition
------------------------------
+await(): void                      Causes the current thread to wait until the condition is signaled
+signal(): void                     Wakes up one waiting thread
+signalAll(): Condition             Wakes up all waiting threads.

Let us use an example to demonstrate thread communications. Suppose that you create and launch two tasks: one that
deposits into an account and one that withdraws from the same account. The withdraw task has to wait if the amount to
be withdrawn is more than the current balance. Whenever new funds are deposited into the account, the deposit task
notifies the withdraw thread to resume. If the amount is still not enough for a withdrawal, the withdraw thread has to
continue to wait for a new deposit.
To synchronize the operations, use a lock with a condition: newDeposit (i.e., new deposit added to the account). If the
balance is less than the amount to be withdrawn, the withdraw task will wait for the newDeposit condition. When the
deposit task adds money to the account, the task signals the waiting withdraw task to try again. The interaction between
the two tasks is shown in Figure 30.15.

    Withdraw Task                           Deposit Task
        |                                           |
        V                                           V
    lock.lock();                                lock.lock();
        |                                           |
        V                                           V
while (balance < withdrawAmount)        balance += depositAmount
    newDeposit.await();   <--------+                |
        |                          |                V
        V                          +----newDeposit.signalAll();
balance -= withdrawAmount                           |
        |                                           V
        V                                       lock.unlock();
    lock.unlock();

You create a condition from a Lock object. To use a condition, you have to first obtain a lock. The await() method
causes the thread to wait and automatically releases the lock on the condition. Once the condition is right, the thread
reacquires the lock and continues executing. Assume that the initial balance is 0 and the amount to deposit and withdraw
are randomly generated. Listing 30.6 gives the program. A sample run of the program is shown in Figure 30.16.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
    private static Account account = new Account();

    public static void main(String[] args) {
        //  create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();

        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    public static class DepositTask implements Runnable {
        //  keep adding an amount to the account
        @Override
        public void run() {
            try {   //  purposely delay it to let the withdraw method proceed
                while (true) {
                    account.deposit((int)(Math.random() * 10) + 1);

                    //  The deposit task is purposely put to sleep to let the withdraw task run
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable {
        //  keep subtracting an amount from the account
        @Override
        public void run() {
            while (true) {
                account.withdraw((int)(Math.random() * 10) + 1);
            }
        }
    }

    private static class Account {
        //  create a new lock
        private static Lock lock = new ReentrantLock();

        //  create a condition
        private static Condition newDeposit = lock.newCondition();

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            lock.lock();    //  acquire the lock

            try {
                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    newDeposit.await();
                }

                balance -= amount;
                System.out.println("\t\t\tWithdraw "+amount+"\t\t"+getBalance());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();  //  release the lock
            }
        }

        public void deposit(int amount) {
            lock.lock();    //  acquire the lock

            try {
                balance += amount;
                System.out.println("Deposit "+amount+"\t\t\t\t\t"+getBalance());

                //  signal thread waiting on the condition
                newDeposit.signalAll();
            } finally {
                lock.unlock();  //  release the lock
            }
        }
    }
}

/*
The example creates a new inner class named Account to model the account with two methods, deposit(int) and
withdraw(int), a class named DepositTask to add an amount to the balance, a class named WithdrawTask to withdraw an
amount from the balance, and a main class that creates and launches two threads. The program creates and submits the
deposit task and the withdraw task. The deposit task is purposely put to sleep to let the withdraw task run. When there
are not enough funds to withdraw, the withdraw task waits for notification of the balance change from the deposit task.
A lock is created in line 44. A condition named newDeposit on the lock is created. A condition is bound to a lock.
Before waiting or signaling the condition, a thread must first acquire the lock for the condition. The withdraw task
acquires the lock, waits for the newDeposit condition when there is not a sufficient amount to withdraw, and releases
the lock in line 71. The deposit task acquires the lock and signals all waiting threads for the newDeposit condition
after a new deposit is made.
 */

/*
sample run:

Thread 1		Thread 2		Balance
Deposit 5					    5
		        Withdraw 3		2
			    Withdraw 2		0
			Wait for a deposit
Deposit 2					    2
			Wait for a deposit
Deposit 7					    9
			    Withdraw 5		4
			Wait for a deposit
Deposit 7					    11
			    Withdraw 8		3
			Wait for a deposit
Deposit 9		    			12
			    Withdraw 5		7
			    Withdraw 5		2
			    Withdraw 2		0
			Wait for a deposit
Deposit 9		    			9
			    Withdraw 2		7
			Wait for a deposit
Deposit 9   					16
                Withdraw 10		6
			Wait for a deposit
Deposit 9		    			15
			    Withdraw 10		5
			    Withdraw 4		1
			Wait for a deposit
Deposit 3		    			4
			Wait for a deposit
Deposit 3			    		7
			    Withdraw 5		2
			Wait for a deposit
Deposit 8		    			10
			    Withdraw 10		0
			Wait for a deposit
 */