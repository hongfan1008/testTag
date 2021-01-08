package com.example.demo.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized可以配合wait和notify实现线程在条件不满足时等待，条件满足时唤醒。替换，使用Condition对象实现线程在条件不满足时等待，条件满足时唤醒
 */
public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue3 q = new TaskQueue3();
        List<Thread> ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            Thread t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println(getName()+"get task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };
            t.setName("线程"+i);
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println(Thread.currentThread().getName()+ "add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });
        add.setName("添加线程");
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            System.out.println("遍历" + t.getName());
            t.interrupt();
        }
    }




}

class TaskQueue2 {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}

class TaskQueue3{
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();


    public void addTask(String s){
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();//会唤醒所有等待线程
        }finally {
            lock.unlock();
        }

    }
    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()){
                condition.await();  //会释放当前锁，进入等待状态
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }

}



class TaskQueue4{
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();


    public void addTask(String s){
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();//会唤醒所有等待线程
        }finally {
            lock.unlock();
        }

    }
    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()){
                condition.await();  //会释放当前锁，进入等待状态
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }

}
