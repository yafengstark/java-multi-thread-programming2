package chapter01.section06.project_1_runThread;

/**
 * getId() : 线程的唯一标识
 *
 */
public class Test {

	public static void main(String[] args) {
		Thread runThread = Thread.currentThread();
		System.out.println(runThread.getName() + " " + runThread.getId() );
	}
	
}
