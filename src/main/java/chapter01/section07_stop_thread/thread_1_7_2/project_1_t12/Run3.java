package chapter01.section07_stop_thread.thread_1_7_2.project_1_t12;

/**
 * isInterrupted() 非静态方法
 * 不会清除状态
 */
public class Run3 {
	
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt();
			System.out.println("是否停止1？="+thread.isInterrupted());
			System.out.println("是否停止2？="+thread.isInterrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
