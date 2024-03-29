package chapter05.section01.thread_5_1_2.project_4_TimerCancelMethod;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test {
	
	public static void main(String[] args) throws InterruptedException{
		System.out.println("当前时间为：" + new Date());
		Calendar calendarRef1 = Calendar.getInstance();
		Date runDate1 = calendarRef1.getTime();
		System.out.println("计划时间为：" + runDate1);
		MyTaskA task1 = new MyTaskA();
		MyTaskB task2 = new MyTaskB();
		Timer timer = new Timer();
		timer.schedule(task1, runDate1, 2000);
		timer.schedule(task2, runDate1, 2000);
		Thread.sleep(10000);

		/**
		 * 取消所有任务
		 *
		 */
		timer.cancel();
	}
	
}
