package chapter02.section02.thread_2_2_16.project_2_setNewPropertiesLockOne;

/**
 * 同步的
 *
 * 中间修改对象的属性，依旧是同步的
 *
 */
public class Run {

	public static void main(String[] args) {

		try {
			Service service = new Service();
			Userinfo userinfo = new Userinfo();

			ThreadA a = new ThreadA(service, userinfo);
			a.setName("a");
			a.start();

			Thread.sleep(50);

			ThreadB b = new ThreadB(service, userinfo);
			b.setName("b");
			b.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
