package chapter02.section03.thread_2_3_3.project_1_t16;

/**
 * 解决server死循环的问题
 *
 */
public class Run {
    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }


    static class RunThread extends Thread {

        volatile private boolean isRunning = true;

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }

        @Override
        public void run() {
            System.out.println("进入run了");
            while (isRunning == true) {
            }
            System.out.println("线程被停止了！");
        }

    }
}
