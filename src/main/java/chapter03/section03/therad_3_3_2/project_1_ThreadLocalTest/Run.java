package chapter03.section03.therad_3_3_2.project_1_ThreadLocalTest;

/**
 * 验证数据的隔离性
 *
 * 虽然三个线程都向t1对象中set()数据值，但每个线程还能取出自己的数据
 *
 */
public class Run {

    public static void main(String[] args) {

        try {
            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.start();
            b.start();

            for (int i = 0; i < 100; i++) {
                if (Tools.tl.get() == null) {
                    Tools.tl.set("Main" + (i + 1));
                } else {
                    System.out.println("Main get Value=" + Tools.tl.get());
                }
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    if (Tools.tl.get() == null) {
                        Tools.tl.set("ThreadA" + (i + 1));
                    } else {
                        System.out.println("ThreadA get Value=" + Tools.tl.get());
                    }
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    if (Tools.tl.get() == null) {
                        Tools.tl.set("ThreadB" + (i + 1));
                    } else {
                        System.out.println("ThreadB get Value=" + Tools.tl.get());
                    }
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Tools {

        public static ThreadLocal tl = new ThreadLocal();

    }

}
