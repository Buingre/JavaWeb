package test.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO:演示内存溢出
 */
public class Demo9 {
    static class MyOOMClass{
        //1M空间  M KB Nyte
        private static byte[] bytes= new byte[1*1024*1024];
        //设置-Xms 10m

    }
    public static void main1(String[] args) throws InterruptedException {
        Thread.sleep(15*1000);
        ExecutorService executorService =Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            final int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    new MyOOMClass();
                    System.out.println("任务："+finalI);
                }
            });
        }

    }
}
