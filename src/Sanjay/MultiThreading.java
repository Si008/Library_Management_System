package Sanjay;

// class Threadexample extends Thread
//      {
//        public void run() {
//            for (int i = 1; i <= 5; i++) {
//                System.out.println("From MyThread: " + i);
//                try {
//                    Thread.sleep(1000); // Sleep for 500 milliseconds
//                } catch (InterruptedException e) {
//                    System.out.println(e);
//                }
//            }
//        }
//    }
class WorkerThread extends Thread {
    private String name;

    public WorkerThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " is working on task " + i);
            System.out.println("-------------------------------");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
            }
        }
        System.out.println(name + " has completed work.");
    }
}

    public class MultiThreading  {
        public static void main(String[] args) {
            WorkerThread t1 = new WorkerThread("Sanjay");
            WorkerThread t2 = new WorkerThread("Panner");
            WorkerThread t3 = new WorkerThread("Kavin");

            // Start all threads
            t1.start();
            t2.start();
//            try{
//                t1.join();
//            }
//            catch (InterruptedException e){
//                System.out.println(e);
//            }
//            t2.start();
//            try{
//                t2.join();
//            }
//            catch (InterruptedException e){
//                System.out.println(e);
//            }
//
//            t3.start();
//            try{
//                t3.join();
//            }
//            catch (InterruptedException e){
//                System.out.println(e);
//            }
            

            // Optional: set priorities
//            t1.setPriority(Thread.MAX_PRIORITY);
//            t2.setPriority(Thread.NORM_PRIORITY);
//            t3.setPriority(Thread.MIN_PRIORITY);
        }
//        public static void main(String[] args) {
//            Threadexample t1 = new Threadexample();
//            t1.start(); // Starts the thread
//
//            for (int i = 1; i <= 5; i++) {
//                System.out.println("From main thread: " + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    System.out.println(e);
//                }
//            }
//        }
    }



