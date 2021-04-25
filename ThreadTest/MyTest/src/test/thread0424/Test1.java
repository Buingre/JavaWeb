package test.thread0424;

/**
 * 【面试题】
 * 使用两个线程打印AABBCCDD
 * 每个线程只能打印ABCD
 *
 * todo:老师的方法
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{

            try {
                System.out.print("A");
                Thread.sleep(300);
                System.out.print("BC");
//                Thread.sleep(100);
//                System.out.print("C");
                Thread.sleep(100);
                System.out.print("D");
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();


        Thread t2 = new Thread(()->{

            try {
                Thread.sleep(100);
                System.out.print("A");
                Thread.sleep(100);
                System.out.print("B");
                Thread.sleep(100);
                System.out.print("C");
                Thread.sleep(100);
                System.out.print("D");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t2.start();

        t1.join();
        t2.join();

    }
}
