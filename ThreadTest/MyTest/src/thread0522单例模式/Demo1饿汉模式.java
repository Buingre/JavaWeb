package thread0522单例模式;

/**
 * 饿汉模式：实现简单，线程安全（因为饿汉的方式是随着程序的启动而初始化的，因为类加载时线程安全，所以他是线程安全）、
 *     缺点：随着程序的启动而启动，有可能在整个程序的运行周期都没用到，这样就带来了不必要的开销
 *
 */
public class Demo1饿汉模式 {
    //单例类
    static class Singleton{
        //1.将构造函数设置为私有：不让外部创建（允许创建的话就为多例了）
        private Singleton(){}
        //2.创建一个静态的类变量，让第三步的方法进行返回
        private static Singleton singleton = new Singleton();
        //3.给外部提供的获取单例的方法
        public static Singleton getInstance(){
            return singleton;
        }
    }

    static Singleton s1 = null;
    static Singleton s2 = null;
    public static void main(String[] args) throws InterruptedException {
        //测试单例类

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s1 = Singleton.getInstance();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                s2 = Singleton.getInstance();
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(s1==s2);//true-->说明就是单例的
    }
}
