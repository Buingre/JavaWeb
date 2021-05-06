package test.thread0426;
/**
 * 中断线程
 *      【2    interrupt();  及时终止，但是会报异常】
 */
public class ThreadDemo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (!Thread.interrupted()){
                //System.out.println("我正在转账...");
                try {
                    //休眠线程
                    Thread.sleep(100);
                    System.out.println("我正在转账...");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //todo:为啥break
                    break;
                }
            }
            System.out.println("a？差点误了大事。");
        },"张三");
        //开启任务
        t1.start();

        //休眠主线程
        Thread.sleep(310);

        //终止线程

        System.out.println("停止交易，有内鬼~");
        t1.interrupt();
    }
}
