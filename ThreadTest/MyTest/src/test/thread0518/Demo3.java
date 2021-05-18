package test.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 修改线程池-------------自定义线程名称---【工厂方式来自定义线程的规则】
 */
public class Demo3 {
    private static int count = 1;
    /**
     * 自定义线程工厂
     */
    static class  MyThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {

            Thread thread = new Thread(r);//【入参】
            //设置名称
            thread.setName("mythreadpool-"+ count++);
            //设置优先级
            thread.setPriority(10);
            return thread;
        }
    }
    public static void main(String[] args) {
        //创建线程工厂
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        //创建一个固定个数的线程池,
        ExecutorService executorService = Executors.newFixedThreadPool(10,myThreadFactory);
        //执行任务
        for (int i = 0; i <10 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread t = Thread.currentThread();
                    System.out.println("线程名称："+ t.getName()+"优先级："+t.getPriority());//pool-1-thread-1
                }
            });
        }
    }
}
