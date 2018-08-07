package com.company;

public class InterruptedExceptionExample {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new InterruptedThread());
        t.start();


        Thread.sleep(3000);

        t.interrupt();

        //isInterrupted flag становится true только если тред не спит
        //если, в момент вызова interrupt, тред спит, то тред вылетит с Interrupted exception
        //если тред был разбужен через InterruptedException, то флаг isInterrupted не будет true
    }
}

class InterruptedThread implements Runnable {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println("Entering the while loop");
        while (!currentThread.isInterrupted()) {
            try {
                Thread.sleep(4_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 1_000_000; i++) {
                double d = Math.sqrt(1.0);
            }
        }
        System.out.println("Thread was interrupted");
    }
}