package xian.bishi.lynj0930.T2多线程交替打印奇偶数;

/**
 * 提交的答案
 *
 * @Author: jjxian
 */
public class Solution2 {
    private final int maxCount; // 最大数字

    public Solution2(int maxCount) {
        this.maxCount = maxCount;
    }

    // 开启两个线程分别打印奇数和偶数
    public void start() throws InterruptedException {
        // 线程 OddThread 调用 printOdd();
        Thread oddThread = new Thread(() -> {
            try {
                printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "OddThread");

        // 线程 EvenThread 调用 printEven();
        Thread evenThread = new Thread(() -> {
            try {
                printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "EvenThread");

        // 启动两个线程
        oddThread.start();
        evenThread.start();

        // 等待子线程执行完成
        oddThread.join();
        evenThread.join();
    }

    private static int count = 1;
    private static Object lock = new Object();


    public void printOdd() throws InterruptedException {
        while (count <= maxCount) {
            synchronized (lock) {
                while (count % 2 == 0) {
                    lock.wait();
                }
                if (count <= maxCount) {
                    System.out.println(Thread.currentThread().getName() + "-" + count);
                    count++;
                    lock.notifyAll(); // 唤醒等待的线程
                }
            }
//
//
//            synchronized (lock) {
//                if (count % 2 == 1) {
//                    System.out.println(Thread.currentThread().getName() + "-" + count);
//                    count++;
//                    lock.notify();
//                } else {
//                    lock.wait();
//                }
//            }
        }
    }

    public void printEven() throws InterruptedException {
        while (count <= maxCount) {
            synchronized (lock) {
                while (count % 2 == 1) {
                    lock.wait();
                }
                if (count <= maxCount) {
                    System.out.println(Thread.currentThread().getName() + "-" + count);
                    count++;
                    lock.notifyAll(); // 唤醒等待的线程
                }
            }
//            synchronized (lock) {
//                if (count % 2 == 0) {
//                    System.out.println(Thread.currentThread().getName() + "-" + count);
//                    count++;
//                    lock.notify();
//                } else {
//                    lock.wait();
//                }
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution(100);
        solution.start(); // 启动打印
    }
}
