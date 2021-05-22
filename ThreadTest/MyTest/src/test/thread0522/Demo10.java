package test.thread0522;

/**
 * 即使使用了InheritableThreadLocal，也不能实现并列线程之间的数据传输
 * 线程1、2不属于父子关系，所以不会继承，而且我们使用 ThreadLocal的初衷就是线程安全
 */
public class Demo10 {
    //创建
    private static ThreadLocal threadLocal = new InheritableThreadLocal();
    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("java");
                System.out.println("线程1设置："+threadLocal.get());
            }
        });
        t1.start();
        t1.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("线程2获取："+threadLocal.get());
            }
        });
        t2.start();


    }
}
