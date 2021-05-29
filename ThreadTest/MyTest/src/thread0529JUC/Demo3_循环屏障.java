package thread0529JUC;

import java.util.concurrent.*;

/**
 * TODO:完善代码
 * 解决CountDownLatch的不能重复使用
 */
public class Demo3_循环屏障 {
    public static void main(String[] args) {
        //创建屏障
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("----------到达了屏障--------");
            }
        });

        ThreadPoolExecutor executor =new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));

        for (int i = 0; i < 4 ; i++) {


            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 进入了任务");
                    try {
                        //等待其他线程执行
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 执行结束");

                }
            });

        }
    }
}
