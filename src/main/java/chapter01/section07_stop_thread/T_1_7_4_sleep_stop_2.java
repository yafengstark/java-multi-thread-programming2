package chapter01.section07_stop_thread;

public class T_1_7_4_sleep_stop_2 {
	
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		thread.interrupt();
		System.out.println("end!");
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			super.run();
			try {
				for(int i=0;i<100000;i++){
					System.out.println("i="+(i+1));
				}
				System.out.println("run begin");
				Thread.sleep(200000);
				System.out.println("run end");
			} catch (InterruptedException e) {
				System.out.println("先停止，再遇到了sleep!进入catch!");
				e.printStackTrace();
			}
		}
	}
}
