package chapter04.section01.thread_4_1_10.project_1_lockMethodTest1.test1;

/**
 * lock.getHoldCount() 调用lock方法的次数
 *
 */
public class Run {
	public static void main(String[] args) {

		Service service = new Service();
		service.serviceMethod1();
	}
}
