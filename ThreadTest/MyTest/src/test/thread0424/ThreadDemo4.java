package test.thread0424;
/**
 * 线程的创建方式一：缺陷：Java单继承，所以不能再继续继承其他类
 */
/**
 * 【1-2】继承Thread类  变形
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("当前线程的名称:"+Thread.currentThread().getName());
            }
        };
        //运行线程
        thread.start();
    }
}
