package com.example.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CopyOnWriteArrayListTest {

    private static List<Integer> list = new ArrayList<>();

//    public  static synchronized  void add() {
//        list.add(1);
//    }

    private static final Lock lock = new ReentrantLock();

    public static void add() {
        //加锁
        lock.lock();
        try {
            list.add(1);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            //释放锁
            lock.unlock();
        }
    }
    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> add()).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
