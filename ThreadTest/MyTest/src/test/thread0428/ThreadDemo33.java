package test.thread0428;
/**
 * synchronized的三种使用场景-----》修饰普通方法
 */
public class ThreadDemo33 {
    // 全局变量
    private static int number = 0;
    // 循环次数
    private static final int maxSize = 100000;

    public static void main(String[] args) throws InterruptedException {

        ThreadDemo33 threadDemo33 = new ThreadDemo33();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadDemo33.increment();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadDemo33.decrement();
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("最终执行结果：" + number);//0
    }

    // 相加
    public synchronized void increment() {
        for (int i = 0; i < maxSize; i++) {
            number++;
        }
    }

    // 相减
    public synchronized void decrement() {
        for (int i = 0; i < maxSize; i++) {
            number--;
        }
    }

}