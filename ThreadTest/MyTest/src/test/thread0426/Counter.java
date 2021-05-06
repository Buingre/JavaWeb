package test.thread0426;

public class Counter {
    //私有变量count
    private int count =  0;
    //循环执行的次数
    private final int maxSize = 10000000;


    //加法
    public void increment(){
        for (int i = 0; i <maxSize ; i++) {
            count++;
        }
    }
    //减法
    public void decrement(){
        for (int i = 0; i <maxSize ; i++) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
