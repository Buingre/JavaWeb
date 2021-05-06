package test.thread0426;

/**
 * 中断线程
 *      【1自定义终止(温柔的终止)、】
 */
public class ThreadDemo17 {
    /**
     * 自定义终止
     */
    public static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (!flag){
                //System.out.println("我正在转账...");
                try {
                    //休眠线程
                    Thread.sleep(100);
                    System.out.println("我正在转账...");

                } catch (InterruptedException e) {
                    e.printStackTrace();
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
        flag = true;
    }
}
