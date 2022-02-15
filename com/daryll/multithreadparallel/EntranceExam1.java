package com.daryll.multithreadparallel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;

public class EntranceExam1 {
    private static Data data = new Data();

    public static class ThreadExam implements Runnable {
        Integer transactionId;

        public ThreadExam(Integer transactionId) {
            this.transactionId = transactionId;
        }

        @Override
        public void run() {
            data.store(transactionId);
        }
    }

    public static class Data {
        private static Lock lock = new ReentrantLock();
        private Map<String, Integer> datastore = new HashMap<>();

        public int dataSize() {
            return datastore.size();
        }

        public void store(Integer transactionId) {
            //lock.lock();

            try {
                Thread.sleep(5);
                datastore.put("Key "+transactionId, transactionId);
            } catch (InterruptedException ex) {

            } finally {
                //lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Integer> transactionIds = Arrays.asList(2,3,4);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int transactionId: transactionIds) {
            executorService.execute(new ThreadExam(transactionId));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {}

        System.out.println(data.dataSize());
        System.out.println(data.datastore);
    }
}
