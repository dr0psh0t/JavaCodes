package com.daryll.multithreadparallel;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EntranceExam {

    //  Declare map to be used to store data in threads
    Map<String, Integer> dataStore = new HashMap<>();

    class ThreadExam implements Runnable {
        private Integer transactionId;

        public ThreadExam(Integer transactionId) {
            //  put the transaction id in the map
            dataStore.put("TransactionId"+transactionId, transactionId);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5);
                //  after sleeping, get the store value in the map
                //  process
            } catch (InterruptedException ignored) {}
        }
    }

    //  EXECUTION FLOW STARTS HERE
    public void execute(List<Integer> transactionIds) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<?>> futures = new ArrayList<>();

        //  spawn a thread for each transaction
        for (int transactionId : transactionIds) {
            ThreadExam threadExam = new ThreadExam(transactionId);
            futures.add(executorService.submit(threadExam));
        }

        for (Future<?> future : futures) {
            future.get();
        }

        executorService.shutdown();
        //while (!executorService.isTerminated()) {}
    }

    public static void main(String[] args) throws Exception {
        List<Integer> transactionIds = Arrays.asList(2,3,4);

        EntranceExam entranceExam = new EntranceExam();

        entranceExam.execute(transactionIds);
        System.out.println(entranceExam.dataStore.size());
    }
}
