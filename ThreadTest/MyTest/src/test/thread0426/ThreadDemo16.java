package test.thread0426;

/**
 *  run()  VS  start()
 */
public class ThreadDemo16 {
    public static void main(String[] args) {
        //todo:线程的第七种写法【属于第二类。适用于多个线程执行的任务是固定的任务，可以先把这个任务声明出来】
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程的名称:"+Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable,"张三");
        thread.run();//main

        //thread.start();//张三
    }
}
