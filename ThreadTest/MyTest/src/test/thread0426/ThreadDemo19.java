package test.thread0426;

/**
 * * 中断线程
 *  *      【2    interrupt();  及时终止，但是会报异常】------->不加sleep
 *          【3  使用stop----》已经不用了】
 */
public class ThreadDemo19 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
//            while (!Thread.interrupted()){
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("我在转账");
            }
            System.out.println("终止转账");
        });
        t1.start();

        Thread.sleep(10);
        System.out.println("有内鬼，终止交易");
        t1.interrupt();//将t1中的interrupted()改为true，所以会跳出循环
    }
}
