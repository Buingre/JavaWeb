package test.thread0424;

/**
 * 对比单线程和多线程之间的执行时间
 */
public class ThreadDemo2 {
    //定义循环次数
    private static final long count   = 10_0000_0000L;
    public static void main(String[] args) throws InterruptedException {
        //调用单线程的方法
        serirl();
        //调用多线程的方法
        concurrentcy();

    }

    /**
     * 单线程的方法
     */
    private static void serirl() {
        //开始时间
        Long stime = System.currentTimeMillis();//得到当前毫秒时间戳
        int a= 0;
        for (int i = 0;i<count;i++){
            a++;
        }
        int b= 0;
        for (int i = 0;i<count;i++){
            b++;
        }
        int c= 0;
        for (int i = 0;i<count;i++){
            c++;
        }
        //记录结束时间
        Long etime = System.currentTimeMillis();
        System.out.println("单线程执行的时间："+(etime-stime));
    }

    /**
     * 多线程的方法
     */
    private static void concurrentcy() throws InterruptedException {//main方法是主线程
        //开始时间
        Long stime = System.currentTimeMillis();//得到当前毫秒时间戳

        //张三办理业务
        int a= 0;
        for (int i = 0;i<count;i++){
            a++;
        }
        //李四同时执行业务
        //创建新线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b= 0;
                for (int i = 0;i<count;i++){
                    b++;
                }
            }
        });
        //执行线程
        t1.start();

        //王五执行业务
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int c= 0;
                for (int i = 0;i<count;i++){
                    c++;
                }
            }
        });
        t2.start();

        //需要等待子线程执行完之后才行
        t1.join();//等t1线程执行完
        t2.join();//等t2线程执行完
        //记录结束时间
        Long etime = System.currentTimeMillis();
        System.out.println("多线程执行的时间："+(etime-stime));

    }
}
