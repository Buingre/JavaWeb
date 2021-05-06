package test.thread0426;

/**
 * *  演示静态方法和普通方法的区别
 * Thread.interrupted()静态方法
 * Thread.currentThread().isInterrupted()普通方法
 */
public class ThreadDemo20 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {

                //静态方法
//                System.out.println(Thread.interrupted());//true f f f f f f

                //普通方法
                System.out.println(Thread.currentThread().isInterrupted());//t t t t
            }
        });
        thread.start();
        //主线程终止子线程
        thread.interrupt();
    }
}
