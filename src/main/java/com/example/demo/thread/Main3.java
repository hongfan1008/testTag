package com.example.demo.thread;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
//死锁
public class Main3 {

	static final Object LOCK_A = new Object();
	static final Object LOCK_B = new Object();

	public static void main(String[] args) {
		new ThreadTest1().start();
		new ThreadTest2().start();
	}

	static void sleep1s() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadTest1 extends Thread {

	public void run() {
		System.out.println("Thread-1: try get lock A...");
		synchronized (Main3.LOCK_A) {
			System.out.println("Thread-1: lock A got.");
			Main3.sleep1s();
			System.out.println("Thread-1: try get lock B...");
			synchronized (Main3.LOCK_B) {
				System.out.println("Thread-1: lock B got.");
				Main3.sleep1s();
			}
			System.out.println("Thread-1: lock B released.");
		}
		System.out.println("Thread-1: lock A released.");
	}
}

class ThreadTest2 extends Thread {

	public void run() {
		System.out.println("Thread-2: try get lock B...");
		synchronized (Main3.LOCK_A) {
			System.out.println("Thread-2: lock B got.");
			Main3.sleep1s();
			System.out.println("Thread-2: try get lock A...");
			synchronized (Main3.LOCK_B) {
				System.out.println("Thread-2: lock A got.");
				Main3.sleep1s();
			}
			System.out.println("Thread-2: lock A released.");
		}
		System.out.println("Thread-2: lock B released.");
	}
}
