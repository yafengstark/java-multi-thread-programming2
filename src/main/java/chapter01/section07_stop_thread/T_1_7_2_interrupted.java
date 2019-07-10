package chapter01.section07_stop_thread;

/**
 * interrupted() 是静态方法
 *
 */
public class T_1_7_2_interrupted {
	
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt(); // 并不会停止

			//Thread.currentThread().interrupt();
			System.out.println("是否停止1？="+thread.interrupted()); // 判断是否停止
			System.out.println("是否停止2？="+thread.interrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
