package chapter04.section01.thread_4_1_6.project_1_MustUseMoreCondition_OK;

/**
 * 使用多个Condition实现通知部分线程
 *
 * 控制部分线程行为的方便方式
 *
 *
 */
public class Run {

	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		Thread.sleep(3000);

		service.signalAll_A();

	}

}
