package ru.letnes.Multithreading.demo1;

public class Demo1 {

  public static void main(String[] args) throws InterruptedException {
/*    for (int i = 0; i < 10; ++i) {
        new Thread(new HelloRunnable()).start();
    }*/
    Thread thread = new Thread(new HelloRunnable());
    thread.setDaemon(true);
    thread.start();

    thread.join(5000L);
    System.out.println("Hello from main thread");
  }

/*  private static class HelloThread extends Thread {
    @Override public void run() {
      System.out.println("Hello from " + this.getName());
    }
  }*/

      private static class HelloRunnable implements Runnable {
          @Override
          public void run() {
            for (int i = 0; i < 10; i++) {
              try {
                System.out.println("I am running!");
                Thread.sleep(1000L);
              } catch (InterruptedException e) {
                System.out.println("I am interrupted!");
              }
            }
          }
      }
}
