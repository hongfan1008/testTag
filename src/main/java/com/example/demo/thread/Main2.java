package com.example.demo.thread;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main2 {

	private int count = 0;

	public synchronized void add(int n) {
		if (n < 0) {
			dec(-n);
		} else {
			count += n;
		}
	}

	public synchronized void dec(int n) {
		count += n;
	}

	public static void main(String[] args) {
		Thread t = new Thread3();
		// 如果注释下一行，观察Thread1的执行情况:
		t.setDaemon(true);//该线程标记为守护线程
		t.start();
		System.out.println(Thread.currentThread().getName()+": main: wait 3 sec...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("main: end.");
	}

}

class Thread3 extends Thread {

	public void run() {
		for (;;) {
			System.out.println(Thread.currentThread().getName()+": Thread-1: running...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}

