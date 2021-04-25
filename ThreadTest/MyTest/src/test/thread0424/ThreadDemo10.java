package test.thread0424;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  Thread常见构造方法---之---演示线程分组
 */
public class ThreadDemo10 {
    //
    private static final int count = 1000;

    //线程任务
    static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int a= 0;
            for (int i = 0;i<count;i++){
                a++;
            }
            return a;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程分组
        ThreadGroup threadGroup = new ThreadGroup("计算线程");

        MyCallable callable = new MyCallable();
        //创建线程，并把线程设置到分组中
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t1 = new Thread(threadGroup,futureTask);
        t1.setName("张三");
        t1.start();

        FutureTask<Integer> futureTask2 = new FutureTask<>(callable);
        Thread t2 = new Thread(threadGroup,futureTask2);
        t2.setName("李四");
        t2.start();

        //打印线程分组中所有线程信息
        threadGroup.list();

        //等待线程分组中的所有线程执行完，
        while (threadGroup.activeCount()!=0){

        }
        //todo: 有get不加while也可，新示例见老师的
        int total = futureTask.get()+futureTask2.get();
        System.out.println("执行结果："+total);
    }
}
