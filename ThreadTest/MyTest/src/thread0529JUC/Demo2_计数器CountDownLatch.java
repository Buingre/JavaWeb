package thread0529JUC;

import java.util.Random;
import java.util.concurrent.*;

/**
 * TODO:修改代码
 * 【计数器实例】---等待所有的线程进入某个步骤之后，再统一执行某个流程
 *
 *                缺点：只能使用一次
 */
public class Demo2_计数器CountDownLatch {
    public static void main(String[] args) {
        //创建CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,
                0, TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));
        //参赛选手1
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 开跑");

                int num = new Random().nextInt(5);
                num += 1;
                try {
                    Thread.sleep(num*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 到达了终点");

                try {
                    //阻塞等待其他线程，也到达此处
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //说明所有的线程都到达了终点
                System.out.println("宣布排名,比赛完成");
            }
        });


    }
}
