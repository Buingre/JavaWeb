package test.thread0522;

/**
 * 【脏读】因为线程池会复用线程相关的静态属性
 *      【解决】1.避免使用静态变量
 *             2.使用remove
 * TODO:完成代码  80
 *
 */
public class Demo12{
    static  ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        //线程池


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
