package com.example.demo.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock替代synchronized进行线程同步
 */
class MyThread8 extends Thread{
    private static int ticket = 100;
    private final static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
//            synchronized (MyThread8.class){
//                int n = 1;
//            lock.lock();
//            try{
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (ticket>0){
//                    System.out.println(getName() + "买票，票号是: " + ticket);
//                    ticket--;
//                    Thread.interrupted();
//                }else {
//                    break;
//                }
            test2();
//            }finally {
//                lock.unlock();
//            }

//            }
        }
    }

    public  static void test(){
        synchronized(MyThread8.class){
            if (ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "买票，票号是: " + ticket);
                ticket--;
//                Thread.interrupted();
            }
        }

    }

    public static  synchronized void test3(){
        if (ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买票，票号是: " + ticket);
            ticket--;
//                Thread.interrupted();
        }
    }


    public static void test2(){
        lock.lock();
        try {
            if (ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "买票，票号是: " + ticket);
                ticket--;
            }
        } finally {
            lock.unlock();
        }

    }
}
public class Main6{
    public static void main(String[] args) {
        System.out.println("main函数开始执行。。。。。。。。。");
        MyThread8 myThread8 = new MyThread8();
        MyThread8 myThread81 = new MyThread8();
        MyThread8 myThread82 = new MyThread8();
        myThread8.setName("窗口一");
        myThread81.setName("窗口二");
        myThread82.setName("窗口三");

        try {
            myThread8.start();
            myThread81.start();
//            myThread81.interrupt();
            myThread82.start();
//            myThread82.interrupt();
            myThread8.join();

            myThread81.join();

            myThread82.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main函数结束执行。。。。。。。。。。");

    }

}
