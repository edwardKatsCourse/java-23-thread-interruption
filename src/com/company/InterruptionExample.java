package com.company;

public class InterruptionExample {

    public static void main(String[] args) throws InterruptedException {
        //Interrupt
        Thread thread = new Thread(new ThreadToInterrupt());

        thread.start();
        Thread.sleep(3000);
//        thread.stop();
        thread.interrupt();
        thread.join();

        System.out.println("Main ended");
    }
}


class ThreadToInterrupt implements Runnable {
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();

        boolean flag = true;
        while (true) {
            if (currentThread.isInterrupted() && flag) {
                System.out.println("I was interrupted!");
                flag = false;
//                break;
            }
        }
//        System.out.println("goodbye!");
    }
}