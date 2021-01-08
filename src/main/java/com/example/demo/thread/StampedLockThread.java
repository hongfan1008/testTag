package com.example.demo.thread;

import java.util.concurrent.locks.StampedLock;

public class StampedLockThread extends Thread{
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;
    @Override
    public void run() {

        move(2,4);
        double v = distanceFromOrigin();
        System.out.println(v);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void move(double deltaX, double deltaY){
        long l = stampedLock.writeLock();  // 获取写锁
        try{
            x += deltaX;
            y += deltaY;

        }finally {
            stampedLock.unlockWrite(l); // 释放写锁
        }
    }

    public double distanceFromOrigin(){
        long l = stampedLock.tryOptimisticRead();
        double currentX = x;

        double currentY = y;

        if (!stampedLock.validate(l)){
            l = stampedLock.readLock();

            try {
                currentX = x;
                currentY = y;
            }finally {
                stampedLock.unlockRead(l);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
class Test4{

    public static void main(String[] args) {
        StampedLockThread s = new StampedLockThread();
        s.start();
    }

}
