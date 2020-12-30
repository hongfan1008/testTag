package com.example.demo.controller;

public class MyThread1 {

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("runnable is start");
        }
    }

//      public static void main(String[] args) {
//        Thread thread = new Thread(() -> {
//            System.out.println("thread start");
//        });
//        thread.start();
//    }


//    public static void main(String[] args) {
//        System.out.println("main start...");
//        Thread t = new Thread() {
//            public void run() {
//                System.out.println("thread run...");
//                System.out.println("thread end.");
//            }
//        };
//        t.start();
//        System.out.println("main end...");
//    }


//    public static void main(String[] args) {
//        System.out.println("main start...");
//        Thread t = new Thread() {
//            public void run() {
//                System.out.println("thread run...");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {}
//                System.out.println("thread end.");
//            }
//        };
//        t.start();
//        try {
//            Thread.sleep(30);
//        } catch (InterruptedException e) {}
////        t.setPriority(1);
//
//        System.out.println("main end...");
//    }


//    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> {
//            System.out.println("hello");
//        });
//        System.out.println("start");
//        t.start();
//        t.join();
//        System.out.println("end");
//    }


    class MyThread extends Thread {
        public void run() {
            int n = 0;
            while (! isInterrupted()) {
                n ++;
                System.out.println(n + " hello!");
            }
        }
    }


}
