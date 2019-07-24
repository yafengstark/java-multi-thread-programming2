package chapter04.section01.thread_4_1_7.project_1_ConditionTest;

/**
 * 生产者消费者模式
 * 一对一
 */
public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();

		MyThreadA a = new MyThreadA(myService);
		a.start();

		MyThreadB b = new MyThreadB(myService);
		b.start();

	}
}
