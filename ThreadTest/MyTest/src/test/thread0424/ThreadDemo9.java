package test.thread0424;

/**
 * Thread常见构造方法
 */
public class ThreadDemo9 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("当前线程的名称:"+Thread.currentThread().getName());
            try {
                Thread.sleep(9999999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"张三");
    }
}
