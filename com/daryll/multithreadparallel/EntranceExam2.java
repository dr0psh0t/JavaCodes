package com.daryll.multithreadparallel;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;

//  3. What causes the threading issue in this code snippet?

/*
when put
 */

public class EntranceExam2 {

    // Declare map to be used to store data in threads
    Map<String, Integer> datastore = new HashMap<>();

    public class ThreadExam implements Runnable {

        private Integer transactionId;

        public ThreadExam(Integer transactionId) {
            this.transactionId = transactionId;
            // Put the transaction id in the map
            //datastore.put("Key"+transactionId, transactionId);
        }

        @Override
        //@SneakyThrows
        public synchronized void run() {
            try {
                Thread.sleep(5);
                datastore.put("Key"+transactionId, transactionId);
            } catch (InterruptedException ignored) {}
        }
    }

    // EXECUTION FLOW STARTS HERE
    public void execute(List<Integer> transactionIds) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Spawn a thread for each transaction
        for (int transactionId: transactionIds) {
            executorService.execute(new ThreadExam(transactionId));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {}
    }

    public static void main(String[] args) throws Exception {
        List<Integer> transactionIds = Arrays.asList(2,3,4);

        EntranceExam2 entranceExam = new EntranceExam2();
        entranceExam.execute(transactionIds);

        System.out.println(entranceExam.datastore);
        //System.out.println(entranceExam.datastore.size());
    }
}