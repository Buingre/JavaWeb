package test.thread0424;

/**
 * 线程的创建方式二：实现Runnable接口
 *
 * 【2-1】写法一
 */

public class ThreadDemo5 {
    //静态内部类，写外边也可
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("当前线程的名称:"+Thread.currentThread().getName());

        }
    }
    public static void main(String[] args) {
        //1.
        MyRunnable myRunnable = new MyRunnable();
        //myRunnable.run();//不对的----》当前线程的名称:main

        //2.
        Thread thread = new Thread(myRunnable);
        thread.start();//当前线程的名称:Thread-0
    }
}
