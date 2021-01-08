package com.example.demo.thread;

public class ReentrantLockThread {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        mThread.start();
        MThread mThread2 = new MThread();
        mThread2.start();

    }





}
class MThread extends Thread {
    private static int count;
    @Override
    public void run() {
        try {
            add(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void add(int n) throws InterruptedException {
//        synchronized(this) {
            Thread.sleep(200);
            count += n;
            System.out.println(count);
//        }
    }
}