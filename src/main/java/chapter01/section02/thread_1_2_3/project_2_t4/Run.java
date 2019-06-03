package chapter01.section02.thread_1_2_3.project_2_t4;

/**
 * 线程间的变量共享
 *
 * 实现投票功能的软件时，多个线程可以同时处理同一个人的票数
 *
 * 是线程不安全的。
 *
 */
public class Run {

    public static void main(String[] args) {
        MyThread mythread = new MyThread();

        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

}
