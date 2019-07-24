package chapter04.section01.thread_4_1_3.project_1_UseConditionWaitNotifyError;

/**
 * 使用condition实现等待、通知
 *
 * 错误用法
 *
 */
public class Run {

	public static void main(String[] args) {

		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.start();

	}


}
