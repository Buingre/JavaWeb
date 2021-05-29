package thread0526多线程高阶;

/**
 * 可重入锁
 */
public class Demo8可重入锁 {
    // 声明一把锁
    private static Object object = new Object();

    public static void main(String[] args) {

        synchronized (object) {
            System.out.println("进入了方法");
            synchronized (object) {
                System.out.println("重复进入了方法");
            }
        }
    }
}
