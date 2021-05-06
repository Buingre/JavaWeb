package test.thread0424;

/**
 * 【面试题】
 * 使用两个线程打印AABBCCDD
 * 每个线程只能打印ABCD
 *
 * todo:老师的方法，在下面
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

/**
 * 老师的答案
 */
class ThreadDemo14 {
    private static final String str = "ABCD";

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (char item : str.toCharArray()) {
                System.out.print(item);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main2(String[] args) throws InterruptedException {

        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();

        Thread t2 = new Thread(myRunnable);
        t2.start();

        t1.join();
        t2.join();

    }
}
