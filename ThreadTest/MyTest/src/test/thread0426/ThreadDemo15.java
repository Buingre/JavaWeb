package test.thread0426;

/**
 * 【守护线程注意的点】
 */
public class ThreadDemo15 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // 新创建了一个线程
            Thread t1 = new Thread(() -> {
            }, "t1");
            System.out.println("t1 守护线程：" + t1.isDaemon());

            System.out.println("thread 线程名：" +
                    Thread.currentThread().getName());
        },"thread");
        System.out.println("thread是否为守护线程："+thread.isDaemon());
        //设置守护线程
        thread.setDaemon(true);

        thread.start();
        thread.join();

        System.out.println("thread是否为守护线程："+thread.isDaemon());


    }
}
