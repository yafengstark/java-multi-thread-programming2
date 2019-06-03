package chapter01.section03.project_1_t6;

public class Run2 {
	public static void main(String[] args) {
		MyThread mythread = new MyThread();
//		 mythread.start(); // 输出是run方法的打印：Thread-0
		mythread.run(); // 输出是 run方法的打印：main
	}
}
