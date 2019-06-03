package chapter01.section04.project_1_t7_is_alive;

public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("run=" + this.isAlive());
	}
}

