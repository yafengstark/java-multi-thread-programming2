package chapter02.section02.thread_2_2_8.project_1_synchronizedBlockLockAll.test1.test2;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		MyObject object = new MyObject();
		/**
		 * 锁定同一个对象
		 */
		ThreadA a = new ThreadA(service, object);
		a.setName("a");
		a.start();

		Thread.sleep(100);

		ThreadB b = new ThreadB(object);
		b.setName("b");
		b.start();
	}

}
