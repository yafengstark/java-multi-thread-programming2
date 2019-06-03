package chapter01.section07_stop_thread.thread_1_7_3.project_3_t13_1;

/**
 * 解决异常法停止线程，语句继续运行问题
 */
public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (this.interrupted()) {
					System.out.println("已经是停止状态了!我要退出了!");
					throw new InterruptedException();
				}
				System.out.println("i=" + (i + 1));
			}
			System.out.println("我在for下面");
		} catch (InterruptedException e) {
			System.out.println("进MyThread.java类run方法中的catch了！");
			e.printStackTrace();
		}
	}
}