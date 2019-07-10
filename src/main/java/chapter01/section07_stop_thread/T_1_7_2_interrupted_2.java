package chapter01.section07_stop_thread;

/**
 * interrupted()是静态方法
 *
 *
 * 具有清除状态的功能
 *
 */
public class T_1_7_2_interrupted_2 {
	
	public static void main(String[] args) {
		Thread.currentThread().interrupt(); // 使main中断

        //
		System.out.println("是否停止1？=" + Thread.interrupted());// 具有清除状态的功能

		System.out.println("是否停止2？=" + Thread.interrupted());
		System.out.println("end!");
	}

}
