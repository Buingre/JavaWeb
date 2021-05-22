package test.thread0522;

/**
 * ThreadLocal【问题1】：不可继承--->子线程访问不到主线程set的值
 *                     正常情况子线程可以得到主线程的
 *
 *                  【解决】：InheritableThreadLocal
 *
 *            【脏数据】
 *                  【解决】1.避免使用静态变量
 *  *                      2.使用remove
 *            【内存溢出】
 *
 */
public class Demo9ThreadLocal问题1 {
    //创建
    private static ThreadLocal threadLocal = new InheritableThreadLocal();
    public static void main(String[] args) {
        //在主线程里边set值
        threadLocal.set("java");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
            }
        });
        t1.start();
    }
}
