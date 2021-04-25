package test.thread0424;
/**
 * 线程的创建方式二：实现Runnable接口
 *
 * 【2-3常用】写法三: Lambda+Runnable【注意事项：只有在jdk1.8之后】
 *
 *      Lambda如果报错：项目属性--》Modules--》查看是否为1.7，是的话  改为1.8
 *                      --》file--》settings--》Build--》Complain--》Java Complain--》修改为1.8
 */
public class ThreadDemo7 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("当前线程的名称:"+Thread.currentThread().getName());

        });
        thread.start();//当前线程的名称:Thread-0
    }
}
