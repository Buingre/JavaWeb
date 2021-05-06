package test.thread0426;

/**
 * 【线程的状态】
 */
public class ThreadDemo22 {
    public static void main(String[] args) {
        for (Thread.State state:Thread.State.values()){
            System.out.println(state);
        }
    }
}
