package test.thread0518;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 线程池执行的两种方式：无返回值execute(new Runnable..)、
 *                    有返回值的submit (Runnable 无返回值/Callable 有返回值)
 */
public class Demo14 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10,10,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>(100));
        //执行任务方式1
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行execute方法");
            }
        });
        //执行任务方式2
         Future<Integer> future =threadPoolExecutor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                //生产随机数
                int num = new Random().nextInt(10);
                System.out.println("执行submit方法,随机数："+num);
                return num;
            }
        });
        System.out.println("得到线程池的执行结果："+future.get());
        //
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行submit方法,使用的Runnable对象");

            }
        });

        threadPoolExecutor.shutdown();

    }
}
