package chapter01.section07_stop_thread.thread_1_7_2.project_1_t12;

public class Run2 {
	
	public static void main(String[] args) {
		Thread.currentThread().interrupt(); // 使main中断

        // interrupted()是静态方法
		System.out.println("是否停止1？=" + Thread.interrupted());// 具有清除状态的功能

		System.out.println("是否停止2？=" + Thread.interrupted());
		System.out.println("end!");
	}

}
