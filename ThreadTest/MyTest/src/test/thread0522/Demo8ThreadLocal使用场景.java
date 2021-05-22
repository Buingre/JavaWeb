package test.thread0522;

/**
 * ThreadLocalDemo75

 * ThreadLocal使用场景: 1.解决线程安全问题
 *                     2.可以实现线程级别的数据传递. TODO:代码完成
 */
public class Demo8ThreadLocal使用场景 {
    /**
     * 创建一个实体类
     */
    static class User{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        Storage2 storage2 = new Storage2();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //用户登录
                storage.printName3();
                storage2.printName3();
            }
        });
        t1.start();
    }

    /**
     * 仓储类
     */
    static class Storage{
//        //耦合
//        private void printName(User user){
//            System.out.println(user.getName());
//        }
//        //耦合
//        private void printName(){
//            System.out.println(new UserStorage().getUser().getName());
//        }
        //解耦，不用调用类
        private void printName3(){
            User user = userThreadLocal.get();
            System.out.println(user.getName());
        }

    }
    private static ThreadLocal<User> userThreadLocal = new ThreadLocal(){
        @Override
        protected User initialValue() {
           User user = new User();
            user.setName("小A");
            return user;
        }
    };
    /**
     * 类2
     */
    static class Storage2{
        private void printName3(){
            User user = userThreadLocal.get();
            System.out.println(user.getName());
        }
    }

    class UserStorage{

        public User getUser(){
            User user = new User();
            user.setName("小A");
            return user;
        }

    }
}


