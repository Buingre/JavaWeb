package test.thread0426;

import java.util.Scanner;

/**
 * 线程安全：不可见问题
 */

public class ThreadDemo28 {

        public static  boolean flag = false;

        public static void main(String[] args) {

            Thread t1 = new Thread(() -> {
                while (!flag) {
                    //todo:当这里没有代码时，编译器会自动优化，这里的flag一直用的是工作内存中的，
                    // 所以会造成内存不可见问题
                    //todo:当这里边有代码时，编译器就不会自动优化了

                    /* System.out.println("...");*/
                }
                System.out.println("线程1执行结束");
            });
            t1.start();

            Thread t2 = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                System.out.print("->");
                //scanner.nextInt();
                flag = true;
            });
            t2.start();

        }
    }

