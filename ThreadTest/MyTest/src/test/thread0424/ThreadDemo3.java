package test.thread0424;

/**
 * 线程的创建方式一：缺陷：Java单继承，所以不能再继续继承其他类
 */
public class ThreadDemo3 {
    //【1-1】继承Thread类
    static class MyThread extends Thread{
        @Override
        public void run() {
            //业务代码
            //打印当前线程的名称
            System.out.println("子线程的名称:"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        //【1】继承Thread类
        MyThread myThread = new MyThread();
        //启动线程
        myThread.start();


        //主线程的名称
        System.out.println("主线程的名称:"+Thread.currentThread().getName());

    }
}
