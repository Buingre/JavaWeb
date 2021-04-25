package test.thread0424;
/**
 * 线程的创建方式二：实现Runnable接口
 *
 * 【2-2常用】写法二:创建匿名Runnable类
 */
public class ThreadDemo6 {
    public static void main(String[] args) {
        //匿名类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程的名称:"+Thread.currentThread().getName());
            }
        });
        thread.start();//当前线程的名称:Thread-0
    }
}
