package chapter01.section03.project_1_t6;

public class MyThread extends Thread {

	// 是被main线程调用的。
	public MyThread() {
		System.out.println("构造方法的打印：" + Thread.currentThread().getName());
	}

	// 取决于调用方法
	@Override
	public void run() {
		System.out.println("run方法的打印：" + Thread.currentThread().getName());
	}

}

