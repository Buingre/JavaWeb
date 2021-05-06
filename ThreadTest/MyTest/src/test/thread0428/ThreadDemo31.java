package test.thread0428;

/**
 *  加锁 【synchronized (lock)】
 *
 *  todo:查看字节码
 */
public class ThreadDemo31 {
    //循环次数
    private static  final int maxSize = 100000;
    //全局遍历
    private static volatile int number = 0;
    public static void main(String[] args) throws InterruptedException {
        //【1】声明锁对象
        //
        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <maxSize ; i++) {
                    //【2】对所有不安全的代码加锁
                    synchronized (lock){
                        number++;
                    }

                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <maxSize ; i++) {
                    synchronized (lock){
                        number--;
                    }

                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("最终结果："+number);//0

    }
}
