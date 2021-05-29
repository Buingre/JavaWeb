package thread0529JUC;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 【信号量】----可以实现限流功能:  此案例限流为2
 */
public class Demo1_信号量Semaphore  {
    public static void main(String[] args) {
        //创建信号量
        Semaphore semaphore = new Semaphore(2);

        //创建线程池来执行任务
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,
                0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        //执行任务1
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 车辆到达了停车场门口");
                try {
                    Thread.sleep(1000);
                    //尝试获得停车位（尝试获取锁）
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //表示已经获取到停车位
                System.out.println(Thread.currentThread().getName()+" 进入了停车场");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" 离开了停车场");
                //释放锁
                semaphore.release();
            }
        });


        //执行任务2
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 车辆到达了停车场门口");
                try {
                    Thread.sleep(1000);
                    //尝试获得停车位（尝试获取锁）
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //表示已经获取到停车位
                System.out.println(Thread.currentThread().getName()+" 进入了停车场");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" 离开了停车场");
                //释放锁
                semaphore.release();
            }
        });

        //执行任务3
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 车辆到达了停车场门口");
                try {
                    Thread.sleep(1000);
                    //尝试获得停车位（尝试获取锁）
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //表示已经获取到停车位
                System.out.println(Thread.currentThread().getName()+" 进入了停车场");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" 离开了停车场");
                //释放锁
                semaphore.release();
            }
        });

        //执行任务4
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 车辆到达了停车场门口");
                try {
                    Thread.sleep(1000);
                    //尝试获得停车位（尝试获取锁）
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //表示已经获取到停车位
                System.out.println(Thread.currentThread().getName()+" 进入了停车场");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" 离开了停车场");
                //释放锁
                semaphore.release();
            }
        });


    }
}
