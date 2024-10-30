package xian.bishi.lynj0930.T2多线程交替打印奇偶数;

class Solution {

    private final int maxCount; // 最大数字
    private int count = 1; // 计数器，初始为1
    private final Object lock = new Object(); // 锁对象

    public Solution(int maxCount) {
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


    public void printOdd() throws InterruptedException {
        while (count <= maxCount) {
            synchronized (lock) {
                if (count % 2 != 0) { // 判断是否为奇数
                    System.out.println(Thread.currentThread().getName() + "-" + count);
                    count++;
                    lock.notify(); // 唤醒偶数线程
                } else {
                    lock.wait(); // 当前线程等待
                }
            }
        }
    }

    public void printEven() throws InterruptedException {
        while (count <= maxCount) {
            synchronized (lock) {
                if (count % 2 == 0) { // 判断是否为偶数
                    System.out.println(Thread.currentThread().getName() + "-" + count);
                    count++;
                    lock.notify(); // 唤醒奇数线程
                } else {
                    lock.wait(); // 当前线程等待
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution(100);
        solution.start(); // 启动打印
    }
}