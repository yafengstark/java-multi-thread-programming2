package chapter03.section01.therad_3_1_3.project_1_test1;

/**
 * wait()要在同步块中调用，否则会抛出异常IllegalMonitorStateException
 */
public class Test1 {

	public static void main(String[] args) {

		try {
			String newString = new String("");
			newString.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
