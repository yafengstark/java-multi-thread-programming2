package chapter02.section01_synchronized;

/**
 * 子类可以通过可重入锁调用父类的同步方法
 */
public class T_2_1_6_synLockIn_2 {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
	}

	static  class MyThread extends Thread {
		@Override
		public void run() {
			Sub sub = new Sub();
			sub.operateISubMethod();
		}

	}

	static class Main {

		public int i = 10;

		synchronized public void operateIMainMethod() {
			try {
				i--;
				System.out.println("main print i=" + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	static class Sub extends Main {

		synchronized public void operateISubMethod() {
			try {
				while (i > 0) {
					i--;
					System.out.println("sub print i=" + i);
					Thread.sleep(100);
					this.operateIMainMethod();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
