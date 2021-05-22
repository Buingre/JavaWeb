package thread0522_3;

import java.util.Random;

/**
 * 阻塞队列: 用数组实现
 */
public class Demo1 {
    static class MyBlockingQueue{
        private int[] values; //存放数据的数组
        private int first; //队首下标
        private int last; //队尾下标
        private int size; //实际队列大小
        public MyBlockingQueue(int maxSize){//最大容量
            //初始化队列
            values = new int[maxSize];
            first = 0;
            last = 0;
            size = 0;
        }

        //添加到队尾
        public void offer(int val) throws InterruptedException {
            synchronized (this) {
                //判断容量是否达到最大值
                if (size == values.length) {
                    //阻塞等待、消费者消费
                    this.wait();
                }
                values[last++] = val;
                size++;
                //判断是否是最后一个元素
                if(last==values.length){
                    last = 0;//循环队列
                }
                //唤醒消费者取队列中的信息
                this.notify();
            }
        }

        /**
         * 取队首元素
         * @return
         */
        public int poll() throws InterruptedException {
            int result = 0;
            synchronized (this){
                //判断队列有没有元素
                if(size == 0){
                    this.wait();//阻塞等待
                }
                result = values[first++];
                size--;
                //判断first 是否是最后一个元素
                if(first == values.length){
                    first = 0;
                }
                //唤醒生产者继续 生产
                this.notify();
            }
            return result;
        }


    }

    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(100);
        //生产者
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                //生产数据
                while (true){

                    int num = new Random().nextInt(10);
                    System.out.println("生产数据："+num);


                    try {
                        myBlockingQueue.offer(num);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();


        //消费者
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //生产数据
                while (true){
                    try {
                        int res = myBlockingQueue.poll();
                        System.out.println("消费数据："+res);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
    }
}
