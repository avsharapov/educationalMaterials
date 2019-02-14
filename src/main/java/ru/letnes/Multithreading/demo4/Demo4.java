package ru.letnes.Multithreading.demo4;

public class Demo4 {

  public static void main(String[] args) throws Exception {
    Account account = new Account(0);

    new DepositThread(account).start();

    account.waitAndWithdraw(50_000_000);

    System.out.println("waitAndWithdraw finished, end balance = " + account.getBalance());
  }

  private static class DepositThread extends Thread {

    private final Account account;

    private DepositThread(Account account) {
      this.account = account;
    }

    @Override public synchronized void run() {
      for (int i = 0; i < 50_000_000; ++i) {
        account.deposit(1);
      }
    }
  }
}
