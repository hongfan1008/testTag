package com.example.demo.thread;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock
 * 只允许一个线程写入（其他线程既不能写入也不能读取）；
 * 没有写入时，多个线程允许同时读（提高性能）。
 */
public class ReadWriteLockThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main函数开始。。。。。。。。。");
        Counter2 c = new Counter2();
        for (int i = 0; i<5; i++){
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        int[] ints = c.get();
                        System.out.println(Thread.currentThread().getName() + ": get task: " + Arrays.toString(ints));
                    } catch (Exception e) {
                        return;
                    }
                }
            });
            t.setName("线程"+i);
            t.start();
        }

//        t.join();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ": add task:" + i);
                c.inc(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        });
        t2.setName("线程二");
        t2.start();
//        t2.join();
//        Thread.sleep(100);

        System.out.println("main函数结束。。。。。。。。。。。。");
    }
}
 class Counter2 {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[3];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}
