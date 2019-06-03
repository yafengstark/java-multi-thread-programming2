package chapter01.section04.project_1_t7_is_alive;

/**
 * isAlive的使用
 */
public class IsAliveDemo {
	
	public static void main(String[] args) throws InterruptedException{
		MyThread mythread = new MyThread();
		System.out.println("begin ==" + mythread.isAlive());
		mythread.start();
		//Thread.sleep(1000);
		System.out.println("end ==" + mythread.isAlive());
	}
	
}

