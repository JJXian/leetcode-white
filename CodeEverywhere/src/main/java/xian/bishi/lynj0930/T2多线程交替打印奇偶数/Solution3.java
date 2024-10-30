package xian.bishi.lynj0930.T2多线程交替打印奇偶数;

/**
 * @Author: jjxian
 */
public class Solution3 {
    private Object lock = new Object();
    private final int maxCount;
    private int count = 1;

    public Solution3(int maxCount) {
        this.maxCount = maxCount;
    }

    public void start() {
        Thread oddThread = new Thread(() -> {
            try {
                printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "OddThread");


        Thread evenThread = new Thread(() -> {
            try {
                printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "evenThread");

        oddThread.start();
        evenThread.start();
    }


    public void printOdd() throws InterruptedException {
        while (count <= maxCount) {
            synchronized (lock) {
                if (count % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + "-" + count);
                    count++;
                    lock.notify();
                } else {
                    lock.wait();
                }
            }
        }
    }

    public void printEven() throws InterruptedException {
        while (count <= maxCount) {
            synchronized (lock) {
                if (count % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-" + count);
                    count++;
                    lock.notify();
                } else {
                    lock.wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution3 t = new Solution3(100);
        t.start();
    }

}
