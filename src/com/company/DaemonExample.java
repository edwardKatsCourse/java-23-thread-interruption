package com.company;

public class DaemonExample {

    public static void main(String[] args) throws InterruptedException {
	    //1. Daemon thread
        //2. Thread interruption

        //Thread types:
        //1. User thread (non-daemon, regular)
        //2. Daemon thread

        Thread thread = new Thread(new MyThread());
        thread.setDaemon(true);
        thread.start();
//        thread.join();
        System.out.println("Sleeping");
        Thread.sleep(5000);
        System.out.println("main ended");
        //Java waits for the last thread to finish
//        while (true) {}
    }
}


class MyThread implements Runnable {

    //"main" method for threads
    public void run() {
        while (true) {}
    }
}