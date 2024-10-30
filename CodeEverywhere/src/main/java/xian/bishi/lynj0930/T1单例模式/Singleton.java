package xian.bishi.lynj0930.T1单例模式;

/**
 * @Author: jjxian
 */
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    ;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    return new Singleton();
                }
            }
        }
        return instance;
    }


}
