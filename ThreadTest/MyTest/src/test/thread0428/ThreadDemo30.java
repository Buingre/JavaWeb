package test.thread0428;

/**
 *   volatile
 */
public class ThreadDemo30 {
    //循环次数
    private static  final int maxSize = 100000;
    //全局遍量
    private static volatile int number = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <maxSize ; i++) {
                    number++;
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <maxSize ; i++) {
                    number--;
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("最终结果："+number);

    }
}
