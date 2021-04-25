package test.thread0424;

/**
 * 演示线程的常见属性
 */
public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程，添加任务
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
                System.out.println("线程ID："+t.getId());
                System.out.println("线程名称："+t.getName());
                System.out.println("线程状态："+t.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        //启动线程
        t1.start();
        Thread.sleep(100);
        //打印线程状态
        System.out.println("t1线程状态："+t1.getState());//TIMED_WAITING
        //todo:打印线程优先级----》默认为5
        System.out.println("t1线程优先级："+t1.getPriority());//5
        //todo:是否为守护线程
        System.out.println("t1是否为守护线程："+t1.isDaemon());//false
        //打印线程是否存活
        System.out.println("是否存活："+t1.isAlive());//true
        //todo:(后边讲)打印线程是否被中断
        System.out.println("t1线程是否被中断："+t1.isInterrupted());//false

        //todo:等待线程执行完的两种方式
        t1.join();//方式【1】
        while (!t1.isAlive()){}//方式【2】
    }
}
