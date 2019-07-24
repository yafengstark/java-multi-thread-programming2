package chapter05.section01.thread_5_1_1.project_1_timerTest1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * 执行任务的时间晚于当前的时间
 *
 *
 * 执行完，线程也不销毁
 *
 * 不是守护线程
 *
 *
 *
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());

        Calendar calendarRef = Calendar.getInstance();
        calendarRef.add(Calendar.SECOND, 10);
        Date runDate = calendarRef.getTime(); // 10秒后

        MyTask task = new MyTask();
        Timer timer = new Timer();
        //
        timer.schedule(task, runDate);

    }

}
