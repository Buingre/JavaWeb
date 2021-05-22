package test.thread0522;

/**
 * 【脏读】在一个线程中读取到了不属于自己的信息
 *
 * 【正常情况】
 */
public class Demo11不使用remove的问题 {
    static  ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        //线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                MyThreadLocal myThreadLocal = new MyThreadLocal();
                myThreadLocal.show();
            }
        },"线程1");
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                MyThreadLocal myThreadLocal = new MyThreadLocal();
                myThreadLocal.show();
            }
        },"线程2");
        t2.start();

    }

    static class MyThreadLocal{
        private static boolean flag = false;
        public void show(){
            String tname = Thread.currentThread().getName();
            if(!flag){
                //第一次执行

                threadLocal.set(tname);
                System.out.println(tname+" 设置了： "+tname);
                flag=true;
            }
            System.out.println(tname+" 得到了： "+threadLocal.get());
        }
    }
}
