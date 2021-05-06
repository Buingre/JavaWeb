package test.thread0426;

/**
 * 线程状态实例
 */
public class ThreadDemo23 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(()->{



            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            synchronized (obj){
                    //todo:wait()
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });
        System.out.println("执行之前"+t1.getState());//执行之前NEW
        t1.start();
        System.out.println("start之后"+t1.getState());//start之后RUNNABLE
        Thread.sleep(100);
        System.out.println("sleep100ms之后"+t1.getState());//sleep100ms之后TIMED_WAITING

        //等待执行完成
        t1.join();//实现方式1
        //while (t1.isAlive()){}//实现方式2

        System.out.println("线程最终状态"+t1.getState());//线程最终状态TERMINATED




    }
}
