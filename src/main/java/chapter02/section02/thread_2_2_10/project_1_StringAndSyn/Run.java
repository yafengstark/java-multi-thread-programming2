package chapter02.section02.thread_2_2_10.project_1_StringAndSyn;

/**
 * 常量池
 *
 * 实际是一个对象
 *
 * 一般不使用string作为锁对象
 *
 */
public class Run {

	public static void main(String[] args) {

		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

	}

}
