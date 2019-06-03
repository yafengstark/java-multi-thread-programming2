package chapter05.section01.thread_5_1_5.project_1_timerTest5;

import java.util.Timer;
import java.util.TimerTask;

public class Test4 {
	static public class MyTask extends TimerTask {
		@Override
		public void run() {
			try {
				System.out.println("begin timer = "+ System.currentTimeMillis());
				Thread.sleep(5000);
				System.out.println("  end timer = "+ System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyTask task = new MyTask();
		System.out.println("当前时间："+System.currentTimeMillis());
		Timer timer = new Timer();
		timer.schedule(task,3000,2000);
	} 
}
