package chapter02.section02.thread_2_2_16.project_1_setNewStringTwoLock;

/**
 * 异步的
 *
 * 运行过程中对锁进行了修改
 *
 *
 */
public class Run1 {

	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.setName("A");

		ThreadB b = new ThreadB(service);
		b.setName("B");

		a.start();
		Thread.sleep(50);//
		b.start();
	}
}
