package test.thread0426;

/**
 *  等待一个线程【join】
 *  eg:张三李四交接司机
 */
public class ThreadDemo21 {
    public static void main(String[] args) throws InterruptedException {


        //定义统一任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"上班");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"下班");

            }
        };

        Thread t1 = new Thread(runnable,"张三");
        t1.start();

        //等待线程t1执行完成
//        t1.join();
        t1.join(1200);

        Thread t2 = new Thread(runnable,"李四");
        t2.start();
    }
}
