package thread0522单例模式;

/**
 * TODO:86
 */
public class Demo3 {
    static class Singleton{
        //1.将构造函数设置为私有：不让外部创建（允许创建的话就为多例了）
        private Singleton(){}
        //2.创建一个静态的类变量，让第三步的方法进行返回
        private static Singleton singleton = null;
        //3.给外部提供的获取单例的方法
        public static Singleton getInstance(){
            if(singleton == null){
                //第一次访问,进行实例化
                singleton = new Singleton();
            }
            return singleton;
        }

    }
    static Singleton s1 = null;
    static Singleton s2 = null;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取单例对象
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

        System.out.println(s1==s2);//true--
    }
}

