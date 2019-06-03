package chapter01.section02.thread_1_2_3.project_3_t4threadsafe;

/**
 * 线程不安全
 *
 */
public class LoginServlet {
	
	private static String usernameRef;
	private static String passwordRef;

	 public static void doPost(String username, String password) {
	//synchronized public static void doPost(String username, String password) {
		 // 线程安全 synchronized
		try {
			usernameRef = username;
			if (username.equals("a")) {
				Thread.sleep(5000);
			}
			passwordRef = password;

			System.out.println("开始验证：username=" + usernameRef + " password="
					+ passwordRef);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
