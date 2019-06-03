package chapter01.section02.thread_1_2_3.project_2_t4.safe;

import chapter01.section02.thread_1_2_3.project_2_t4.safe.MyThreadWithSafe;

/**
 *
 * 线程安全
 *
 *
 */
public class RunSafe {

    public static void main(String[] args) {
        MyThreadWithSafe mythread = new MyThreadWithSafe();

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
